package kr.ac.dongseo.reservation.dto;

public class Promotion {
	/*
	 * 요소 출처
	 * ------------------------------------------
	 * promotion 요소		: 	id,
	 * 						product_id
	 * ------------------------------------------
	 * product 요소		:	category_id,
	 * 						description
	 * ------------------------------------------
	 * category 요소		:	name // categoryName
	 * ------------------------------------------
	 * product_image 요소	:	file_id
	 */
	private int id;
	private int productId;
	private int categoryId;
	private String categoryName;
	private String description;
	private int fileId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	@Override
	public String toString() {
		return "Promotion [id=" + id + ", productId=" + productId + ", categoryId=" + categoryId + ", description="
				+ description + ", categoryName=" + categoryName + ", fileId=" + fileId + "]";
	}
	
	
}
