public class WashingmachineSwitchOnCommand implements Command {
    private Washingmachine machine;

    public WashingmachineSwitchOnCommand(Washingmachine machine){
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.switchOn();
    }

    @Override
    public String getName() {
        return "Switch on";
    }

}
