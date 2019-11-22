public class MicrowaveSwitchOnCommand implements Command {
    private Microwave microwave;

    MicrowaveSwitchOnCommand(Microwave microwave){
        this.microwave = microwave;
    }

    @Override
    public void execute() {
        microwave.switchOn();
    }

    @Override
    public String getName() {
        return "Switch on";
    }

}
