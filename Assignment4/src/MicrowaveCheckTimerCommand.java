public class MicrowaveCheckTimerCommand implements Command {
    private Microwave microwave;

    MicrowaveCheckTimerCommand(Microwave microwave){
        this.microwave = microwave;
    }


    @Override
    public void execute() {
        microwave.checkTimer();
    }

    @Override
    public String getName() {
        return "Check timer";
    }

}
