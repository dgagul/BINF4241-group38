public interface MicrowaveState {
    public void switchOn();
    public void setTimer(int timer);
    public void setTemperature(int temperature);
    public void startBaking();
    public void checkTimer();
    public void interrupt();
    public void switchOff();
    public void updateMicrowave(int temperature, int timer);
}