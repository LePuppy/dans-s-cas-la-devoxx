Dans s'cas là.
==============
Auteurs
-----------
* Ludwine Probst [@nivdul](https://twitter.com/nivdul)
* Mathieu Chataigner [@mchataigner](https://twitter.com/mchataigner)
* Jonathan Winandy [@ahoy_jon](https://twitter.com/ahoy_jon)
* Jean Helou [@jeanhelou](https://twitter.com/jeanhelou)

Pré-requis
------------
Vous avez besoin :
* D'une connexion internet 
* De java 6, 7 ou 8 (vous pouvez le vérifier en lançant java -version)
* De [Sublime Text 3](http://www.sublimetext.com/) (attendu par un fichier batch)
* De [git](https://git-scm.com/downloads)

Cloner le projet
------------
```git clone https://github.com/LePuppy/dans-s-cas-la-devoxx.git```

Lancer le Hands-on
------------

```cd dans-s-cas-la-devoxx```

Vous pouvez lancer le hands-on en tapant 
```init.bat``` (Windows)

Ce fichier va vous demander les droits d'admin afin d'ajouter Sublime Text au PATH pour ouvrir automatiquement l'éditeur de texte lorsque vous lancez le projet. Il exécute ensuite ```handson.bat``` qui lance le coeur du projet.

Ces scripts lancent SBT (scala build tool) en arrière plan préconfiguré avec des commandes pour jouer le hands-on. La commande principale est : 

    go

Cette commande lance le premier test et surveille les fichiers, chaque fois que vous modifiez un fichier elle rejoue le test en cours, une fois qu'un test est passé, la commande passe au test suivant.

Il y a d'autres commandes qui permettent de lancer chaque chapitre indépendament:
* ```partie1-1``` - découverte des bases du langage, variables mutables & immutables, classes, case classe et ```for expresssions```
* ```partie1-2``` - api des listes, maps, sets, option, fonctions de plus haut niveau, extracteurs et pattern matching
* ```partie2``` - comprendre le fonctionnement de map et de flatMap dans différents contextes, initiation simple à la variance
* ```partie3``` - construire une implementation de List immutable, construire un stream (liste infinie évaluée à la demande)
* ```partie4``` - (bonus) Introduction aux TypeClasses
* ```partie5``` - (bonus) Revisiter map et flatmap dans un cas plus complexe
* ```partie6``` - (bonus) Un exemple d'event sourcing

Compléter l'exercice prends plusieurs heures, n'hésitez pas a demander de l'aide sur [la mailing list du PSUG](https://groups.google.com/forum/?fromgroups#!forum/paris-scala-user-group)

