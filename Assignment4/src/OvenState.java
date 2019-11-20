public interface OvenState {
    public void switchOn();
    public void setTimer(int time);
    public void setTemperature(int temperature);
    public void setProgram(Oven.Program program);
    public void startCooking();
    public void checkTimer();
    public void interrupt();
    public void switchOff();
    public void updateOven(int temperature, int timer, Oven.Program program);
}
