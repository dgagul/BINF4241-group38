## Part 3

### Behaviour of the UNO-implementation

#### 1. Inputs that should be accepted

* To start, an _integer_ should be entered by the user in order to determine
the number of players. The minimum for this integer is 2 and the maximum is ten.
At this point, no input of a different type like _floats_, _strings_, _chars_ etc. should be accepted.

* Second, it should ask for the player's names, otherwise it gets hard that everyone can remember their player number if
there are 10 people. The input should be of type _string_, others are not accepted. Also it should cap the amount of
characters, such that no unnecessarily long names are entered. Also, the user shouldn't be able to enter a name twice.

* While the game is on, the user should be able to input the color and number of a card or the identifier for an action
card (e.g. "Yellow 5", "Green 3" or "Red Draw 2", "Wild Draw 4 Blue", "Yellow Reverse", "Blue Skip", "Wild Red").
The color provided after a wild card defines the next color to play. Enemy players can claim a missing "UNO"-call or
a illegal "Wild Draw 4" by providing the input "Claim Wild Draw 4" or "Claim UNO".
A player can of course also draw a card, which will be done with the "Draw" input. If the input is not recognizable,
the game should ask for a retry.

* If a user has only two cards and wants to play one of them it is possible that he/she inputs "UNO" first, before
declaring his next card played. This is the only time where it is possible that a user gives two inputs,
but the first must be "UNO". Otherwise, you only have the possibility to provide one input 
(if the input is correct and the user is not asked to retry as mentioned above).  
If the current player only holds two cards and forgets to enter "UNO" first and enters a valid move, all of the
following players can "claim UNO"

***

#### 2. What should (and should not) happen with the input
* The _integer_ which is provided by the user should set the amount of _Player_ - objects that are created
(i.e. set the number of iterations for the loop which will ask the user for the names of the players).

* This _string_ which serves as a name should then set the attribute "name" of the respective Player object.

* When a player chooses a card to play by giving the correct input, the application should parse this input in order to know 
which card has been selected by the player. It should then check from the **existing** cards being present in the hand of the 
respective player, if the player indeed holds such a card.
  * Also, the application should check whether the entered move is valid given the game's rules and the last played card.
If it is correct, the application should remove it and add it to the played cards stack, otherwise
the player will be asked to play another card which he/she actually holds and which is valid.  
  * After playing a "Wild Draw 4" or a "Draw 2" card, the next player automatically gets the respective amount of cards and 
their turn will be skipped. The same happens for a "Skip"-card. In this case, these cards trigger an action to change
the game's routine and/or trigger a draw-loop until the defined amount of cards has been drawn by the next player.  
  * The input should only trigger changes to the current player's hand, upon which follow changes to the played cards stack
and changes to the game routine or the next player's hand if it was an action card.  
  * If the user enters an invalid input, the move is rejected and the user has to enter a new input.

* At each turn, the application should check if the current player only holds two cards. If this is the case,
the user's first input should be "UNO". If not, any other player will be able to "claim UNO" which will add two cards to
the hand of the player who forgot to call his/her UNO. Of course if more than one player forgot to call their UNO in the
same round, a valid "claim UNO" of any other player will add two cards to all of the players who forgot to call their UNO.  
Also, the application should check that the "claim UNO" input is entered by a player before he takes his own turn.

* Of course, the deck where the cards are drawn is not infinite. Therefore, if a player wants to draw a card and the
stack is empty, the stack with the already played cards (except for the last played card, which will stay on the stack of 
the played cards) will be shuffled and then passed to the draw card deck. This action should be triggered automatically by
the application when a player wants to draw a card but the draw card stack is empty.

***

#### 3. Expected outputs 

* The application should ask for the number of players and their names.

* The application should notify the players that the game has started.

* At the start of a game, the application should reveal the first card on the draw card deck so that the first player
can take his turn.

* At every turn, the application should output the cards the respective player has in his/her hands in order for him/her
to know which options he/she has.

* At every turn, the application should output the last played card (i.e. the top of the played cards stack).

* If an input is not recognized by the application, it should inform the user and ask for a retry.
 
* The application should be able to ouput how many cards the enemy players have in their hand, but it should _not_
output which cards these are, specifically.

* When "calling UNO", the application shout output whether this call was valid, so that no one can "claim UNO" afterwards.
(of course, technically, any player can "claim UNO" at any time, but it won't be valid unless someone actually forgot to "call UNO")

* After a player has played the last card in his hand, the application shout output the winner. Of course, this should
only happen if the turn was a legal move.





