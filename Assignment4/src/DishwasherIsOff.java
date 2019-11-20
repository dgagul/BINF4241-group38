public class DishwasherIsOff implements DishwasherState {
    Dishwasher dishwasher;

    DishwasherIsOff(Dishwasher newDishwasher) {this.dishwasher = newDishwasher;}

    @Override
    public void switchOn() {
        System.out.println("Hello! Dishwasher is now ON.");
        dishwasher.state = dishwasher.dishwasherIsOn; }

    @Override
    public void chooseProgram(DishwasherProgramEnum program){
        System.out.println("You have to switch on the Dishwasher first!"); }

    @Override
    public void startDishwasher(){
        System.out.println("You have to switch on the Dishwasher first!"); }

    @Override
    public void checkTimer(){
        System.out.println("You have to switch on the Dishwasher first!"); }

    @Override
    public void stopDishwasher(){
        System.out.println("Dishwasher is not even on!"); }

    @Override
    public void switchOff() {
        System.out.println("Dishwasher is already off!"); }

}
