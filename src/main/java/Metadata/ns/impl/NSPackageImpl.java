package Metadata.ns.impl;

import Metadata.ns.NSExtent;
import Metadata.ns.NSFactory;
import Metadata.ns.NSPackage;

public class NSPackageImpl implements NSPackage{

	@Override
	public NSFactory getFactory() {
		return new NSFactoryImpl();
	}

	@Override
	public NSExtent getExtent() {
		return null;
	}

}
