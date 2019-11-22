public class WashingmachineSwitchOffCommand implements Command {

    Washingmachine machine;

    public WashingmachineSwitchOffCommand(Washingmachine machine){
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.switchOff();
    }

    @Override
    public String getName() {
        return "Switch off";
    }


}
