package Metadata.ns;

public interface NSFactory {

	public FileObject createFileObject(FileObject parent, String name, boolean isdir);

	public Organization createOrganization(Organization object, String name, boolean isUper);
}
