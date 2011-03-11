package Metadata.ns;

public interface Namespace extends MetaObject{
	
	public String getName();

	public Namespace getParent();

	public String getAbsolutePath();

	public boolean exists();

	public Namespace getRoot();

	public boolean delete();

	public boolean create();

	public Namespace[] list();

	public boolean renameTo(Namespace dest);

	public boolean moveTo(Namespace parent);

	public boolean copyTo(Namespace parent);

	public int compareTo(Namespace file);
}
