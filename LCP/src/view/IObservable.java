package view;

import java.util.Iterator;

public interface IObservable {
	public void notifyObservers();
	public void addObserver(IObserver observer);
	public void removeObserver(IObserver observer);
	public Iterator<IObserver> getObserver();
}
