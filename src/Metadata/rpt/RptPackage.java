package Metadata.rpt;

import javax.persistence.Entity;

import org.hibernate.cfg.Configuration;

import Metadata.metamodel.MetaClass;
import Metadata.metamodel.MetaPackage;

@Entity
public class RptPackage extends MetaPackage{
	
	public void loadAnnotatedClass(Configuration conf) {
		conf.addAnnotatedClass(MGroup.class);
		conf.addAnnotatedClass(Report.class);
		conf.addAnnotatedClass(RptPackage.class);
		conf.addAnnotatedClass(Namespace.class);
	}
	
	public MetaClass getReportClass() throws Exception{
		return getMetaClassByJavaClass(Report.class, "Report");
	}
	
	public MetaClass getGroupClass() throws Exception{
		return getMetaClassByJavaClass(MGroup.class, "Group");
	}
	
	@Override
	public RptFactory<RptPackage> getFactory() {
		return new RptFactory(this);
	}
}
