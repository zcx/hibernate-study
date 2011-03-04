package Metadata.db;

import javax.persistence.Entity;

import org.hibernate.cfg.Configuration;

import Metadata.metamodel.MetaClass;
import Metadata.metamodel.MetaPackage;

@Entity
public class DbPackage extends MetaPackage {
	
	public void loadAnnotatedClass(Configuration conf) {
		conf.addAnnotatedClass(Catalog.class);
		conf.addAnnotatedClass(Schema.class);
		conf.addAnnotatedClass(Table.class);
		conf.addAnnotatedClass(Field.class);
		conf.addAnnotatedClass(DbPackage.class);
	}

	public MetaClass getCatalogClass() throws Exception {
		return this.getMetaClassByJavaClass(Catalog.class, "Catalog");
	}

	public MetaClass getFieldClass() throws Exception {
		return this.getMetaClassByJavaClass(Field.class, "Field");
	}

	public MetaClass getSchemaClass() throws Exception {
		return this.getMetaClassByJavaClass(Schema.class, "Schema");
	}

	public MetaClass getTableClass() throws Exception {
		return this.getMetaClassByJavaClass(Table.class, "Table");
	}
	
	
	@Override
	public DbFactory<DbPackage> getFactory() {
		return new DbFactory<DbPackage>(this);
	}

}
