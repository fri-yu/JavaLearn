package observer.impl;

import observer.Observer;
import observer.Subject;

/**
 * Package : observer.impl
 *
 * @author YixinCapital -- jieliyu 2017年10月26日 15:42:00
 */
public class ObserverA implements Observer {

	private WeatherSubject subject;

	public ObserverA(WeatherSubject subject) {
		System.out.println(" ObserverA new weather: "+subject.getWeather());
		this.subject = subject;
	}

	@Override
	public void update() {
		System.out.println(" weather change: " + subject.getWeather());

	}
}
