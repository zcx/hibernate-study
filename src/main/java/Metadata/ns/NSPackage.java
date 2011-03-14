package Metadata.ns;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

	@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
	public interface NSPackage {
	public NSFactory getFactory();
	
	public NSExtent getExtent();
}
