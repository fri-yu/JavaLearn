package factory.test;

import factory.Factory;
import factory.impl.BikeFactory;
import factory.impl.CarFactory;

/**
 * Package : factory.test
 *
 * @author YixinCapital -- jieliyu 2017年10月26日 15:11:00
 */
public class Main {
	public static void main(String[] args) {
		produce(new CarFactory());
		produce(new BikeFactory());
	}

	static void produce(Factory factory) {
		factory.produce();
	}
}
