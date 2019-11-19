public interface MicrowaveState {
    public void switchOn();
    public void setTimer(Integer time);
    public void setTemperature(Integer temperature);
    public void startBaking();
    public void checkTimer();
    public void interrupt();
    public void switchOff();
}