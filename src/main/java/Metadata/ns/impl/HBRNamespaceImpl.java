package Metadata.ns.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import org.hibernate.Query;
import org.hibernate.Session;

import Metadata.ns.Namespace;

@Entity(name = "Namespace")
@NamedQueries(value = {
//查找所有的叶子节点
		@NamedQuery(name = "leafNS", query = "from FileObject"),
		//
		@NamedQuery(name = "moveTo", query = "from Namespace"),

		//@NamedQuery(name = "renumber", query = "delete Namespace WHERE LFT=2"),
		//
		@NamedQuery(name = "copyTo", query = "from Namespace"),
		//
		@NamedQuery(name = "rename", query = "from Namespace"),
		//
		@NamedQuery(name = "listChilds", query = "from Namespace"),
		//
		@NamedQuery(name = "listAllChilds", query = "from Namespace"),

//@NamedQuery(name="insertNamespace", query="update Namespace set lft = lft + 2 where lft < :lft")
//
})
public abstract class HBRNamespaceImpl extends HBRMetaObjectImpl implements Namespace {
	
	private static final String UPDATE_AFTER_INSERT = "update FileObject set LFT = 1 where LFT <> 1";
	
	private static final String GET_ALL_LEAFS = "from Namespace where LFT = RGT - 1";
	
	private static final String MOVE_TO = "";
	
	@Column(name = "LFT")
	private int left;

	@Column(name = "RGT")
	private int right;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@JoinColumn(name = "PID")
	private HBRNamespaceImpl parent = null;

	@Transient
	private Session session;

	protected HBRNamespaceImpl(Session session, Namespace parent, String name) {
		this.session = session;
		this.setParent((HBRNamespaceImpl) parent);
		this.setName(name);
//		Iterator it = session.getNamedQuery("rm").iterate();
//		while (it.hasNext()) {
//			System.out.println("VFS对象：" + it.next());
//		}
	}

	public Namespace getParent() {
		return parent;
	}

	public void setParent(HBRNamespaceImpl parent) {
		if (parent == null) {
			this.setLeft(1);
			this.setRight(2);
		}
		else {
			int pleft = parent.getLeft();
			this.setLeft(pleft + 1);
			this.setRight(pleft + 2);
		}
		this.parent = parent;
	}

	public boolean isRoot() {
		return false;
	}

	public void setIsRoot(boolean isroot) {

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
		Query query = session.createQuery("update FileObject set LFT = 1 where LFT <> 1");
		//Query query = session.createQuery("from FileObject");
		//query.setLockMode(paramString, paramLockMode);
		int row = query.executeUpdate();
		//System.out.println("执行了" + row + "行更新!");
		return null;
	}

	@Override
	public boolean exists() {
		return false;
	}

	@Override
	public Namespace getRoot() {
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
