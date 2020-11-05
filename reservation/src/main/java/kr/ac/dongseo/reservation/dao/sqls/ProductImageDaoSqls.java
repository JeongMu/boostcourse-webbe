package kr.ac.dongseo.reservation.dao.sqls;

public class ProductImageDaoSqls {
	public static final String SELECT = "SELECT pi.product_id, pi.id AS product_image_id, pi.type,"
			+ " fi.id AS file_info_id, fi.file_name, fi.save_file_name, fi.content_type,"
			+ " fi.delete_flag, fi.create_date, fi.modify_date"
			+ " FROM product_image AS pi"
			+ " JOIN file_info AS fi"
			+ " ON fi.id = pi.file_id"
			+ " WHERE pi.product_id = :product_id";
}
