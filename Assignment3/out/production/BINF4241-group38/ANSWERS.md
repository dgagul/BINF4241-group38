## Part 1: 

a) Singleton

1) We used the singleton pattern to ensure the Game class has only one instance. Because we don't want the user to
   be able to create multiple games at the same time. 
   This goal is achieved by: 

   - creating a firstInstance variable of type Game in Game class which is set to null.
 
   - making Game constructor private (was already the case, so no changes made!)
 
   - creating static getInstance() method in Game class which checks if there is already an instance of Game.
    If not, it initializes a new instance of Game and returns it. Otherwise, it returns the existing instance. 
 
   - creating a new Java class called "Run" and moving the main method from Game class to Run class. So that the main
    function has no more access to the private Game constructor. Therefore, we had to adjust the play method to 
    public so that the main function of the Run class can start the Game. 
 
2) ![](CD Singleton.jpeg)
3) ![](SD Singleton.jpeg)
          


b) Iterator