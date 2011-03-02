package Metadata.metamodel;

import java.util.List;

public interface MetaClass {

	public void setId(String id);

	public String getId();

	public void setVersion(int version);

	public int getVersion();

	public void setAttributes(List<MetaAttribute> attributes);

	public List<MetaAttribute> getAttributes();

	public void setName(String name);

	public String getName();

	public void setInstances(List<MetaObject> instances);

	public List<MetaObject> getInstances();

	public void setSuperclass(MetaClass superclass);

	public MetaClass getSuperclass();

	public void setNamespace(MetaPackage namespace);

	public MetaPackage getNamespace();

	public void setSubclasses(List<MetaClass> subclasses);

	public List<MetaClass> getSubclasses();
}
