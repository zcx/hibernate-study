package Metadata.vfs;

import java.sql.Timestamp;
import java.util.HashMap;

public class FileNode {
	  private static final long serialVersionUID = 1243521894967693898L;

	  private String parentDir;//父目录

	  private String fileName;//文件名

	  private String isFile;//是否目录

	  private Timestamp createTime;//创建时间

	  private Timestamp lastModifyTime;//最后修改时间

	  private String owner;//创建者

	  private String mender;//修改者

	  private String charset;//文件编码,目录此值为空

	  private String mimeType;//文件的媒体类型

	  private long size;//文件大小

	  private byte[] content;//文件内容,如果是目录,可以存放子文件的排序

	  private HashMap props;//其它属性

	  /**
	   * 是否包含了内容
	   * 因为内容可能会很大,很多时候不需要文件的内容,
	   * 所以查询时可能不会查询文件的内容,只有在需要时才会取文件的内容
	   */
	  private boolean containContent;

	  public String getParentDir() {
	    return parentDir;
	  }

	  public void setParentDir(String parentDir) {
	    this.parentDir = parentDir;
	  }

	  public String getFileName() {
	    return fileName;
	  }

	  public void setFileName(String fileName) {
	    this.fileName = fileName;
	  }

	  public String getIsFile() {
	    return isFile;
	  }

	  public void setIsFile(String isFile) {
	    this.isFile = isFile;
	  }

	  public Timestamp getCreateTime() {
	    return createTime;
	  }

	  public void setCreateTime(Timestamp createTime) {
	    this.createTime = createTime;
	  }

	  public Timestamp getLastModifyTime() {
	    return lastModifyTime;
	  }

	  public void setLastModifyTime(Timestamp lastModifyTime) {
	    this.lastModifyTime = lastModifyTime;
	  }

	  public String getOwner() {
	    return owner;
	  }

	  public void setOwner(String owner) {
	    this.owner = owner;
	  }

	  public String getMender() {
	    return mender;
	  }

	  public void setMender(String mender) {
	    this.mender = mender;
	  }

	  public String getCharset() {
	    return charset;
	  }

	  public void setCharset(String charset) {
	    this.charset = charset;
	  }

	  public String getMimeType() {
	    return mimeType;
	  }

	  public void setMimeType(String mimeType) {
	    this.mimeType = mimeType;
	  }

	  public long getSize() {
	    return size;
	  }

	  public void setSize(long size) {
	    this.size = size;
	  }

	  public byte[] getContent() {
	    return content;
	  }

	  public void setContent(byte[] content) {
	    this.content = content;
	  }

	  public HashMap getProps() {
	    return props;
	  }

	  public void setProps(HashMap props) {
	    this.props = props;
	  }

	  public boolean getContainContent() {
	    return containContent;
	  }

	  public void setContainContent(boolean containContent) {
	    this.containContent = containContent;
	  }

	  public Object clone() throws CloneNotSupportedException {
	    return (FileNode) super.clone();
	  }

	  public String toString() {
	    return getParentDir() + getFileName();
	  }
}
