package kr.ac.dongseo.reservation.dto;

import java.util.Date;

public class ProductImage {
	/*
     *   요소출처
     *  ------------------------------------------
     *  product_image	:	product_id,
     *  					id, // productImageId
     *	 					type
     *  ------------------------------------------
     *  file_info 		:	id, // fileInfoId
     *  					file_name,
     *  					save_file_name,
     *  					content_type,
     *  					delete_flag,
     *  					create_date,
     *  					modify_date
	 */
	
	private int productId;
	private int productImageId;
	private String type;
	private int fileInfoId;
	private String fileName;
	private String saveFileName;
	private String contentType;
	private int deleteFlag;
	private Date createDate;
	private Date modifyDate;
	public int getProductId() {
		return productId;
	}
	public void setProduct_id(int productId) {
		this.productId = productId;
	}
	public int getProductImageId() {
		return productImageId;
	}
	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getFileInfoId() {
		return fileInfoId;
	}
	public void setFileInfoId(int fileInfoId) {
		this.fileInfoId = fileInfoId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "ProductImage [productId=" + productId + ", productImageId=" + productImageId + ", type=" + type
				+ ", fileInfoId=" + fileInfoId + ", fileName=" + fileName + ", saveFileName=" + saveFileName
				+ ", contentType=" + contentType + ", deleteFlag=" + deleteFlag + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + "]";
	}
	
}
