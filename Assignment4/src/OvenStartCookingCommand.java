public class OvenStartCookingCommand implements Command {
    private Oven oven;

    OvenStartCookingCommand(Oven oven){
        this.oven = oven;
    }

    @Override
    public void execute() {
        oven.startCooking();
    }

    @Override
    public String getName() {
        return "Start cooking";
    }

}
