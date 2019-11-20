public interface DishwasherState {

    public void switchOn();
    public void chooseProgram(DishwasherProgramEnum program);
    public void startDishwasher();
    public void checkTimer();
    public void stopDishwasher();
    public void switchOff();

}
