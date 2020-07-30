package pl.com.home.interfaces;

import java.io.File;

// java.util.Observer
// deprecated since Java 9
// PropertyChangeListener
// https://www.baeldung.com/java-observer-pattern
public interface IObserver {
	public void update(File file);
}
