package singleton;

/**
 * Package : singleton
 *
 * @author YixinCapital -- jieliyu 2017年10月26日 14:45:00
 */
public class Singleton {
	private static Singleton singleton;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
