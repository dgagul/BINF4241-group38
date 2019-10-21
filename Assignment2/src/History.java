import java.util.ArrayList;

public class History {
    private static ArrayList<String> history;

    public History() {
        history = new ArrayList<String>();
    }

    public static ArrayList<String> showHist() {
       for (int i=0; i< history.size(); i++) {
           System.out.println(history.get(i));
       }
       ArrayList<String> pHistory = history;
       return pHistory;
    }
}
