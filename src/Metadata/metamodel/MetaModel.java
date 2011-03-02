package Metadata.metamodel;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MetaModel {
	private Configuration conf = null;
	public MetaModel() {
		this.conf = new Configuration();
		this.conf.configure("/Metadata/metadata-hibernate.cfg.xml");
	}
	
	public void importPackage(SessionFactory factory, MetaPackage pkg){
//		if(pkg.hasImported()){
//			
//		}else{
//			pkg.init(this.conf);	
//		}
//		
	}
	
	public SessionFactory getSessionFactory(){
		
		return null;
	}
	
	public static final MetaClass createMetaClass(){
		return new MetaClass();
	}
	
	public static final  MetaAssociation createMetaAssociation(){
		return new MetaAssociation();
	}
	
	public static final MetaAttribute createMetaAttribute(){
		return new MetaAttribute();
	}
	
	public static final MetaPackage createMetaPackage(){
		return new MetaPackage(null);
	}
}
