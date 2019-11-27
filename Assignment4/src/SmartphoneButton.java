public class SmartphoneButton {

    private Command command;

    public SmartphoneButton(Command command){
        this.command = command;
    }

    public void press(){
        command.execute();
    }
}
