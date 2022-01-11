#!/usr/bin/env kscript

val params = "toto titi tutu tata tete tonton toutou"

args.run {
    if (size > 0) {
        println("Arguments:")
        forEachIndexed { i: Int, arg: String ->
            println("arg #${i + 1}: $arg")
        }
    }
}