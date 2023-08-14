#!/usr/bin/env kscript

@file:Repository("https://jitpack.io")
@file:Repository("https://repo1.maven.org/maven2")
@file:Repository("https://maven.google.com")
@file:Repository("https://bintray.com/jetbrains/trove4j/trove4j")

@file:DependsOn("com.github.DevSrSouza:svg-to-compose:0.8.1")
@file:DependsOn("com.google.guava:guava:23.0")
@file:DependsOn("com.android.tools:sdk-common:27.2.0-alpha16")
@file:DependsOn("com.android.tools:common:27.2.0-alpha16")
@file:DependsOn("com.squareup:kotlinpoet:1.7.2")
@file:DependsOn("org.ogce:xpp3:1.1.6")

import br.com.devsrsouza.svg2compose.Svg2Compose
import br.com.devsrsouza.svg2compose.VectorType
import java.io.File

// Main
val opts = parseArgs(args)
val assetsDir = File(opts.source)
val srcDir = File(opts.destination)

Svg2Compose.parse(
    applicationIconPackage = opts.pkg,
    accessorName = opts.accessorName,
    outputSourceDirectory = srcDir,
    vectorsDirectory = assetsDir,
    type = opts.composeType,
    allAssetsPropertyName = opts.allName
)

//
// Parsing Arguments
//
data class MyArgs(
    val source: String,
    val destination: String,
    val accessorName: String,
    val pkg: String,
    val allName: String,
    val composeType: VectorType,
)

fun parseArgs(args: Array<String>): MyArgs {
    var source = "/source"
    var destination = "/out"
    var accessorName = "AppIcons"
    var pkg = "icons"
    var allName = "AllIcons"
    var composeType = VectorType.SVG

    var i = 0
    while (i < args.size) {
        when (args[i]) {
            "-s", "--source" -> {
                source = args[i + 1]
                i += 2
            }
            "-o", "--output" -> {
                destination = args[i + 1]
                i += 2
            }
            "-n", "--name" -> {
                accessorName = args[i + 1]
                i += 2
            }
            "-p", "--package" -> {
                pkg = args[i + 1]
                i += 2
            }
            "-a", "--all-name" -> {
                allName = args[i + 1]
                i += 2
            }
            "--svg" -> {
                composeType = VectorType.SVG
                i++
            }
            "--drawable" -> {
                composeType = VectorType.DRAWABLE
                i++
            }
            "-h", "--help" -> {
                printHelp()
                System.exit(0)
            }
            else -> i++
        }
    }

    if (source.isEmpty() || destination.isEmpty() ||
        accessorName.isEmpty() || pkg.isEmpty() ||
        allName.isEmpty()) {
        printHelp()
        System.exit(0)
    }

    return MyArgs(source, destination, accessorName, pkg, allName, composeType)
}

fun printHelp() {
    println("Usage:")
    println("  -s, --source        Source folder name (default: /source)")
    println("  -o, --output        Destination folder name (default: /out)")
    println("  -n, --name          Accessor Name (default: AppIcons)")
    println("  -p, --package       Icons package to create (default: icons)")
    println("  -a, --all-name      Name for all assets (default: AllIcons)")
    println("      --svg           Set vector type to SVG (default)")
    println("      --drawable      Set vector type to DRAWABLE")
}
