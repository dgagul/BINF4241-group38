public class MicrowaveSwitchOffCommand implements Command {
    private Microwave microwave;

    MicrowaveSwitchOffCommand(Microwave microwave){
        this.microwave = microwave;
    }

    @Override
    public void execute() {
        microwave.switchOff();
    }

    @Override
    public String getName() {
        return "Switch off";
    }

}

