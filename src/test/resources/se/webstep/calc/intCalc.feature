# encoding: utf8
# language: sv

Egenskap: Beräkningar med miniräknaren

  Scenario: När jag nollställer miniräknaren ska resultatet vara 0
    När jag nollställer miniräknaren
    Så ska resultatet vara 0

  Abstrakt Scenario: Addition av två heltal ska ge korrekt resultat
    Givet jag nollställer miniräknaren
    När jag adderar <första talet>
    Och jag adderar <andra talet>
    Så ska resultatet vara <resultat>

    Exempel:
      | första talet | andra talet | resultat |
      | 3            | 5           | 8        |
      | 20           | 7           | 27       |
      | 6            | 8           | 14       |

  Abstrakt Scenario: Subtraktion av två heltal ska ge korrekt resultat
    Givet jag nollställer miniräknaren
    När jag adderar <första talet>
    Och jag subtraherar <andra talet>
    Så ska resultatet vara <resultat>

    Exempel:
      | första talet | andra talet | resultat |
      | 3            | 5           | -2       |
      | 20           | 7           | 13       |
      | 5            | 8           | -3       |

  Abstrakt Scenario: Multiplikation av två heltal ska ge korrekt resultat
    Givet jag nollställer miniräknaren
    När jag adderar <första talet>
    Och jag multiplicerar med <andra talet>
    Så ska resultatet vara <resultat>

    Exempel:
      | första talet | andra talet | resultat |
      | 3            | 5           | 15       |
      | 20           | 7           | 140      |
      | 5            | 8           | 40       |

  Abstrakt Scenario: Division av två heltal ska ge korrekt resultat
    Givet jag nollställer miniräknaren
    När jag adderar <första talet>
    Och jag dividerar med <andra talet>
    Så ska resultatet vara <resultat>

    Exempel:
      | första talet | andra talet | resultat |
      | 15           | 5           | 3        |
      | 21           | 7           | 3        |
      | 40           | 8           | 5        |
