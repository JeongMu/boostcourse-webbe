package kr.ac.dongseo.reservation.dao.sqls;

public class ProductDaoSqls {
	/*
	 * 	요소 출처
	 * ------------------------------------------
	 * 	product 요소		:	id,
	 * 						category_id,
	 * 						description,
	 * 						content,
	 * 						event
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
	 */
	// limit : 4
	
	public static final String SELECT_ALL = "SELECT p.id, p.category_id, d.id AS display_info_id,"
			+ " c.name, p.description, p.content, p.event, d.opening_hours,"
			+ " d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, pi.file_id,"
			+ " d.email, d.create_date, d.modify_date"
			+ " FROM product AS p"
			+ " JOIN display_info AS d ON d.product_id = p.id"
			+ " JOIN category AS c ON c.id = p.category_id"
			+ " JOIN product_image AS pi ON pi.product_id = p.id"
			+ " GROUP BY p.id" // 중복제거
			+ " ORDER BY p.id ASC LIMIT :start, :limit";
	
	public static final String SELECT_PAGING = "SELECT p.id, p.category_id, d.id AS display_info_id,"
			+ " c.name, p.description, p.content, p.event, d.opening_hours,"
			+ " d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, pi.file_id,"
			+ " d.email, d.create_date, d.modify_date"
			+ " FROM product AS p"
			+ " JOIN display_info AS d ON d.product_id = p.id"
			+ " JOIN category AS c ON c.id = p.category_id"
			+ " JOIN product_image AS pi ON pi.product_id = p.id"
			+ " WHERE p.category_id = :category_id"
			+ " GROUP BY p.id" // 중복제거
			+ " ORDER BY p.id ASC LIMIT :start, :limit";
	
	public static final String SELECT = "SELECT p.id, p.category_id, d.id AS display_info_id,"
			+ " c.name, p.description, p.content, p.event, d.opening_hours,"
			+ " d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, pi.file_id,"
			+ " d.email, d.create_date, d.modify_date"
			+ " FROM product AS p"
			+ " JOIN display_info AS d ON d.product_id = p.id"
			+ " JOIN category AS c ON c.id = p.category_id"
			+ " JOIN product_image AS pi ON pi.product_id = p.id AND pi.type = 'ma'"
			+ " WHERE p.id = :id"
			+ " GROUP BY p.id";
	
	public static final String SELECT_TOTAL_COUNT_BY_CATEGORY_ID = "SELECT COUNT(product.category_id) AS count"
			+ " FROM display_info AS info"
			+ " JOIN product"
			+ " ON product.id = info.product_id"
			+ " WHERE product.category_id = :category_id"
			+ " GROUP BY product.category_id";
	
	public static final String SELECT_TOTAL_COUNT = "SELECT COUNT(product.category_id) AS count"
			+ " FROM display_info AS info"
			+ " JOIN product"
			+ " ON product.id = info.product_id";
}
