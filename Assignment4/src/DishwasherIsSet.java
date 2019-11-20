public class DishwasherIsSet implements DishwasherState {
    Dishwasher dishwasher;
    DishwasherProgramEnum dishwasherProgram;

    DishwasherIsSet(Dishwasher newDishwasher) {this.dishwasher = newDishwasher;}

    @Override
    public void switchOn() {
        System.out.println("The dishwasher is already ON!");}

    @Override
    public void chooseProgram(DishwasherProgramEnum program) {
        this.dishwasherProgram = program;}


    // Todo: thread things with timer
    @Override
    public void startDishwasher(){
        System.out.print("Dishwasher has started");
        dishwasher.state = dishwasher.dishwasherIsRunning;}

    @Override
    public void checkTimer(){
        System.out.println("You chose program " + dishwasher.program + "and it runs" + dishwasher.timer);}

    @Override
    public void stopDishwasher() {System.out.println("The dishwasher is not even washing!");}

    @Override
    public void switchOff() {
        System.out.println("Goodnight.");
        dishwasher.state = dishwasher.dishwasherIsOff;}


}
