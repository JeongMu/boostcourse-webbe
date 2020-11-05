package kr.ac.dongseo.reservation.dao.sqls;

public class CategoryDaoSqls {
	public static final String SELECT_ALL = "SELECT C.id, C.name, D.count"
			+ " FROM category AS C"
			+ " JOIN (SELECT product.category_id AS id, COUNT(product.category_id) AS count"
			+ " FROM display_info AS info"
			+ " JOIN product"
			+ " ON product.id = info.product_id"
			+ " GROUP BY product.category_id) AS D"
			+ " ON D.id = C.id;";
	
}
