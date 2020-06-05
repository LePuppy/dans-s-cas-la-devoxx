package we_need_to_go_deeper

import support.HandsOnSuite
import util.Random
import scala.collection

/*
*   Maintenant que vous êtes un peu plus familier avec la syntaxe et que vous avez vu quelques
*   points clé de Scala, passons aux choses sérieuses avec ce premier exo...
*
*   En développement logiciel, une méthode s'applique à l'objet de la classe dans laquelle elle est définie
*   et réalise un traitement spécifique.
*   L'intéret de cette partie est d'implémenter des méthodes très pratiques comme map, filter et flatMap
*   pour la classe Sac c'est-à-dire définir le traitement qu'elles réalisent pour un objet de type Sac et les
*   paramètres qu'elles reçoivent.
*   La particularité de ces trois méthodes est qu'elles reçoivent chacune une fonction en paramètre.
*
*   Il faut implémenter c'est-à-dire compléter les parties avec des ???
*   mais avant cela il faut compléter les __ des tests en bas !
*
*/
class e0_une_histoire_de_sacs /* ou un sac de sac */ extends HandsOnSuite {

  case class Sac(contenu:Int) {

    /**
     * On veut implémenter la méthode map ci-dessous. En analysant la définition de la méthode, quelles informations
     * obtient-on ? (Solution plus bas)
     */
    def map(fonction:Int => Int):Sac = ???

    /**
     * On sait que :
     * - map prend en paramètre une fonction qui se nomme 'fonction'
     * - fonction manipule le type Int en entrée et renvoie le type Int
     * - map renvoie un Sac
     *
     * La méthode map permet donc d'appliquer n'importe quelle fonction Int => Int à un objet Sac et ce, peu importe
     * ce qu'elle fait ! Incroyable non ?
     *
     * Maintenant, il va falloir l'implémenter cette méthode map. Quelques conseils supplémentaires :
     *
     * Tip 1 :
     * Comme l'objet Sac ne possède d'un attribut : "contenu" de type Int, fonction manipule seulement contenu.
     * Pour récupérer la valeur de l'attribut d'un objet, on écrit : monObjet.attribut Cf exercice plus bas
     *
     * Tip 2 :
     * A l'intérieur d'une classe, on fait référence à l'objet défini dans cette classe par le mot-clé "this"
     *
     *
     * Es-tu maintenant capable de dire quels mots-clés tu vas utiliser pour implémenter map ?
     *
     * Toujours pas ?
     *
     *
     *
     * Bon allez : fonction, contenu, this et Sac
     *
     * (solution plus bas, essaye vraiment de trouver tout seul)
     *
     *
     *
     *
     *
     *
     * ## Solution ##
     * def map(fonction:Int => Int):Sac = Sac(fonction(this.contenu))
     */

    /**
     * Suivant : méthode flatMap
     * Si tu as compris l'idée pour map, tu vas également comprendre à quoi sert flatMap
     * Tout d’abord un petit rappel sur la fonction flatten, puisque “flatmap” n’est rien d’autre que la combinaison
     * des fonctions flatten et map.
     * L’opération
     *      List(List(1, 3), List(2, 4)).flatten
     *
     * renvoie la liste List[Int] suivante :
     *      List(1, 3, 2, 4)
     * La méthode flatten s’applique en fait à une liste de listes, et applatit le tout en une liste.
     *
     * Maintenant qu'on a vu la méthodologie pour implémenter ces méthodes (bien analyser la définition de la méthode),
     * je te laisse la refaire pour celle-ci.
     * */
    def flatMap(fonction:Int => Sac):Sac = ???

    /**
     * Tu n'as pas réussi ? Pas de soucis. Demande toi ceci : quelle est la différence avec la méthode map ?
     *
     * Exactement : fonction ici manipule un type Int et renvoie un type Sac (sa signature est : Int => Sac)
     * flatMap, comme map, renvoie un Sac en sortie
     *
     * Que permet donc l'implémentation de flatMap ? Cf ligne 38
     *
     * -> flatMap permet d'appliquer à un Sac toute fonction Int => Sac et ce, quel que soit ce qu'elle réalise !
     *
     * Tip :
     * A-t-on toujours besoin du mot-clé Sac comme pour map ? Attention à bien lire la signature de fonction
     *
     * (solution plus bas, essaye vraiment de trouver tout seul)
     *
     *
     *
     *
     *
     *
     * ## Solution ##
     * def flatMap(fonction: Int => Sac):Sac = fonction(this.contenu)
     */
  }


  exercice("Je peux créer mon sac avec un seul entier, et faire des choses avec mon sac") {

    val monPetitSacDeZero = Sac(0)

    monPetitSacDeZero.contenu should be(0)

    monPetitSacDeZero.copy(1) should be(__)

    def incrémenteUnSac(sac:Sac):Sac = sac.copy(sac.contenu + 1)

    incrémenteUnSac(monPetitSacDeZero).contenu should be(__)

  }

  exercice("je peux appliquer une fonction à l'intérieur de mon sac") {
    /**
     *
     * Pour passer ce test (deuxième should be) il faut implémenter la fonction Map plus haut
     */
    val incrémente:(Int => Int) = (i:Int) => i + 1
    //l'équivalent avec def est :
    def incrémenteAvecDef(i:Int) = i + 1


    incrémente(0) should be(__)

    val monPetitSacDeZero = Sac(0)

    monPetitSacDeZero.map(incrémente).contenu should be(__)
  }

  exercice("je peux appliquer une expression en for sur mon sac") {
    /**
     * Ce test se base sur la fonction map implémentée précedement
     */

    val monPetitSacDeZero = Sac(0)

  

    val plus:Int = 12345

    val monPetitSacDeUn  = (for (i <- monPetitSacDeZero) yield (i + plus))

    /*
     * Le compilateur scala traduit cette boucle for par :
     *
     * monPetitSacDeZero.map(i => {plus + i})
     */

    monPetitSacDeUn.contenu should be(__)

  }

  exercice("je peux appliquer une expression imbriquée dans mes Sac") {

    /**
     * Ce test se base sur la fonction flatMap a implémenter plus haut.
     */


    val monPetitSacDeDeux = Sac(2)
    val monGrosSacDeCent = Sac(100)

    val l_union_de_mes_sac = for (p <- monPetitSacDeDeux; g <- monGrosSacDeCent) yield( p * g)

    /**
     * Le compilateur scala traduit cette boucle for par :
     *
     * monPetitSacDeDeux.flatMap{ p => monGrosSacDeCent.map(g => p *g))
     */

    l_union_de_mes_sac.contenu should be(__)
  }

}
