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
    public void undo() {
        machine.switchOff();
    }
}
