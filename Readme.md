# Evidence docházky – databázová aplikace (D1)

Tento projekt je databázová aplikace pro evidenci docházky studentů ve výuce.  
Projekt byl vytvořen jako součást studentského portfolia a splňuje zadání **D1 – vlastní implementace Data Access Object (DAO) patternu**.

Aplikace pracuje se skutečnou relační databází, využívá transakce, databázové pohledy (VIEW), import dat ze souborů a konfigurační soubor.

---

## Označení zadání

**D1 – Data Access Object (DAO) pattern**

Projekt nepoužívá žádné hotové ORM nebo databázové frameworky (např. Entity Framework, Hibernate, Dapper).  
Veškerá komunikace s databází je realizována pomocí vlastních DAO tříd a ručně psaných SQL dotazů.

---

## Cíl aplikace

Cílem aplikace je:
- správa studentů, učitelů a předmětů
- evidence konkrétních vyučovacích hodin
- zápis docházky studentů
- generování souhrnných reportů
- ukázka práce s transakcemi nad více tabulkami
- import dat z externích souborů

Aplikace je navržena tak, aby byla použitelná běžným uživatelem bez technických znalostí databází.

---

## Použité technologie

- Programovací jazyk: Java
- Databázový systém: MySQL nebo MariaDB
- Přístup k databázi: JDBC (vlastní DAO implementace)
- Datové formáty importu: CSV, XML
- Uživatelské rozhraní: konzolová aplikace

---

## Struktura projektu
/src

├─ model – datové třídy

├─ dao – DAO třídy (SQL + mapování)

├─ service – aplikační logika a transakce

├─ importer – import CSV a XML

├─ report – čtení reportů z VIEW

├─ util – konfigurace, DB připojení, logger

└─ Main.java – spouštěcí třída

/sql

├─ schema.sql – vytvoření databáze a tabulek

└─ views.sql – databázové pohledy

/config

└─ config.properties

/doc

└─ Dokumentace.txt

/test

└─ testovací scénáře (PDF)



---

## Databáze

Aplikace používá relační databázi MySQL nebo MariaDB.  
Databáze obsahuje minimálně pět tabulek, včetně vazební tabulky M:N.

Použité datové typy:
- řetězec (VARCHAR)
- datum / čas (DATE, DATETIME)
- logická hodnota (BOOLEAN)
- výčet (ENUM)
- reálné číslo (FLOAT)

### Vytvoření databáze


#### Import struktury databáze:

SOURCE sql/schema.sql;

SOURCE sql/views.sql;

### Konfigurace aplikace

##### Aplikace je konfigurována pomocí souboru:


/config/config.properties

Příklad:

db.url=jdbc:mysql://localhost:3306/dochazka_db

db.user=dochazka_user

db.password=heslo

school.year=2024/2025


## Uživatelské rozhraní

### Aplikace používá konzolové uživatelské rozhraní, které umožňuje:

import dat

zápis docházky

výpis reportů

simulaci chybových stavů

## Transakce

Transakce je použita při zápisu docházky studenta.
V rámci jedné transakce:

se ověří existence studenta a vyučování

zapíše se záznam docházky

aktualizují se související statistiky

Při chybě je provedeno vrácení změn (rollback).

## Import dat

### Aplikace umožňuje:

import studentů z CSV souboru

import rozvrhu a vyučování z XML souboru

Import probíhá přes servisní vrstvu a data jsou validována před uložením do databáze.

## Reporty

### Reporty jsou generovány pomocí databázových pohledů (VIEW) a obsahují agregovaná data z více tabulek, například:

přehled absence studentů

statistiku docházky podle předmětu

přehled vyučovacích hodin

## Ošetření chyb

### Aplikace ošetřuje:

chybné vstupy uživatele

chyby konfigurace

výpadek databázového připojení

porušení databázových omezení

Při chybách aplikace vypisuje srozumitelná chybová hlášení.

## Testování

### Testovací scénáře jsou uloženy ve složce /test a popisují:

správný běh aplikace

chybné vstupy uživatele

chybné nastavení konfigurace

výpadek databáze

## Dokumentace

### Kompletní dokumentace projektu je dostupná v souboru:

/doc/Dokumentace.pdf

## Závěr

### Tato aplikace splňuje všechny požadavky zadání, zejména:

použití DAO patternu (D1)

práci se skutečnou relační databází

použití transakcí

import dat

generování reportů

konfigurovatelnost a ošetření chyb


