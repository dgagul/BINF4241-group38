We made following design choices:
    - We have a class Smartphone which serves as Invoker
    - We have a Command interface with two public methods: execute() and getName()
    - this Command interface is implemented by several concrete Commands
    - Main class serves as Client
    - We have an Interface Devices which serves as Receiver
    - 5 different Devices implement this Interface Devices
    - Additionally, we applied the state pattern. Every device has different states like DishwasherIsOn, DishwasherIsOff and so on. 
        in these States all methods from the DishwasherState are overwritten, such that only functions that make sense in this state
        can be executed by the client. The client only has the choice between functions that make sense in this state and since wrong
        input is caught, the client can not execute other functions. However, even if the client could execute this functions, then 
        feedback is provided in the console and the function does no further action. 
    - Further we added a SmartphoneState Interface which contains functions to get input or to display the menu in the console. 
        It depends on the state of the Smartphone, (e.g. where the user is in the menu) how the menu should be displayed. Therefore
        we applied this second state pattern. 
    - We followed the rules of the assignment sheet. 
        
        
    
