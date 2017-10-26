package factory.impl;

import factory.Factory;

/**
 * Package : factory.impl
 *
 * @author YixinCapital -- jieliyu
 *         2017年10月26日 15:10:00
 */
public class BikeFactory implements Factory {
	@Override
	public void produce() {
		System.out.println(" I'll produce a bike ");
	}
}
