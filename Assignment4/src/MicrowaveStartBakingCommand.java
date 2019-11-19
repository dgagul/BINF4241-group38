public class MicrowaveStartBakingCommand implements Command {
    Microwave microwave;

    public MicrowaveStartBakingCommand(Microwave microwave){
        this.microwave = microwave;
    }

    @Override
    public void execute() {
        microwave.startBaking();
    }

    @Override
    public void undo() {
        microwave.interrupt();
    }
}
