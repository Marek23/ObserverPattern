package pl.com.home.impl.observable;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import pl.com.home.interfaces.IObservable;
import pl.com.home.interfaces.IObserver;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;


public class DirWatcher implements IObservable {
	private Collection<IObserver> observers;
	private int newFiles;

	public DirWatcher() throws Exception {
		observers = new ArrayList<IObserver>();
		newFiles = 0;

		FileAlterationObserver observer = new FileAlterationObserver("HOME");
		FileAlterationMonitor  monitor  = new FileAlterationMonitor(1000);

		FileAlterationListenerAdaptor listener = new FileAlterationListenerAdaptor(){
			 @Override
			 public void onFileCreate(File file) {
				 newFiles++;
				 notifyAboutChange(file);
			 }			 
		};

		observer.addListener(listener);
		monitor.addObserver(observer);
		monitor.start();
	}

	public void add(IObserver o) {
		observers.add(o);
	}

	public void remove(IObserver o) {
		observers.remove(o);
	}

	@Override
	public void notifyAboutChange(File file) {
		observers.forEach(o ->
			{o.update(file);}
		);
	}

	@Override
	public String getStatus() {
		return String.valueOf(newFiles);
	}

}
