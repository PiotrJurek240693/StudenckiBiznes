# StudenckiBiznes
Studencka wersja gry Monopoly.

(dopóki nie ma maven)
aby uruchomić grę należy:
1) pobrać javafx sdk 20.0.1 do ścieżki C:\Program Files\Java\javafx-sdk-20.0.1
2) sklonować repozytorium zdalne na swój komputer
3) uruchomić projekt w intelij IDEA
4) rozwinąć listę rozwijalną w prawym górnym rogu z napisem "Main"
5) kliknąć "Edit Configurations..."
6) kliknąć niebieski napis "Modify Options", a następnie "Add VM Options"
7) w opcję VM należy wkleić:
            --module-path "C:\Program Files\Java\javafx-sdk-20.0.1\lib" --add-modules javafx.controls,javafx.fxml
8) Apply i Ok
9) uruchomić Main.java
