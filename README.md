# S2.02-Exploration-algorithmique-de-probleme

ROHR Valentin
GEHIN Loïc

Projet de calcul de chemin le plus court en programmation java. Articulé autour de 2 méthodes de calculs principales : BellmanFord et Dijkstra, c'est 2 algorithmes de calcul détermine le chemin le plus cours entre 2 noeuds a l'aide d'arc entre different noeuds. Ces méthodes de calcul une fois codé sont utilisé dans un main affichant le chemin noeuds par noeuds, ce chemin est utilisé par une interface codé en python et une page web en html pour affiché sur une carte de Nancy le chemin de bus du réseau stan le plus court.


Le code est séparé en 3:
- sources, les fichiers python et html du GUI, les .jar y sont aussi MainTransport.jar étant le plus importants car résultat final
- src, la ou les fichiers java que nous avons écris sont
- test, la ou notre fichier de test est présent
Pour compiler le code source et générer le fichier exécutable MainTransport.jar, placez-vous dans le répertoire contenant les fichiers .java et tapez les commandes suivantes dans le terminal 
```
compilation (dans src et test): 
javac *.java

creation jar:
jar cfe ../sources/SAE-2.02-GUI/MainTransport.jar MainTransport *.class

cd ../sources/SAE-2.02-GUI


```


pour les tests l'utilisation d'un IDE est possible ou ce code a la racine du projet
```
java -jar junit-platform-console-standalone-1.9.3.jar -cp src/ -c testGrapheListe
```

