package Metadata.rpt;

import Metadata.metamodel.MetaFactory;

public class RptFactory<P extends RptPackage> extends MetaFactory<P>{

	protected RptFactory(P pkg) {
		super(pkg);
	}
	
	public Directory createDirectory(String parent, String name) throws Exception{
		Directory directory = new Directory();
		return directory; 
	}
	
	public Report createReport(Directory group, String name) throws Exception{
		Report rpt = new Report();
		return rpt;
	}
}
