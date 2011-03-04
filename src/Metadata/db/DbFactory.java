package Metadata.db;

import Metadata.metamodel.MetaFactory;


public class DbFactory<P extends DbPackage> extends MetaFactory<P> {

	public DbFactory(P pkg) {
		super(pkg);
	}

	public Catalog createCatalog(){
		return new Catalog();
	}
	
	public Field createField(){
		return new Field();
	}
	
	public Schema createSchema(){
		return new Schema();
	}
	
	public Table createTable(){
		return new Table();
	}
}
