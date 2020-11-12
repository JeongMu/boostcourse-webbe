package kr.ac.dongseo.reservation.dao.sqls;

public class PromotionDaoSqls {
	public static final String SELECT_ALL = "SELECT pr.id, pr.product_id, p.category_id,"
			+ " p.description, c.name AS category_name, pi.file_id"
			+ " FROM promotion AS pr"
			+ " JOIN product AS p ON p.id = pr.product_id"
			+ " JOIN product_image AS pi ON pi.id = pr.id"
			+ " JOIN category AS c ON c.id = p.category_id"
			+ " GROUP BY pr.id";
}
