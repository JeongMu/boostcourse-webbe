package kr.ac.dongseo.reservation.dao;

import static kr.ac.dongseo.reservation.dao.sqls.ProductPriceDaoSqls.SELECT_BY_PRODUCT_ID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.dongseo.reservation.dto.ProductPrice;

@Repository
public class ProductPriceDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductPrice> rowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);
	
	public ProductPriceDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductPrice> selectAllByProductId(Integer productId){
		Map<String, Integer> params = new HashMap<>();
		params.put("product_id", productId);
		
		return jdbc.query(SELECT_BY_PRODUCT_ID, params, rowMapper);
	}
	
}
