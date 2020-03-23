package we_need_to_go_deeper

import support.HandsOnSuite
import util.Random
import scala.collection

/*
*   Maintenant que vous êtes un peu plus familier avec la syntaxe et que vous avez vu quelques
*   points clé de Scala, passons aux choses sérieuses avec ce premier exo...
*
*   Il faut implémenter les parties avec des ???
*   mais avant cela il faut compléter les __ des tests en bas !
*
*/
class e0_une_histoire_de_sacs /* ou un sac de sac */ extends HandsOnSuite {

  case class Sac(contenu:Int) {

    /**
     * @param fonction la fonction a appliquer à contenu
     * @return un Sac
     *
     * Pour faire référence à l'objet dans la définition de la classe (et dans les fonctions définies à l'intérieur),
     * il existe le mot-clé 'this'
     *
     * La fonction map ci-dessous doit renvoyer un Sac auquel la fonction anonyme Int: => Int (qui à un Int renvoie un Int) a été appliquée.
     */
    def map(fonction:Int => Int):Sac = ???

   /**
     *  Tout d’abord un petit rappel sur la fonction flatten, puisque “flatmap” n’est rien
     *  d’autre que la combinaison des fonctions flatten et map.
     *  L’opération
     *       List(List(1, 3), List(2, 4)).flatten
     *
     *  renvoie la liste List[Int] suivante
     *       List(1, 3, 2, 4)
     *  La méthode flatten s’applique en fait à une liste de listes, et l'applatir en une liste.
     *
     * @param fonction Hum hUm, la fonction à appliquer en fusionnant les contextes d'application
     (ici Sac) entre eux...
     * @return un Sac !
     *
     * La fonction flatMap ci-dessous renvoie un Sac auquel on a appliqué la fonction anonyme Int => Sac (qui à un Int renvoie un Sac)
     */
    def flatMap(fonction:Int => Sac):Sac = {
      ???
    }
  }


  exercice("Je peux créer mon sac avec un seul entier, et faire des choses avec mon sac") {

    val monPetitSacDeZero = Sac(0)

    monPetitSacDeZero.contenu should be(__)

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
