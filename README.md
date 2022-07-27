# edsEdit
### Editor für parametrisierte Entscheidungen kundenspezifischer Produktmodelle

Der Editor ermöglicht das darstellen, sortieren, filtern und ändern, sowohl der Reihenfolge als auch der Werte einzelner Parameter innerhalb von Listen parametrisierter Entscheidungen, für das proprietäre Dateiformat *".eds" (Engineering & Configuration Decision State)*, um die Möglichkeit zu bieten, Testfälle zu erschaffen, ohne dass dabei jedes Mal manuell ein Produktkonfigurationsprozess durchlaufen werden muss.

![](https://github.com/MoritzNiggemeier/edsEdit/blob/main/screenshot.png?raw=true)

![](https://github.com/MoritzNiggemeier/edsEdit/blob/main/classdiagram.png?raw=true)

Während eines Produktkonfigurationsprozesses wird eine Liste mit parametrisierten Entscheidungen angelegt, die den Benutzerentscheidungen entsprechen und so eine Art Pfad von „der Gesamtheit der möglichen Produktkonfigurationen“ zu „einem konkret und absolut definierten Produkt“ aufzeigen. Diese Liste wird im Laufe des Konfigurationsprozesses mit weiteren automatisch eingefügten parametrisierten Entscheidungen angereichert, die sich aus der modellierten Logik des Produkts ergeben. Der Produktkonfigurationsprozess kann je nach Produkt relativ umfangreich ausfallen. Zudem kann der Konfigurationsprozess durch Konfigurationselemente, wie z.B. 3D-Modelle von Produkten bei denen eine Positionierung von Objekten im Raum nötig ist, weiter verlangsamt werden. Das Erstellen eigentlich einfacher Testfälle erfordert also relativ viel Zeitaufwand. Darüber hinaus können einige der parametrierten Entscheidungen gar nicht verändert werden, z.B. wenn das System Entscheidungen aufgrund von getroffenen Benutzerentscheidungen automatisch trifft und diese anschließend nicht mehr vom Benutzer verändert werden können.

Dieses Verhalten mag zwar in vielen Fällen erwünscht sein - für Testentwickelnde kann es jedoch durchaus attraktiv sein, bewusst Fehlkonfigurationen zu erzeugen um das Verhalten der Anwendung zu testen. Der Editor ermöglicht es, vorhandene EDS-Dateien zu bearbeiten, um daraus mit relativ geringem Aufwand eine Vielzahl an leicht veränderten EDS-Dateien zu erzeugen, die dann als Testfälle gegen die Anwendung genutzt werden können. Der Editor stellt dabei die Gesamtheit der in der Liste abgelegten parametrisierten Entscheidungen dar – nicht nur die vom Benutzer getroffenen. 

