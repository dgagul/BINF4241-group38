public class MicrowaveInterruptCommand implements Command{
    private Microwave microwave;

    MicrowaveInterruptCommand(Microwave microwave){
        this.microwave = microwave;
    }


    @Override
    public void execute() {
        microwave.interrupt();
    }

    @Override
    public String getName() {
        return "Interrupt baking";
    }

}
