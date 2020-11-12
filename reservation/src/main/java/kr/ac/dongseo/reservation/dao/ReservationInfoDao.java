package kr.ac.dongseo.reservation.dao;

import static kr.ac.dongseo.reservation.dao.sqls.ReservationInfoDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.ac.dongseo.reservation.dto.ReservationInfo;

@Repository
public class ReservationInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ReservationInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
	private ObjectMapper objectMapper = new ObjectMapper();

	public ReservationInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_info")
				.usingGeneratedKeyColumns("id");
	}

	public Map<String, Object> selectById(Integer id) {
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("id", id);

		return objectMapper.convertValue(jdbc.queryForObject(SELECT_BY_ID, paramMap, rowMapper), Map.class);
	}

	public Long insert(ReservationInfo reservationInfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
		return insertAction.executeAndReturnKey(params).longValue();
	}

	public Map<String, Object> updateCancelFlag(Integer id){
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("id", id);

		Map<String, Object> resultMap = new HashMap<>();
		int result = jdbc.update(UPDATE_CANCEL_FLAG_BY_ID, paramMap);
		if(result > 0){
			resultMap.put("result", "success");
		}
		return resultMap;
	}


	public int selectCountById(int id){
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("id", id);

		Map<String, Object> resultMap = jdbc.queryForMap(SELECT_COUNT_BY_ID, paramMap);
		return ((Long) resultMap.get("count")).intValue();
	}
}
