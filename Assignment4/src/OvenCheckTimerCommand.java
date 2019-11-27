public class OvenCheckTimerCommand implements Command {
    private Oven oven;

    OvenCheckTimerCommand(Oven oven){
        this.oven = oven;
    }


    @Override
    public void execute() {
        oven.checkTimer();
    }

    @Override
    public String getName() {
        return "Check timer";
    }

}
