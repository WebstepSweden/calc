# encoding: utf8
# language: sv

Egenskap: Beräkningar med miniräknaren

  Scenario: När jag nollställer miniräknaren ska resultatet vara 0
    Givet  jag nollställer miniräknaren
    Så ska resultatet vara 0

  Abstrakt Scenario: Addition av två heltal ska ge korrekt resultat
    Givet jag nollställer miniräknaren
    När jag adderar <första talet>
    När jag adderar <andra talet>
    Så ska resultatet vara <resultat>

    Exempel:
      | första talet | andra talet | resultat |
      | 3            | 5           | 8        |
      | 20           | 7           | 27       |
      | -6           | -8          | -14      |