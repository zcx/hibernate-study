package Metadata.metamodel;

public class MetaFactory<P extends MetaPackage> {
	private P pkg = null;

	public MetaFactory(P pkg) {
		this.pkg = pkg;
	}

	public P getPackage() {
		return this.pkg;
	}
}
