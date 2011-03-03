package Metadata.metamodel;

import java.util.HashMap;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MetaModel {
	
	private Configuration conf = null;
	
	private static HashMap<Class<?>, MetaPackage> pkgreposit = new HashMap<Class<?>, MetaPackage>();

	public MetaModel() {
		this.conf = new Configuration();
		this.conf.configure("/Metadata/metadata-hibernate.cfg.xml");
	}

	public <P extends MetaPackage> P importPackage(Class<P> cls) {
//		if (pkgreposit.containsKey(cls)) {
//			MetaPackage pkg = pkgreposit.get(cls);
//			return (P) pkg;
//		}
//		String pkgpath = cls.getPackage().getName();
//		String name = cls.getSimpleName();
//		String path = pkgpath + ".impl." + name + "Impl";
//		try {
//			Class<P> implcls = (Class<P>) Class.forName(path);
//			Constructor<P> construct = implcls
//					.getConstructor(CWMMetaModel.class);
//			P instance = construct.newInstance(this);
//			return instance;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
		return null;
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
		return new MetaPackage();
	}
}
