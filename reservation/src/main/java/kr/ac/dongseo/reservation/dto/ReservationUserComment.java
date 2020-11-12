package kr.ac.dongseo.reservation.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ReservationUserComment {
	/*
	 * 요소출처
	 * ------------------------------------------
	 * reservation_user_comment		:		id,
	 *										product_id,
	 *										reservation_info_id,
	 *										score,
	 *										comment,
	 *										create_date,
	 *										modify_date
	 *------------------------------------------
	 * reservation_user_comment_image	:	file_id // reservationUserCommentImages[]
	 * ------------------------------------------
	 * user							:		email, // reservationEmail
	 * 								
	 * 
	 * reservationUserComments": [
        {
            "id": 15,
            "productId": 1,
            "reservationInfoId": 15,
            "score": 5,
            "reservationEmail": "dorosi@connect.co.kr",
            "comment": "즐거움!!!",
            "createDate": "2020-03-16 15:49:48.0",
            "modifyDate": "2020-03-16 15:49:48.0",
            "reservationUserCommentImages": []
        }
	 */
	private int id;
	private int productId;
	private int reservationInfoId;
	private BigDecimal score;
	private String reservationEmail;
	private String comment;
	private Date createDate;
	private Date modifyDate;
	private List<Integer> reservationUserCommentImages;
	
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
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	public BigDecimal getScore() {
		return score;
	}
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	public String getReservationEmail() {
		return reservationEmail;
	}
	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public List<Integer> getReservationUserCommentImages() {
		return reservationUserCommentImages;
	}
	public void setReservationUserCommentImages(List<Integer> reservationUserCommentImages) {
		this.reservationUserCommentImages = reservationUserCommentImages;
	}
	@Override
	public String toString() {
		return "ReservationUserComment [id=" + id + ", productId=" + productId + ", reservationInfoId="
				+ reservationInfoId + ", score=" + score + ", reservationEmail=" + reservationEmail + ", comment="
				+ comment + ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ ", reservationUserCommentImages=" + reservationUserCommentImages + "]";
	}
	
}
