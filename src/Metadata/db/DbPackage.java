package Metadata.db;

import org.hibernate.cfg.Configuration;

import Metadata.metamodel.MetaClass;
import Metadata.metamodel.MetaPackage;

public class DbPackage extends MetaPackage {
	
	public DbPackage(Configuration configure) {
		super(configure);
	}

	public MetaClass getCatalogClass() {
		return null;
	}

	public MetaClass getFieldClass() {
		return null;
	}

	public MetaClass getSchemaClass() {
		return null;
	}

	public MetaClass getTableClass() {
		return null;
	}

}
