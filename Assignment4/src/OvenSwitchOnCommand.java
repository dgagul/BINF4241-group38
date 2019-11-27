public class OvenSwitchOnCommand implements Command {
    private Oven oven;

    OvenSwitchOnCommand(Oven oven){
        this.oven = oven;
    }

    @Override
    public void execute() {
        oven.switchOn();
    }

    @Override
    public String getName() {
        return "Switch on";
    }

}
