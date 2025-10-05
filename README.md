# Modul 323 - Funktionales Projekt

## Inhaltsverzeichnis
1. [Einführung](#Einführung)
2. [Installation](#Installation)
3. [Autor](#Autor)
4. [Weiterführende Dokumentation und Präsentationsmaterial](#Dokumentation)

## Einführung
Dieses Projekt ist eine Konsolenanwendung in Scala, welche es ermöglicht, Filme und Schauspieler zu verwalten.\
Die Menüführung ist hierbei selbsterklärend, die einzugebenden Menüpunkte sind immer erklärt.

Das Programm ist dabei in folgende Teile unterteilt:
- Einen prozeduralen Teil mit Nebeneffekten
- Einen funktionalen Teil mit reinen Funktionen und Rekursion
- Die Datentypen, in denen die Werte gespeichert werden.

Im prozeduralen Teil sind hierbei die UI-Logik, Ein-/Ausgabe und weitere Elemente mit Nebeneffekten implementiert.

Im funktionalen Teil sind die Models, die funktional wie möglich geschrieben sind. Die einzige veränderbare Komponente sind hier die ListBuffers, zu welchen man Elemente hinzufügen oder entfernen kann.

Die Datentypen sind als Case Classes mit unveränderbaren Werten umgesetzt. Bei einer Änderung wird das gesamte Objekt an dieser Stelle ausgetauscht.

## Installation
Nachdem das Projekt geklont und in IntellJ IDEA geöffnet wurde, kann die Einstiegsfunktion in der Datei `MovieDBMain.scala` ausgeführt werden.

## Autor
*Leonardo Evic*\
[GitHub](https://www.github.com/leoevic)\
[Website](https://www.leonardoevic.com)

## Weiterführende Dokumentation und Präsentationsmaterial
Siehe `/docs`