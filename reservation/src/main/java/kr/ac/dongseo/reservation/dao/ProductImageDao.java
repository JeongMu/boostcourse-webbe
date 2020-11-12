package kr.ac.dongseo.reservation.dao;

import static kr.ac.dongseo.reservation.dao.sqls.ProductImageDaoSqls.SELECT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.dongseo.reservation.dto.ProductImage;

@Repository
public class ProductImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductImage> rowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	
	public ProductImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductImage> select(Integer productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("product_id", productId);
		
		List<ProductImage> list = jdbc.query(SELECT, params, rowMapper);
		List<ProductImage> listForReturn = new ArrayList<>();
		for(ProductImage vo : list) {
			if(vo.getType().equals("ma")) {
				listForReturn.add(vo);
			}
		}

		return listForReturn;
	}
}
