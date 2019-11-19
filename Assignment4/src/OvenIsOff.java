public class OvenIsOff implements OvenState {
    Oven oven;

    public OvenIsOff(Oven oven){
        this.oven = oven;
    }

    @Override
    public void switchOn() {
        System.out.println("Oven is now ON.");
        oven.state = oven.ovenIsOn;
    }

    @Override
    public void setTimer(Integer time) {
        System.out.println("You have to switch the oven ON first!");
    }

    @Override
    public void setTemperature(Integer temperature) {
        System.out.println("You have to switch the oven ON first!");
    }

    @Override
    public void setProgram(Oven.Program program) {
        System.out.println("You have to switch the oven ON first!");
    }

    @Override
    public void startCooking() {
        System.out.println("You have to switch the oven ON first!");
    }

    @Override
    public void checkTimer() {
        System.out.println("You have to switch the oven ON first!");
    }

    @Override
    public void interrupt() {
        System.out.println("You have to switch the oven ON first!");
    }

    @Override
    public void switchOff() {
        System.out.println("The oven was already OFF!");
    }
}
