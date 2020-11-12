package kr.ac.dongseo.reservation.dao;

import static kr.ac.dongseo.reservation.dao.sqls.ProductDaoSqls.SELECT;
import static kr.ac.dongseo.reservation.dao.sqls.ProductDaoSqls.SELECT_ALL;
import static kr.ac.dongseo.reservation.dao.sqls.ProductDaoSqls.SELECT_PAGING;
import static kr.ac.dongseo.reservation.dao.sqls.ProductDaoSqls.SELECT_TOTAL_COUNT;
import static kr.ac.dongseo.reservation.dao.sqls.ProductDaoSqls.SELECT_TOTAL_COUNT_BY_CATEGORY_ID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.dongseo.reservation.dto.Product;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	
	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Product> selectPage(Integer categoryId ,Integer start, Integer limit){
		Map<String, Integer> params = new HashMap<>();
		params.put("category_id", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		
		return jdbc.query(SELECT_PAGING, params, rowMapper);
	}
	
	/*
	 * totalCount : 해당 카테고리의 전시 상품 수
	 */
	public Long selectTotalCount(Integer categoryId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("category_id", categoryId);
		
		Map<String, Object> map = jdbc.queryForMap(SELECT_TOTAL_COUNT_BY_CATEGORY_ID, params);
		return (Long) map.get("count");
	}
	
	public Long selectTotalCount() {
		Map<String, Integer> params = new HashMap<>();
		
		Map<String, Object> map = jdbc.queryForMap(SELECT_TOTAL_COUNT, params);
		return (Long) map.get("count");
	}
	
	public List<Product> selectAll(Integer start, Integer limit){
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		
		return jdbc.query(SELECT_ALL, params, rowMapper);
	}
	
	public Product select(Integer id) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		
		return jdbc.queryForObject(SELECT, params, rowMapper);
	}
	
}
