package kr.ac.dongseo.reservation.dao.sqls;

public class ReservationInfoPriceDaoSqls {
	public static final String SELECT_BY_ID = "SELECT id, reservation_info_id, product_price_id, count"
			+ " FROM reservation_info_price"
			+ " WHERE id = :id";
	
	public static final String DELETE_BY_RESERVATION_INFO_ID = "DELETE FROM reservation.reservation_info_price WHERE reservation_info_id = :reservationInfoId";
	
	public static final String SELECT_COUNT_BY_RESERVATION_INFO_ID = "SELECT COUNT(*) AS count FROM reservation.reservation_info_price WHERE reservation_info_id = :reservationInfoId";
}
