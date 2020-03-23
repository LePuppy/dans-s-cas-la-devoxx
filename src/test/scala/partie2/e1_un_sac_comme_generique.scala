package we_need_to_go_deeper

import support.HandsOnSuite

class e1_un_sac_comme_generique  extends  HandsOnSuite {

 // Dans cette partie on manipule toujours des Sacs dont on précise le type qu'ils contiennent et qu'on manipule avec des fonctions comme map ou flatMap.  
 // Sac[A] est un "Sac de A" . Par exemple, Sac[Boule] est un Sac de ... ? Si vous avez deviné, vous êtes prêt pour la suite.

  case class Sac[A](contenu:A) {

    // Petite aide pour le premier
    def map[B](fonction: A => B):Sac[B] = Sac(fonction(this.contenu))

    def flatMap[B](fonction: A => Sac[B]):Sac[B] = ???

  }


  exercice("Un peu comme avant, l'application de fonction dans le conteneur") {
    val petitSacDeZero = Sac(0)

    petitSacDeZero.map(x => x + 1).contenu should be(__)

  }

  exercice("La combinaison de Sac") {

    val petitSacDeZero = Sac(0)

    val grandSacDeA = Sac("A")

    val combinaison = for (p <- petitSacDeZero; g <- grandSacDeA) yield { p.toString + g}


    combinaison.contenu should be(__)
  }

}
