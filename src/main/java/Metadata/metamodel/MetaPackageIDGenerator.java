package Metadata.metamodel;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.PersistentIdentifierGenerator;
import org.hibernate.type.Type;

/**
 * 元模型MetaPackage及其子类的ID生成器
 * @author classfoo
 *
 */
public class MetaPackageIDGenerator implements IdentifierGenerator, Configurable {

	@Override
	public void configure(Type type, Properties params, Dialect dialect) throws MappingException {
		String table = params.getProperty("table");
		if (table == null)
			table = params.getProperty(PersistentIdentifierGenerator.TABLE);
		String column = params.getProperty("column");
		if (column == null)
			column = params.getProperty(PersistentIdentifierGenerator.PK);
		String schema = params.getProperty(PersistentIdentifierGenerator.SCHEMA);
		Class returnClass = type.getReturnedClass();

		//sql = "select max(to_number(" + column + ")) from " + (schema == null ? table : schema + '.' + table);
	}

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		return object.toString();
	}
}
