public class OvenInterruptCommand implements Command{
    Oven oven;

    public OvenInterruptCommand(Oven oven){
        this.oven = oven;
    }


    @Override
    public void execute() {
        oven.interrupt();
    }

}
