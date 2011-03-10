package Metadata.rpt;

import Metadata.metamodel.MetaFactory;

public class RptFactory<P extends RptPackage> extends MetaFactory<P>{

	protected RptFactory(P pkg) {
		super(pkg);
	}
	
	public Directory createDirectory(String parent, String name) throws Exception{
		Directory directory = new Directory();
		directory.setParent(parent);
		directory.setName(name);
		return directory; 
	}
	
	public Report createReport(Directory group, String name) throws Exception{
		Report rpt = new Report();
		rpt.setParent(group.getName());
		rpt.setName(name);
		return rpt;
	}
}
