**Hausübung: Fahrzeugverwaltungssystem mit CSV-Dateien**

**Ziel:**

Im Rahmen dieser Aufgabe soll ein Fahrzeugverwaltungssystem in Java
implementiert werden, das Fahrzeugdaten aus einer CSV-Datei einliest,
verarbeitet und die Ergebnisse in einer neuen Datei speichert. Dabei
werden Konzepte wie Validierung von Daten, Fehlerbehandlung und Enums
für Fahrzeugtypen verwendet. Es sollen fortgeschrittene Filtermethoden
integriert werden, um Fahrzeuge nach bestimmten Kriterien wie
Kilometerstand oder Baujahr zu durchsuchen und die Preise nach
Fahrzeugtyp anzupassen.

**Aufgabenstellung:**

Entwickle ein Programm, das ein Fahrzeugverwaltungssystem simuliert und
folgende Funktionen umfasst:

**Anforderungen:**

1.  **Fahrzeuge aus einer CSV-Datei einlesen**

    -   Die Datei enthält Informationen zu Fahrzeugen (z. B. ID, Marke,
        Modell, Fahrzeugtyp, Baujahr, Kilometerstand, Preis). Ein
        Beispiel-CSV befindet sich in der Angabe.

2.  **Fahrzeugtyp als Enum**

    -   Definiere ein Enum VehicleType für die Typen der Fahrzeuge:

        -   PKW (Personenkraftwagen)

        -   Transporter

        -   Motorrad

3.  **Datenvalidierung beim Einlesen**

    -   Stelle sicher, dass alle Spalten korrekt gefüllt sind:

        -   Keine leeren Werte.

        -   Kilometerstand und Preis dürfen nicht negativ sein.

        -   Baujahr muss ein sinnvolles Jahr (z. B. 1900--aktuelles
            Jahr) sein.

    -   Ungültige Zeilen sollen ignoriert und dem Benutzer als
        Fehlermeldung angezeigt werden.

4.  **Fahrzeuge nach bestimmten Kriterien filtern**

    -   Implementiere Funktionen, um Fahrzeuge nach Kriterien zu
        filtern:

        -   Nach Fahrzeugtyp (z. B. alle PKWs).

        -   Nach Preisbereich (z. B. 10.000--20.000 Euro).

        -   Nach Baujahr (z. B. Fahrzeuge ab 2018).

        -   Nach maximalem Kilometerstand (z. B. bis zu 50.000
            Kilometer).

5.  **Preisänderung auf Basis von Fahrzeugtypen**

    -   Erstelle eine Funktion, die für einen bestimmten Fahrzeugtyp den
        Preis um einen einstellbaren Prozentsatz erhöht oder senkt.

    -   Beispiel: Reduzierung des Preises aller Motorräder um 10 %.

6.  **Speichern der veränderten Fahrzeugdaten in eine neue CSV-Datei**

    -   Speichere die aktualisierten Fahrzeugdaten in einer neuen Datei
        (z. B. fahrzeuge_aktualisiert.csv).

7.  **Erweiterte Fehlerbehandlung**

    -   Implementiere eine umfassende Fehlerbehandlung:

        -   Ignoriere unvollständige oder fehlerhafte Zeilen in der
            CSV-Datei.

        -   Zeige eine Fehlermeldung an, welche Zeilen ignoriert wurden.

8.  **Statistische Auswertung**

    -   Durchschnittspreis: Implementiere eine Funktion, die den
        Durchschnittspreis aller Fahrzeuge oder eines bestimmten Typs
        berechnet.

    -   Anzahl Fahrzeuge pro Typ: Berechne die Anzahl der Fahrzeuge pro
        Fahrzeugtyp und gib diese aus.
