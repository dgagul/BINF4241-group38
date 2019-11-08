import java.util.ArrayList;

public class Score implements Subject {
    private ArrayList<Observer> observers;

    public Score(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer newObserver) {
        this.observers.add(newObserver);
    }

    @Override
    public void removeObserver(Observer removedObserver) {
        this.observers.remove(removedObserver);
    }

    @Override
    public void notifyObservers(Color.color color) {
        for (Observer observer : observers){
            observer.update(color);
        }
    }
}
