public class MicrowaveStartBakingCommand implements Command {
    private Microwave microwave;

    MicrowaveStartBakingCommand(Microwave microwave){
        this.microwave = microwave;
    }

    @Override
    public void execute() {
        microwave.startBaking();
    }

    @Override
    public String getName() {
        return "Start baking";
    }

}
