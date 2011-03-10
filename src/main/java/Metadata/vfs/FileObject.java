package Metadata.vfs;

import javax.persistence.Id;

public class FileObject {
	@Id
	private String name = null;
	
	@Id
	private String namespace = null;
}
