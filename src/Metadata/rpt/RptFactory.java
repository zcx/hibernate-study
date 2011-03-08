package Metadata.rpt;

import Metadata.metamodel.MetaFactory;

public class RptFactory<P extends RptPackage> extends MetaFactory<P>{

	protected RptFactory(P pkg) {
		super(pkg);
	}
	
	public MGroup createGroup() throws Exception{
		MGroup group = new MGroup();
		group.setIsgroup(true);
		return group; 
	}
	
	public Report createReport(MGroup group) throws Exception{
		Report rpt = new Report();
		rpt.setGroup(group);
		return rpt;
	}
}
