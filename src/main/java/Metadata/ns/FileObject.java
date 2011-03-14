package Metadata.ns;

import java.io.InputStream;
import java.io.OutputStream;

public interface FileObject extends Namespace{
	
	public void setDir(boolean dir);

	public boolean isDir();
	
	public void writeTo(OutputStream os);
	
	public InputStream read();
}
