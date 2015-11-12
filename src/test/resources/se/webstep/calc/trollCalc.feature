# encoding: utf8
# language: sv

Egenskap: Beräkningar med trollminiräknaren

   Scenario: När jag nollställer trollminiräknaren ska trollresultatet vara 0
      Givet jag nollställer trollminiräknaren
      Så ska trollresultatet vara 0

   Scenario: Jag vill kunna addera två heltal.
      Givet att jag adderar heltalen "ONE" och "THREE"
      Så ska trollresultatet vara "MANY" och 4

   Abstrakt Scenario: Jag vill kunna addera två heltal.
      Givet att jag adderar heltalen "<tal1>" och "<tal2>"
      Så ska trollresultatet vara "<sResultat>" och <iResultat>
      Exempel:
         | tal1           | tal2 | sResultat | iResultat |
         | ONE            | ONE  | TWO       | 2         |
         | ONE            | TWO  | THREE     | 3         |
         | TWO            | ONE  | THREE     | 3         |
         | TWO            | TWO  | MANY      | 4         |
         | MANY-MANY-MANY | MANY | LOTS      | 16        |

   Abstrakt Scenario: Troll kan inte addera två heltal vars resultat blir > 16
      Givet att jag adderar heltalen "<tal1>" och "<tal2>" och "<Resultatet>" är större än 16
      Så skall "<felmeddelandet>" visas
      Exempel:
         | tal1 | tal2 | Resultatet | felmeddelandet      |
         | LOTS | ONE  | 17         | Trolls don't get 17 |

   Abstrakt Scenario: Troll kan inte subtrahera två heltal vars resultat blir < 1
      Givet att jag subtraherar heltalen "<tal1>" och "<tal2>"
      Så skall "<felmeddelandet>" visas
      Exempel:
         | tal1 | tal2  | felmeddelandet                      |
         | TWO  | TWO   | Troll don't think 0 is troll number |
         | TWO  | THREE | Trolls don't get -1                 |
