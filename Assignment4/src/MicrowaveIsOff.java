public class MicrowaveIsOff implements MicrowaveState {
    Microwave microwave;

    public MicrowaveIsOff(Microwave newMicrowave){
        this.microwave = newMicrowave;
    }

    @Override
    public void switchOn() {
        System.out.println("Microwave is now ON.");
        microwave.state = microwave.microwaveIsOn;
    }

    @Override
    public void setTimer(Integer time) {
        System.out.println("You have to switch the microwave ON first!");
    }

    @Override
    public void setTemperature(Integer temperature) {
        System.out.println("You have to switch the microwave ON first!");
    }

    @Override
    public void startBaking() {
        System.out.println("You have to switch the microwave ON first!");
    }

    @Override
    public void checkTimer() {
        System.out.println("You have to switch the microwave ON first!");
    }

    @Override
    public void interrupt() {
        System.out.println("You have to switch the microwave ON first!");
    }

    @Override
    public void switchOff() {
        System.out.println("The microwave was already OFF!");
    }
}
