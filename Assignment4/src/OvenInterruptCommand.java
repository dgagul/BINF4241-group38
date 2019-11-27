public class OvenInterruptCommand implements Command{
    private Oven oven;

    OvenInterruptCommand(Oven oven){
        this.oven = oven;
    }


    @Override
    public void execute() {
        oven.interrupt();
    }

    @Override
    public String getName() {
        return "Interrupt";
    }

}
