package org.hibernate.study.util;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取路径下面所有的子类或是接口实现类
 * TODO 现在只能查找基类或是接口路径下的子类或实现类，需要修改为查找整个类路径
 * @author samuel
 *
 */
public class ClassUtil<T> {
	public T getInstance(Class<T> clz) {
		T t = null;
		try {
			t = clz.newInstance();
		}
		catch (InstantiationException e) {
		}
		catch (IllegalAccessException e) {
		}
		return t;
	}

	/**
	 * 获取同一路径下所有子类或接口实现类
	 * 
	 * @param cls 基类或是接口Class
	 * @return
	 */
	public static List<Class<?>> getAllAssignedClass(Class<?> cls) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		List<Class<?>> list = new ArrayList<Class<?>>();
		list = getClasses(cls);
		for (Class<?> c : list) {
			if (cls.isAssignableFrom(c) && !cls.equals(c)) {
				classes.add(c);
			}
		}
		return classes;
	}

	public static List<Class<?>> getClass(String pk) {
		String path = pk.replace('.', '/');
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getResource(path);
		return getClasses(new File(url.getFile()), pk);
	}

	/**
	 * 取得当前类路径下的所有类
	 * 
	 * @param cls  基类或是接口Class
	 * @return
	 */
	private static List<Class<?>> getClasses(Class<?> cls) {
		String pk = cls.getPackage().getName();
		String path = pk.replace('.', '/');
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getResource(path);
		return getClasses(new File(url.getFile()), pk);
	}

	/**
	 * 迭代查找类
	 * 
	 * @param dir
	 * @param pk
	 * @return
	 */
	private static List<Class<?>> getClasses(File dir, String pk) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		if (!dir.exists()) {
			return classes;
		}
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				classes.addAll(getClasses(f, pk + "." + f.getName()));
			}
			String name = f.getName();
			if (name.endsWith(".class")) {
				Class<?> clz = null;
				try {
					clz = Class.forName(pk + "." + name.substring(0, name.length() - 6));
				}
				catch (ClassNotFoundException e) {
				}
				if (clz != null) {
					classes.add(clz);
				}
			}
		}
		return classes;
	}

}
