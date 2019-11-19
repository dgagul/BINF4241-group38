public interface OvenState {
    public void switchOn();
    public void setTimer(Integer time);
    public void setTemperature(Integer temperature);
    public void setProgram(Oven.Program program);
    public void startCooking();
    public void checkTimer();
    public void interrupt();
    public void switchOff();
}
