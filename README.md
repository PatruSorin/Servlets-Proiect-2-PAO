#PROIECT SERVLETS
##Enunt
Realizati o aplicatie web bazata pe JavaServlets care sa implementeze o agenda (de telefon). Veti folosi urmatoarele cazuri de utilizare:

a. utilizatorul poate adauga contacte noi an agenda;

b. utilizatorul poate sterge contacte din agenda;

c. utilizatorul poate cauta contacte in agenda;

d. utilizatorul poate modifica contacte in agenda.

##Detalii
Pentru CONTACT se vor avea in vedere urmatoarele campuri:
O intrare in agenda (un contact) are urmatoarele câmpuri:
- nume (obligatoriu);
- prenume (obligatoriu);
- telefon mobil (obligatoriu);
- telefon fix;
- email (obligatoriu);
- adresa (un singur câmp pentru toata adresa, mai putin orasul, judetul si codul postal);
- oras;
- judet;
- cod postal.

Principalele OPERATII:

Cele patru operatii fundamentale pe care utilizatorul le poate executa (Creare, Actualizare, stergere si Cautare) vor fi mapate pe urmatoarele URI-uri (relative la radacina aplicatiei):
- creare → /add;
- actualizare → /edit;
- stergere → /delete;
- cautare → /search.

##Tratarea erorilor
Operatiile invalide (cum ar fi inserarea sau modificarea unui contact care nu are câmpurile obligatorii completate) vor fi detectate si se vor afisa mesaje de eroare corespunzatoare, nepericlitând integritatea agendei (i. e. nu vor exista contacte pe jumatate inserate sau pe jumatate modificate etc.).

##Informatii suplimentare
Daca e completat mai mult de un singur câmp se va folosi operatorul SAU logic (i. e. se va cauta dupa nume SAU dupa email etc.). Pentru stocarea contactelor se va folosi o baza de date (la alegere: Microsoft Access, MySQL, SQLite etc.) accesata prin intermediul tehnologiei JDBC.
