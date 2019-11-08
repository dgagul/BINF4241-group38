## Part 1: 
this is based on code of assignment 2

a) Singleton

1) We used the Singleton pattern to ensure that the Game class has only one instance, because we don't want the user to
   be able to create multiple games at the same time. 
   This goal is achieved by: 
   - creating a firstInstance variable of type Game in Game class which is set to null.
   - making the Game constructor private (was already the case, so no changes made).
   - creating a static getInstance() method in Game class which checks if there is already an instance of Game.
    If not, it initializes a new instance of Game and returns it. Otherwise, it returns the existing instance. 
   - creating a new Java class called "Run" and moving the main method from Game class to Run class, so that the main
    function has no more access to the private Game constructor. Therefore, we had to adjust the play method to 
    public so that the main function of the Run class can start the Game. 
 
2) ![](Singleton_CD.PNG)
3) ![](Singleton_SD.PNG)

b) Observer

1) We used the Observer pattern to obtain that when the Game (Subject) state is changed, the Printer (Observer) is
    notified and updated automatically.
    This goal is achieved by:
    - creating an Interface, called Observer, with one method: update().
    - creating a class Printer which implements Observer and overwrites update() to print the board.
    - creating an ArrayList called observerCollection in the Game class which keeps track of the observers. New observers can be added by registerObserver() and
        observers can be removed by unregisterObserver(). Furthermore, the method notifyObserver() calls the methods update() for 
        every observer in the ArrayList observerCollection.
    - in main() in the Run class the obj (aPrinter) of type Printer is created and the method registerObserver(aPrinter) is called.
    - we chose not to create an interface for the Subject because Game is the only Subject that has to notify in this case.
        
2) (In this class diagram additionally the observer Scoreboard, which we implemented in Part 3, is shown.)
![](Observer_pattern_CD.png)

3) (In this sequence diagram additionally the observer aScoreboard, which we implemented in Part 3, is shown.)
![](Observer_SD.png)

## Part 2:
This sequence diagram is based on the code of assignment 2. For the sake of clarity, we chose to make following simplifications:
 - only the actor, Game class, Board class and Logic class are present in this sequence diagram.
    Surely, other classes like Piece are involved in the process. However, to understand which methods can transition the board to a different state,
     they are not necessary (e.g. it does not matter for the board if the set piece is a pawn or a king...).
 - the only methods which can directly make the board transition to a different state are initializeBoard() and setMove(). (undoMove() also uses setMove()) ,
    but also when aBoard is created by the constructor of Game class .
 - ReadInput() normally would check if input is valid and provide appropriate feedback, we simplified this and give no feedback if it is not valid.
 - We left away unnecessary things (for understanding the Board class and its transitions)
    like printing the board, converting string input into integers, update lastMove and so on.
![](Board_Class_SD.png)

## Part 3

- We chose to implement option 3) using the Observer pattern in order to implement a scoreboard.
- The notation accepted as input stays the same as in Assignment 2 (i.e. moves should follow the algebraic notation, where
captures are denoted with a 'x')

#### Implementation choices
- There is an Observer Interface which is implemented by the Scoreboard class.
- The Game class is the subject of the Observer.
- The Game class calls the design pattern by calling the *notifyObservers* method after every turn. Thus, the state of the scoreboard is printed after every turn.
- Capturing a queen is worth 5 points, while capturing any other piece is worth 1 point.

- This means that in total, we have two concrete observers, consisting of the Printer from Part 1
and the Scoreboard from part 3.
- You can find the class diagram for the Scoreboard observer in the class
diagram of Part 1.b).
