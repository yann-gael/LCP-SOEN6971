package view;

public interface IObserver {
	public void update(IDisplayable observable, IEvent event);
	public void update(ITile observable);
}
