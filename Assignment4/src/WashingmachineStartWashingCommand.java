public class WashingmachineStartWashingCommand implements Command {
    private Washingmachine machine;

    WashingmachineStartWashingCommand(Washingmachine machine){
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.state.starWashing();
    }

    @Override
    public String getName() {
        return "Start washing";
    }
}
