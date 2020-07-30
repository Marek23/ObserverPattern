package pl.com.home;

import java.io.File;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import pl.com.home.impl.observable.DirWatcher;
import pl.com.home.impl.observer.JarFileObserver;


public class Main extends FileAlterationListenerAdaptor{
	private static void createDirs() {
		new File("HOME").mkdir();
	}

	private static void init() {
		createDirs();
	}

	public static void main(String[] args) throws Exception {
		init();

		DirWatcher watcher = new DirWatcher();
		watcher.add(new JarFileObserver(watcher));
	}

}
