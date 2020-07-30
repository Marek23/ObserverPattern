package pl.com.home.interfaces;

import java.io.File;

public interface IObservable {
	public void add(IObserver o);
	public void remove(IObserver o);
	public void notifyAboutChange(File file);
	public String getStatus();
}
