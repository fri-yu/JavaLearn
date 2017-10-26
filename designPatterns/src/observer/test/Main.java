package observer.test;

import observer.impl.ObserverA;
import observer.impl.ObserverB;
import observer.impl.WeatherSubject;

import javax.security.auth.Subject;

/**
 * Package : observer.test
 *
 * @author YixinCapital -- jieliyu 2017年10月26日 15:50:00
 */
public class Main {

	public static void main(String[] args) throws Exception {
		WeatherSubject subject = new WeatherSubject();
		subject.attach(new ObserverA(subject));

		subject.setWeather(" cloudy ");
		System.out.println(" everybody : weather changed ");
		subject.notice();
		subject.attach(new ObserverB(subject));
		subject.setWeather(" sunny ");
		subject.notice();
	}
}
