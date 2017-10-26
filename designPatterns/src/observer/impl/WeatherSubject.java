package observer.impl;

import observer.Observer;
import observer.Subject;

import java.util.LinkedList;
import java.util.List;

/**
 * Package : observer
 *
 * @author YixinCapital -- jieliyu 2017年10月26日 15:27:00
 */
public class WeatherSubject implements Subject {

	static List<Observer> observerList = new LinkedList<Observer>();
	private String weather=" change ing~ ";

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	@Override
	public void attach(Observer observer) throws Exception {
		if (!observerList.contains(observer)) {
			observerList.add(observer);
		}
	}

	@Override
	public void detach(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void notice() {
		for (Observer observer : observerList) {
			observer.update();
		}
	}
}
