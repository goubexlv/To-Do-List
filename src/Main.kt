
data class Tache(var nom : String? , var status :String = "en cour")
var taches  = mutableListOf<Tache>()
//Fonction pour afficher les options de choix
fun optionChoix(){
    println(
            "\t=====================================")
    println("   \t \uD83D\uDE04 Menus     ")
    println("\t=====================================\n")
    println("\n \t1-  Ajouter une tache \n" +
            "\t2-  Afficher toutes les taches\n" +
            "\t3-  Terminer une tache \n" +
            "\t4-  Supprimer une tache\n" +
            "\t5-  Vider les taches \n" +
            "\t99- Quitter le programme")
}

//Fonction pour afficher toutes les taches
fun afficherTaches(){
    var i = 1
    println("\tTache | nom tache | status\n" )
    for (tache in taches){
        println("\t ${i} | ${tache.nom} | ${tache.status}")
        i++
    }
}

//Fonction pour supprimer une tache
fun supprimerTache(index : Int?){
    if(verifieIndex(index) == true)
        if (index != null){
            taches.removeAt(index-1)
            println("Suppressions de la tache  \uD83D\uDC4D ")
        }


}

//Fonction pour terminer une tache
fun terminerTache(index: Int?){
    if(verifieIndex(index) == true)
        if (index != null) {
            taches[index - 1] = taches[index - 1].copy(status = "Terminer")
            println("Status de la tache modifier  \uD83D\uDC4D ")
        }

}

fun verifieIndex(index : Int?) : Boolean{

    if (index != null)
        if (index-1 in taches.indices) {
            return true
        } else {
            println("\tTache non trouver ! \uD83D\uDC4E")
            return false
        }
    return false
}

fun main() {

    // Affichage du message de bienvenue
    println("\n\n" +
            "\n" +
            "\n\t=====================================")
    println("   \t \uD83D\uDC4B Bienvenue a ta To-Do List     ")
    println("\t=====================================\n")


    var continu = 2
    do{

        //appel de la fonction des taches
        optionChoix()
        println("\tEntrez votre choix :")
        try {
            var choix = readLine()?.toInt() ?: throw NumberFormatException("\t \uD83D\uDE22 Entrée vide")

            when (choix) {
                1 -> {
                    println(
                        "\t=====================================")
                    println("   \t \uD83D\uDCE5 Ajouter une tache    ")
                    println("\t=====================================\n")
                    println("\tEntrez le nom de la Tache :")
                    var nomTache = readLine() ?: throw NumberFormatException("\t \uD83D\uDE22 Entrée vide")
                    taches.add(Tache(nomTache))

                }
                2 -> {
                    println(
                        "\t=====================================")
                    println("   \t \uD83D\uDCDA Liste des Taches     ")
                    println("\t=====================================\n")
                    afficherTaches()
                }
                3 -> {
                    println(
                        "\t=====================================")
                    println("   \t  \uD83D\uDC4D Marquer terminer une tache    ")
                    println("\t=====================================\n")
                    afficherTaches()
                    println("\tEntrez l'index de la tache a terminer :")
                    try {
                        var index = readLine()?.toInt() ?: throw NumberFormatException("\t \uD83D\uDE22 Entrée vide")
                        terminerTache(index)
                    } catch (e: NumberFormatException) {
                        println("\t Erreur : \uD83D\uDE21 Vous devez entrez un choix valide.")
                    }
                }
                4 -> {
                    println(
                        "\t=====================================")
                    println("   \t \uD83D\uDDD1\uFE0F Suppression d'une tache    ")
                    println("\t=====================================\n")
                    afficherTaches()
                    println("\tEntrez l'index de la tache a supprimer :")

                    try {
                        var index = readLine()?.toInt() ?: throw NumberFormatException("\t \uD83D\uDE22 Entrée vide")
                        supprimerTache(index)
                    } catch (e: NumberFormatException) {
                        println("\t Erreur : \uD83D\uDE21 Vous devez entrez un choix valide.")
                    }
                }
                5 -> taches.clear()
                99 -> {
                    continu = 99
                }
                else -> {
                    println("\t \uD83D\uDE22 Choix non disponiblr")
                }

            }
        }catch (e: NumberFormatException){
            println("\t Erreur : \uD83D\uDE21 Vous devez entrer un choix valide.")
        }


    }while(continu == 2)

}