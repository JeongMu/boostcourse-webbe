package kr.ac.dongseo.reservation.dto;

import java.util.Date;

public class Product {
	
	/*
	 * 	요소 출처
	 * ------------------------------------------
	 * 	product 요소		:	id,
	 * 						category_id,
	 * 						description,
	 * 						content,
	 * 						event,
	 * ------------------------------------------
	 * 	catecory 요소 	: 	name
	 * ------------------------------------------
	 * 	display_info 요소	: 	id, // displayInfoId
	 * 						opening_hours,
	 * 						place_name,
	 * 						place_lot,
	 * 						place_street,
	 * 						tel,
	 * 						homepage,
	 * 						email,
	 * 						create_date,
	 * 						modify_date
	 * ------------------------------------------
	 * product_image 요소	:	file_id
	 */
	private int id;
	private int categoryId;
	private int displayInfoId; // display_info id
	private String name; // category name
	private String description;
	private String content;
	private String event;
	private String openingHours; // display_info opening_hours
	private String placeName; // display_info place_name
	private String placeLot; // display_info place_lot
	private String placeStreet; // display_info place_street
	private String tel; // display_info tel
	private String homepage; // display_info homepage
	private String email; // display_info email
	private Date createDate; // display_info create_date
	private Date modifyDate; // display_info modify_date
	private int fileId;
	
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceLot() {
		return placeLot;
	}
	public void setPlaceLot(String placeLot) {
		this.placeLot = placeLot;
	}
	public String getPlaceStreet() {
		return placeStreet;
	}
	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		return "Product [id=" + id + ", categoryId=" + categoryId + ", displayInfoId=" + displayInfoId + ", name="
				+ name + ", description=" + description + ", content=" + content + ", event=" + event
				+ ", openingHours=" + openingHours + ", placeName=" + placeName + ", placeLot=" + placeLot
				+ ", placeStreet=" + placeStreet + ", tel=" + tel + ", homepage=" + homepage + ", email=" + email
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}
	
	
}
