package factory.impl;

import factory.Factory;

/**
 * Package : factory.impl
 *
 * @author YixinCapital -- jieliyu
 *         2017年10月26日 15:09:00
 */
public class CarFactory implements Factory{

	@Override
	public void produce() {
		System.out.println(" I'll produce a car ");
	}
}
