package com.example.demoheal.m02

fun main(){
    //Les variables
    val menu = mapOf(
        1 to "ajouter un film déjà vue",
        2 to "ajouter un film/serie à voir",
        3 to "Voir toute la liste",
        4 to "Quitter"
    )
    val filmsVus = mutableMapOf<String, Boolean>(
        "Le seigneur des anneaux" to true
        ,"Le seigneur des anneaux" to true
    )
    val filmsAvoirVoir = mutableMapOf<String, Boolean>()
    var choix = 0
    do {
        for ((key, value) in menu) {
            println("$key - $value")
        }
        println("Veuillez choisir une option")
        choix = readLine()!!.toInt()

        when (choix) {
            1 -> {
                println("Veuillez entrer le titre du film")
                val film = readLine()!!
                filmsVus[film] = true
                println("Le film a bien été ajouté")
            }
            2 -> {
                println("Veuillez entrer le titre du film")
                val film = readLine()!!
                filmsVus[film] = true
                println("Le film a bien été ajouté")
            }
            3 -> {
                println("films vus : ")
                for (film in filmsVus) {
                    println(film)
                }
                println("films à voir : ")
                for (film in filmsAvoirVoir) {
                    println(film)
                }
            }
            4 -> {
                println("Au revoir")
                break
            }
        }
    }while (choix != 4)


}

