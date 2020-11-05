package kr.ac.dongseo.reservation.dao;

import static kr.ac.dongseo.reservation.dao.sqls.ReservationInfoPriceDaoSqls.DELETE_BY_RESERVATION_INFO_ID;
import static kr.ac.dongseo.reservation.dao.sqls.ReservationInfoPriceDaoSqls.SELECT_BY_ID;
import static kr.ac.dongseo.reservation.dao.sqls.ReservationInfoPriceDaoSqls.SELECT_COUNT_BY_RESERVATION_INFO_ID;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.ac.dongseo.reservation.dto.ReservationInfoPrice;

@Repository
public class ReservationInfoPriceDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationInfoPrice> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfoPrice.class);
	private SimpleJdbcInsert insertAction;
	
	public ReservationInfoPriceDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_info_price")
				.usingGeneratedKeyColumns("id");
	}
	
	public ReservationInfoPrice selectById(Integer id) {
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("id", id);
		
		return jdbc.queryForObject(SELECT_BY_ID, paramMap, rowMapper);
	}
	
	public Long insert(ReservationInfoPrice reservationInfoPrice) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfoPrice);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	public int deleteByReservationInfoId(Integer resInfoId) {
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("reservationInfoId", resInfoId);
		
		return jdbc.update(DELETE_BY_RESERVATION_INFO_ID, paramMap);
	}
	
	public int selectCountByReservationInfoId(Integer resInfoId) {
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("reservationInfoId", resInfoId);

		Map<String, Object> resultMap = jdbc.queryForMap(SELECT_COUNT_BY_RESERVATION_INFO_ID, paramMap);
		return ((Long) resultMap.get("count")).intValue();
	}
}
