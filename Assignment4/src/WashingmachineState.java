public interface WashingmachineState {
    public void switchOn();
    public void setDegrees(int degrees);
    public void setProgram(Washingmachine.Program program);
    public void setTimer(int time);
    public void interrupt();
    public void switchOff();
}
