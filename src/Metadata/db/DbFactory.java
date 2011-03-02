package Metadata.db;


public class DbFactory {
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
