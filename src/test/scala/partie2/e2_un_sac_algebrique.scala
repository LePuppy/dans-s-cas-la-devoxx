package we_need_to_go_deeper

import support.HandsOnSuite


class e2_un_sac_algebrique extends HandsOnSuite {

 /**
   * Un type algébrique (ici Sac) est un type composé ici par l'union disjointe de SacVide et SacPlein.
   * Cela veut dire que Sac est forcement un SacVide ou un SacPlein.
   */

  /**
  *   Alors là vous avez peut-être remarqué les mots sealed et trait :
  *     - trait est le mot-clé utilisé pour définir l'équivalent d'une interface en Java.
  *       Il est cependant possible d'implémenter des méthodes dans un trait.
   *      Cela permet de créer des sous types mais sans créer de classe de base.
   *      Exemple : trait Animal
   *      case class Vertebre
   *      case class Mamifere
   *      etc...
  *
  *     - sealed est un mot clé utilisé devant un trait. Le compilateur ne regardera que les case classes
  *       étendant le trait présent dans ce fichier source là, et si des cas manquent lors du Pattern
  *       Matching, un warning est remonté.
  *
  */
  sealed trait Sac {

    /**
     *
     * Ici on définit différentes méthodes pour le trait Sac sans pour autant les implémenter i.e. définir le
     * traitement qu'elles réalisent
     */

    def map(fonction:Int => Int):Sac

    def flatMap(fonction:Int => Sac):Sac

    def filter(fonction:Int => Boolean):Sac

    def contenuOuSinon(replacement:Int):Int

  }
  /**
   *
   * On définit l'objet Sac ainsi que les case object SacVide et SacPlein
   * L'utilisation du case ici permet de définir tous les types de Sacs ; un Sac est soit vide, soit plein
   */
  object Sac {
    def apply(contenu:Int):Sac = SacPlein(contenu)
  }

  /**
   *
   * Il faut implémenter les méthodes Cf parties précédentes
   *
   * Remarque :
   * Appliquer une fonction à une Sac ne va pas changer la nature du Sac : un SacVide restera un SacVide
   * et ainsi pour un SacPlein
   *
   * Pour SacVide, avec un peu de bon sens, on comprend vite que c'est direct
   */

  case object SacVide extends Sac {

    override def map(fonction:Int => Int):Sac = ???

    override def flatMap(fonction:Int => Sac):Sac = ???

    override def filter(fonction:Int => Boolean):Sac = ???

    override def contenuOuSinon(replacement:Int):Int = replacement
  }

  case class SacPlein(contenu:Int) extends Sac {

    override def map(fonction:Int => Int):Sac = ???

    override def flatMap(fonction:Int => Sac):Sac = ???

    override def filter(fonction:Int => Boolean):Sac = ???

    override def contenuOuSinon(replacement:Int):Int = contenu
  }


  exercice("toujours comme avant, je peux construire mon Sac")  {
    val s0 = Sac(0)    // appel de la fonction apply dans l'objet companion de Sac
                                         // un peu comme List(1,2,3)

  }

  exercice("toujours comme avant, je peux appliquer une fonction à l'intérieur") {

    val sacDeZero = Sac(0)

    // Comme on l'utilise souvent dans l'exercice et en Scala, une petite explication sur le pattern matching :
    // C'est un mécanisme qui permet de controller une valeur par rapport à un modèle. Une correspondance réussie permet
    // également de déconstruire une valeur en sous éléments

    //Le sealed sur le trait Sac rend ce pattern matching exhaustif
    // Il faut lire les lignes ci-dessous comme :
    // "Pour la variable sacDeZero à laquelle j'applique la fonction map(x => x + 1) :
    // - si le résultat est de type SacPlein avec un contenu "contenu", alors contenu doit valoir 1
    // - si le résultat est de type SacVide, alors retourner une erreur (ce cas ne devrait pas arriver "normalement"
    // mais on l'encapsule quand meme et c'est une bonne pratique)
    sacDeZero.map(x => x +1) match {
      case SacPlein(contenu) => contenu should be(1)

      case SacVide => fail("Cela ne devrait pas être un Sac Vide")
    }

    val sacVide=SacVide

    // case _ permet d'encapsuler tous les autres cas
    sacVide.map(x=>x+1) match {
      case SacPlein(_) => fail("Cela ne devrait pas être un Sac Plein")
      case _ => Unit
    }
  }

  exercice("toujours comme avant, je peux combiner mes sac") {
    val sacDeDeux = Sac(2)

    val sacDeCent  = Sac(100)

    val combinaison = for (deux <- sacDeDeux; cent <- sacDeCent) yield( deux * cent )

    combinaison match {
      case SacPlein(contenu) => {
        contenu should be (__)
      }

      case _ => fail("ne doit pas être vide")
    }
    val sacVide=SacVide
    val combinaisonVide = for (deux <- sacVide; cent <- sacDeCent) yield( deux * cent )
    combinaisonVide match {
      case SacPlein(_) => fail("ne doit pas être plein")
      case _ => Unit
    }

  }

  exercice("on peut filter le contenu d'un sac") {

    val sacDeDeux = Sac(2)

    val sac = sacDeDeux.filter(x => x > 10)

    sac match {
      case SacPlein(_) => fail("Cela devrait être une sac vide")
      case _  => Unit
    }

    sacDeDeux.filter(x => x > 1) match {
      case SacVide => fail("Cela doit être un sac plein")
      case _ => Unit
    }

  }

}
