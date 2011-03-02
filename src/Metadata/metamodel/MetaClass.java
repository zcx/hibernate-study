package Metadata.metamodel;

import java.util.List;

import Metadata.metamodel.impl.MetaAttributeEntity;
import Metadata.metamodel.impl.MetaClassEntity;
import Metadata.metamodel.impl.MetaObjectEntity;
import Metadata.metamodel.impl.MetaPackageEntity;

public interface MetaClass {

	public abstract void setId(String id);

	public abstract String getId();

	public abstract void setVersion(int version);

	public abstract int getVersion();

	public abstract void setAttributes(List<MetaAttributeEntity> attributes);

	public abstract List<MetaAttributeEntity> getAttributes();

	public abstract void setName(String name);

	public abstract String getName();

	public abstract void setInstances(List<MetaObjectEntity> instances);

	public abstract List<MetaObjectEntity> getInstances();

	public abstract void setSuperclass(MetaClass superclass);

	public abstract MetaClass getSuperclass();

	public abstract void setNamespace(MetaPackageEntity namespace);

	public abstract MetaPackageEntity getNamespace();

	public abstract void setSubclasses(List<MetaClassEntity> subclasses);

	public abstract List<MetaClassEntity> getSubclasses();
}
