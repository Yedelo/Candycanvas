@file:OptIn(StonecutterExperimentalAPI::class)

import dev.kikugie.stonecutter.StonecutterExperimentalAPI
import org.gradle.api.tasks.Copy
import org.gradle.kotlin.dsl.invoke
import kotlin.reflect.KProperty
import me.modmuss50.mpp.ReleaseType

plugins {
	id("dev.kikugie.loom-back-compat")
	id("me.modmuss50.mod-publish-plugin")
}

repositories {
	maven("https://maven.terraformersmc.com/releases/")
	maven("https://maven.isxander.dev/releases")
	maven("https://api.modrinth.com/maven")
}

// in stonecutter.gradle.kts
class CommonProperty<T> {
	operator fun getValue(thisRef: Any?, property: KProperty<*>): T = (rootProject.extra[sc.current.project] as Map<String, Any?>)[property.name] as T
}

val rangedVersion by CommonProperty<Boolean>()
val maxMc by CommonProperty<String?>()
val javaVersion by CommonProperty<JavaVersion>()
val smclVersion by CommonProperty<String>()
val finalFileName by CommonProperty<String>()
val versionType: String by project
val modrinthReadme by CommonProperty<String>()
val license: String by project
val modDescription: String by project

dependencies {
	minecraft("com.mojang:minecraft:${sc.current.version}")
	loomx.applyMojangMappings()
	modImplementation("net.fabricmc:fabric-loader:${property("versions.fabricLoader")}")
	modImplementation("net.fabricmc.fabric-api:fabric-api:${property("versions.fabricApi")}")
	modImplementation("maven.modrinth:supermartijn642s-config-lib:$smclVersion-fabric-mc${sc.current.version}")
}

loom {
	runConfigs {
		"client" {
			runDir = "../../run/client"
		}
		"server" {
			runDir = "../../run/server"
		}
	}
}

tasks {
	processResources {
		fun MutableMap<String, String>.register(key: String, value: String) {
			inputs.property(key, value)
			set(key, value)
		}
		exclude("META-INF/neoforge.mods.toml")

		fun target(version: String) = ">=$version"
		val props = buildMap {
			register("version", version.toString())
			register("modDescription", modDescription)
			register("license", license)
			register("java", target(javaVersion.majorVersion))
			register("fabricLoader", target(sc.properties["versions.fabricLoader"]))
			val minecraftDependency =
				if (rangedVersion) ">=${sc.current.version} <=${maxMc}" else sc.current.version
			register("minecraft", minecraftDependency)
			register("smcl", target(smclVersion))
		}
		filesMatching(listOf("fabric.mod.json")) { expand(props) }

		val mixinJava = "JAVA_${javaVersion.majorVersion}"
		filesMatching("candycasts.mixins.json5") { expand("mixinJava" to mixinJava) }

        outputs.upToDateWhen { false }
	}

	register<Copy>("buildAndCollect") {
		group = "build"

		from(loomx.modJar.map { it.archiveFile })
		into(rootProject.layout.buildDirectory.file("libs"))
		dependsOn("build")
	}
	loomx.modJar {
		archiveFileName.set(finalFileName)
	}
}

publishMods {
	file.set(loomx.modJar.map { it.archiveFile.get() })
	changelog.set(rootProject.file("CHANGELOG.md").readText())
	type.set(ReleaseType.of(versionType))
	modLoaders.add("fabric")

	modrinth {
		displayName.set("${project.version.toString()} for Fabric ${sc.current.version}")
		accessToken = System.getenv("MODRINTH_TOKEN")
		projectId.set("SzgU2Fvt")
		environment = SERVER_ONLY
		projectDescription = modrinthReadme
		if (rangedVersion) {
			minecraftVersionRange {
				start = sc.current.version
				end = maxMc
			}
		}
		else {
			minecraftVersions.add(sc.current.version)
		}

		requires("fabric-api")
	}
}

java {
	sourceCompatibility = javaVersion
	targetCompatibility = javaVersion
}