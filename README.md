Projekt von Zogheib, Jann, Nils und Rolf Kaufmann

Wie starten:
1) Im Terminal Ordner "Docker" öffnen und "docker compose up" eingeben um mit docker-compose.yml zu builden
2) Port suchen, auf dem Phpmyadmin läuft. (Bei mir 80)
3) In Browser "localhost:[Port]" öffnen 
4) Eine neue Datenbank namens "Mitglieder" erstellen
5) Mitglieder.sql (aus Docker Ordner) importieren
6) In IntelliJ unter "src/main/java/ch.bbw.jr/mitglied/" die Klasse "ProjektApplication" starten
7) In Browser "localhost:9090" öffnen
