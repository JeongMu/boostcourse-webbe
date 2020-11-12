package kr.ac.dongseo.reservation.dao.sqls;

public class ReservationInfoDaoSqls {

	public static final String SELECT_BY_ID = "SELECT id, product_id, cancel_flag, display_info_id, user_id, reservation_date, create_date, modify_date"
			+ " FROM reservation.reservation_info WHERE id = :id;";

	public static final String UPDATE_CANCEL_FLAG_BY_ID = "UPDATE reservation.reservation_info SET cancel_flag = 1 WHERE id = :id";

	public static final String SELECT_COUNT_BY_ID = "SELECT COUNT(*) AS count FROM reservation.reservation_info WHERE id = :id";
}
