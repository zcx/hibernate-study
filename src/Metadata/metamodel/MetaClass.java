package Metadata.metamodel;

import java.util.List;

import Metadata.metamodel.impl.MetaAttributeEntity;
import Metadata.metamodel.impl.MetaClassEntity;
import Metadata.metamodel.impl.MetaObjectEntity;
import Metadata.metamodel.impl.MetaPackageEntity;

public interface MetaClass {

	public void setId(String id);

	public String getId();

	public void setVersion(int version);

	public int getVersion();

	public void setAttributes(List<MetaAttributeEntity> attributes);

	public List<MetaAttributeEntity> getAttributes();

	public void setName(String name);

	public String getName();

	public void setInstances(List<MetaObjectEntity> instances);

	public List<MetaObjectEntity> getInstances();

	public void setSuperclass(MetaClass superclass);

	public MetaClass getSuperclass();

	public void setNamespace(MetaPackageEntity namespace);

	public MetaPackageEntity getNamespace();

	public void setSubclasses(List<MetaClassEntity> subclasses);

	public List<MetaClassEntity> getSubclasses();
}
