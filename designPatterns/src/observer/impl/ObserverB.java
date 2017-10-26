package observer.impl;

import observer.Observer;
import observer.Subject;

/**
 * Package : observer.impl
 *
 * @author YixinCapital -- jieliyu 2017年10月26日 15:43:00
 */
public class ObserverB implements Observer {

	private WeatherSubject subject;

	public ObserverB(WeatherSubject subject) {
		System.out.println(" ObserverB new weather: " + subject.getWeather());
		this.subject = subject;
	}

	@Override
	public void update() {
		System.out.println(" ObserverB got a notice: "+subject.getWeather());
	}
}
