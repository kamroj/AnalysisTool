# AnalysisTool
> Program do analizy i zliczania nakładu pracy.
[![Build Status](https://travis-ci.org/kamroj/AnalysisTool.svg?branch=mergin-work)](https://travis-ci.org/kamroj/AnalysisTool)

## Spis treści
* [Podstawowe informacje](#podstawowe-informacje)
* [Technologie](#technologie)
* [Pomoc](#pomoc)
* [Przykłady użycia](#przykłady-użycia)
* [Funkcje](#funkcje)
* [Status](#status)
* [Inspiracja](#inspiracja)
* [Kontakt](#kontakt)

## Podstawowe informacje
Tworzenie raportów na podstawie danych zawartych w plikach Excel. 
Raporty tworzone zawierają wyszczególnienie ilości godzin danego pracownika na dany projekt oraz ilość godzin wszystkich pracowników na konkretny projekt.

## Technologie
* Java - version 1.8

## Pomoc
# Konsola
W pierwszej kolejności klient podaje ścieżkę do folderu z danymi, czyli plikami Excel.

W drugiej kolejności po spacji klient podaje parametr rodzaju wydruku:
* -c - Tworzenie raportu w konsoli
* -xls - Tworzenie raportu do pliku Excel
* -p - Tworzenie raportu do pliku PDF

W trzeciej kolejności po spacji klient podaje parametr raportu do utworzenia:
* -re1 - Tworzenie raportu 1 - Osoba+godziny pracy we wszystkich projektach
* -rp2 - Tworzenie raportu 2 - Projekt+godziny pracy wszystkich programistów
* -re3 - Tworzenie raportu 1+3 - Osoba+godziny pracy w danych projektach
* -rp4 - Tworzenie raportu 2+4 - Szczegółowy raport dla projektów

# Plik wykonywalny JAR
Gotowy wykonywalny plik JAR do użycia w konsoli systemowej oraz w programie zewnętrznym 

## Przykłady użycia
# Konsola
* Give path: C:\Users\student7\Downloads\Pracownia projektowa BK\AnalysisTool\reporter-dane -c -re1
* Give path: C:\Users\student7\Downloads\Pracownia projektowa BK\AnalysisTool\reporter-dane -xls -rp2
* Give path: C:\Users\student7\Downloads\Pracownia projektowa BK\AnalysisTool\reporter-dane -p -re3
* Give path: C:\Users\student7\Downloads\Pracownia projektowa BK\AnalysisTool\reporter-dane -c -rp4

# Plik wykonywalny JAR
* java -jar C:\Users\student7\Downloads\Pracownia projektowa BK\AnalysisTool\AnalysisTool.jar -c -rp2
* java -jar C:\Users\student7\Downloads\Pracownia projektowa BK\AnalysisTool\AnalysisTool.jar -p -re1
* java -jar C:\Users\student7\Downloads\Pracownia projektowa BK\AnalysisTool\AnalysisTool.jar -xls -rp4
* java -jar C:\Users\student7\Downloads\Pracownia projektowa BK\AnalysisTool\AnalysisTool.jar -c -re4

## Funkcje
Lista funkcji gotowych:
* Tworzenie raportu 1 - Osoba+godziny pracy we wszystkich projektach
* Tworzenie raportu 2 - Projekt+godziny pracy wszystkich programistów
* Tworzenie raportu 1+3 - Osoba+godziny pracy w danych projektach
* Tworzenie raportu 2+4 - Szczegółowy raport dla projektów
* Filtrowanie po latach oraz miesiącach
* Zapis do pliku Excel
* Zapis do pliku PDF

Do zaimplementowania w przyszłości:
* Raport 5 - Zadania+ilość godzin spędzonych nad zadaniem
* Filtrowanie wyszukiwania danych po wyborze konkretnego projektu
* Wykresy

## Status
Projekt: w trakcie budowy.

## Inspiracja
Projekt zainspirowany przez klienta Pracowni projektowej AGH Metody Wytwarzania Oprogramowania

## Kontakt
Stworzone przez Spocone Koguty!