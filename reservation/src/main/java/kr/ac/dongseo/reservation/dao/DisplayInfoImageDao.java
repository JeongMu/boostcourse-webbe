package kr.ac.dongseo.reservation.dao;

import static kr.ac.dongseo.reservation.dao.sqls.DisplayInfoImageDaoSqls.SELECT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.dongseo.reservation.dto.DisplayInfoImage;

@Repository
public class DisplayInfoImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfoImage> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
	
	public DisplayInfoImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<DisplayInfoImage> select(Integer displayId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("display_id", displayId);
		
		return jdbc.query(SELECT, params, rowMapper);
	}
}
