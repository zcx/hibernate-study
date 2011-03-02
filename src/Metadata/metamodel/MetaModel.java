package Metadata.metamodel;

import Metadata.metamodel.impl.MetaAssociationEntity;
import Metadata.metamodel.impl.MetaAttributeEntity;
import Metadata.metamodel.impl.MetaClassEntity;

public class MetaModel {
	
	
	public static final MetaClass createMetaClass(){
		return new MetaClassEntity();
	}
	
	public static final  MetaAssociation createMetaAssociation(){
		return new MetaAssociationEntity();
	}
	
	public static final MetaAttribute createMetaAttribute(){
		return new MetaAttributeEntity();
	}
	
	public static final MetaPackage createMetaPackage(){
		return new MetaPackage();
	}
}
