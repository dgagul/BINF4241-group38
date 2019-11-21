public class MicrowaveInterruptCommand implements Command{
    Microwave microwave;

    public MicrowaveInterruptCommand(Microwave microwave){
        this.microwave = microwave;
    }


    @Override
    public void execute() {
        microwave.interrupt();
    }

}
