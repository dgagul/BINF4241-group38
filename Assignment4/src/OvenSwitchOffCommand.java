public class OvenSwitchOffCommand implements Command {
    private Oven oven;

    OvenSwitchOffCommand(Oven oven){
        this.oven = oven;
    }

    @Override
    public void execute() {
        oven.switchOff();
    }

    @Override
    public String getName() {
        return "Switch off";
    }

}

