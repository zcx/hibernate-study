package Metadata.ns.impl;

import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.hibernate.Query;
import org.hibernate.Session;

import Metadata.ns.Namespace;
import Metadata.util.HibernateUtil;

@Entity(name="Namespace")
public abstract class HBRNamespaceImpl extends HBRMetaObjectImpl implements Namespace {

	@Column(name = "LFT")
	private int left;

	@Column(name = "RGT")
	private int right;

	@Column(name = "NAME")
	private String name;

	@Transient
	private String entityname = null;

	protected HBRNamespaceImpl(Namespace parent, String name) {
		//this.setParent((HBRNamespaceImpl) parent);
		this.setName(name);
		this.entityname = this.getEntityName();
	}

	public Namespace getParent() {
		//查询LET<this.left,RGT>this.RGT，则得到全部的父节点，其中RGT最小的是直接父节点
		Session session = HibernateUtil.getSession();
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("from ").append(entityname).append(" where LFT<").append(this.getLeft()).append(" and RGT > ").append(
					this.getRight());
			String hql = sb.toString();
			Object obj = session.load(hql, null);
			Iterator it = session.createQuery(hql).iterate();
			if (it.hasNext()) {
				return (Namespace) it.next();
			}
			else {
				return null;
			}
		}
		finally {
			session.close();
		}
	}

	protected void setLeft(int left) {
		this.left = left;
	}

	protected int getLeft() {
		return left;
	}

	protected void setRight(int right) {
		this.right = right;
	}

	protected int getRight() {
		return right;
	}

	@Override
	public String getName() {
		return this.name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAbsolutePath() {
		Session session = HibernateUtil.getSession();
		String entityname = this.getEntityName();
		StringBuffer sb = new StringBuffer(30);
		sb.append("from ").append(entityname);
		sb.append(" where LFT>10 OR RGT<3");
		//		DetachedCriteria cri = this.createDetachedCriteria();
		//		List list = cri.getExecutableCriteria(session).list();
		//		for(int i = 0; i < list.size();i++){
		//			Object obj = list.get(i);
		//			System.out.println(obj);
		//		}
		Query query = session.createQuery("update FileObject set LFT=3");
		query.executeUpdate();
		//Iterator it = query.iterate();

		//		query.setParameter("entity", this.getEntityName());
		//		//query.setLockMode(paramString, paramLockMode);
		//		int row = query.executeUpdate();
		//		System.out.println("执行了" + row + "行更新!");
		return null;
	}

	@Override
	public boolean exists() {
		return false;
	}

	@Override
	public Namespace getRoot() {
		Session session = HibernateUtil.getSession();
		session = HibernateUtil.getSession();
		return null;
	}

	@Override
	public boolean delete() {
		return false;
	}

	@Override
	public boolean create() {
		return false;
	}

	@Override
	public Namespace[] list() {
		return null;
	}

	@Override
	public boolean renameTo(Namespace dest) {
		return false;
	}

	@Override
	public boolean moveTo(Namespace parent) {
		return false;
	}

	@Override
	public boolean copyTo(Namespace parent) {
		return false;
	}

	@Override
	public int compareTo(Namespace file) {
		// TODO Auto-generated method stub
		return 0;
	}
}
