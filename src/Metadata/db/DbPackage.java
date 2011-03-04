package Metadata.db;

import javax.persistence.Entity;

import org.hibernate.cfg.Configuration;

import Metadata.metamodel.MetaClass;
import Metadata.metamodel.MetaPackage;

import com.mysql.jdbc.Field;

@Entity
public class DbPackage extends MetaPackage {
	
	public void loadAnnotatedClass(Configuration conf) {
		conf.addAnnotatedClass(Catalog.class);
		conf.addAnnotatedClass(Schema.class);
		conf.addAnnotatedClass(Table.class);
		conf.addAnnotatedClass(Field.class);
		conf.addAnnotatedClass(DbPackage.class);
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
