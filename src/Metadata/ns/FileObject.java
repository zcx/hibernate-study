package Metadata.ns;

import java.io.InputStream;
import java.io.OutputStream;

public interface FileObject extends Namespace{
	
	public void setIsdir(boolean isdir);

	public boolean isIsdir();
	
	public void writeTo(OutputStream os);
	
	public InputStream read();
}
