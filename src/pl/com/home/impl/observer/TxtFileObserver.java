package pl.com.home.impl.observer;

import java.io.File;

import pl.com.home.interfaces.IObservable;
import pl.com.home.interfaces.IObserver;

public class TxtFileObserver implements IObserver {
	private IObservable observable;
	private int txt;

	public TxtFileObserver(IObservable o) {
		observable = o;
	}

	@Override
	public void update(File file) {
		String name = file.getName();
		int i       = name.lastIndexOf('.');

		String extension = "";
		if (i >= 0)
			extension = name.substring(i+1);

		if (extension.equals("txt"))
			txt++;

		System.out.println(observable.getStatus() + " " + txt);
	}
}
