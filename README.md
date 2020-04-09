# Tema 1 - Pipes and filters pattern

### Enunt
Se considera un program care simuleaza activitatea unei fabrici de mobila.
Fabrica are muncitori cu urmatoarele specializari:

- C = Cut seat
- F = Assemble feet
- B = Assemble backrest
- S = Assemble stabilizer bar
- P = Package chair

Procesul tehnologic impune urmatoarele restrictii: asamblarea picioarelor si a spatarului se pot face doar dupa ce a fost decupat sezutul, asamblarea barei se poate face doar dupa ce s-au pus picioarele, iar impachetarea dupa ce e gata asamblat scaunul. Fiecare faza a procesului tehnologic dureaza un timp diferit, influentata de complexitatea operatiei pe care o implica si de priceperea muncitorului care o executa.

Fabrica are o unica linie de productie, in care produce scaune de acelasi model.
Un exemplu de pipeline cu 5 muncitori care realizeaza produsul descris poate fi:
Ion:C, Vasile:F, Petru:B, Gheo:S, Costi:P.
Un alt exemplu de pipeline care realizeaza acelasi produs:
Ion:C, Petru:B, Vasile:F, Gheo:S, Costi:P.

Daca fabrica doreste sa isi schimbe productia (de exemplu sa produca scaune fara spatar), va trebui sa reconfigureze un alt pipeline, ca de exemplu:
Ion:C, Vasile:F, Gheo:S, Costi:P.

Pentru ca filtrele (muncitorii) sa poata fi recombinate cu usurinta, este necesar ca:
- sa nu existe dependente statice de cod intre ele
- sa manevreze acelasi tip de date de intrare si iesire (de ex: ChairInProgress)

Presupunand ca timpii de lucru necesar muncitorilor sunt urmatorii: Ion=10 min, Petru=15 min, Vasile=40 min, Gheo=20 min, Costi=10 min. Timpul necesar producerii de N scaune va fi: (10+15+40+20+10)+40*(N-1)

**Link** - **_http://staff.cs.upt.ro/~ioana/arhit/2017/t1.html_**
