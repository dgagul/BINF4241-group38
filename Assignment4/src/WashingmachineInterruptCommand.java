public class WashingmachineInterruptCommand implements Command {

    private Washingmachine machine;

    WashingmachineInterruptCommand(Washingmachine machine){
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.interrupt();
    }

    @Override
    public String getName() {
        return "Interrupt";
    }
}
