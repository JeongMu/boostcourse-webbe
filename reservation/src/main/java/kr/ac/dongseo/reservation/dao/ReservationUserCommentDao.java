package kr.ac.dongseo.reservation.dao;

import static kr.ac.dongseo.reservation.dao.sqls.ReservationUserCommentDaoSqls.SELECT_ALL_IMAGES;
import static kr.ac.dongseo.reservation.dao.sqls.ReservationUserCommentDaoSqls.SELECT_BY_PRODUCT_ID;
import static kr.ac.dongseo.reservation.dao.sqls.ReservationUserCommentDaoSqls.SELECT_PAGING;
import static kr.ac.dongseo.reservation.dao.sqls.ReservationUserCommentDaoSqls.SELECT_SCORE_BY_PRODUCT_ID;
import static kr.ac.dongseo.reservation.dao.sqls.ReservationUserCommentDaoSqls.SELECT_TOTAL_COUNT;
import static kr.ac.dongseo.reservation.dao.sqls.ReservationUserCommentDaoSqls.SELECT_TOTAL_COUNT_BY_PRODUCT_ID;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.dongseo.reservation.dto.ReservationUserComment;

@Repository
public class ReservationUserCommentDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationUserComment> rowMapper = BeanPropertyRowMapper.newInstance(ReservationUserComment.class);
	
	public ReservationUserCommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ReservationUserComment> selectByProductId(Integer productId, Integer start, Integer limit){
		Map<String, Integer> params = new HashMap<>();
		params.put("product_id", productId);
		params.put("start", start);
		params.put("limit", limit);

		List<ReservationUserComment> reservationUserComments = jdbc.query(SELECT_BY_PRODUCT_ID, params, rowMapper);
		reservationUserComments = setReservationUserCommentImages(reservationUserComments);
		
		return reservationUserComments;
	}
	
	public List<ReservationUserComment> selectAll(Integer start, Integer limit){
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		
		List<ReservationUserComment> reservationUserComments = jdbc.query(SELECT_PAGING, params, rowMapper);
		reservationUserComments = setReservationUserCommentImages(reservationUserComments);
		
		return reservationUserComments;
	}
	
	private List<ReservationUserComment> setReservationUserCommentImages(List<ReservationUserComment> reservationUserComments){
		for(ReservationUserComment vo : reservationUserComments) {
			Integer reservationUserCommentId = vo.getId();
			vo.setReservationUserCommentImages(getReservationUserCommentImages(reservationUserCommentId));
		}
		
		return reservationUserComments;
	}
	
	private List<Integer> getReservationUserCommentImages(Integer reservationUserCommentId){
		Map<String, Integer> params = new HashMap<>();
		params.put("reservationUserCommentId", reservationUserCommentId);
		List<Map<String, Object>> imageMapList = jdbc.queryForList(SELECT_ALL_IMAGES, params);
		
		List<Integer> imageList = new ArrayList<Integer>();
		for(Map<String, Object> infoMap : imageMapList) {
			imageList.add((Integer) infoMap.get("file_id"));
		}
		
		return imageList;
	}
	
	public List<BigDecimal> selectScore(Integer productId){
		Map<String, Integer> params = new HashMap<>();
		params.put("product_id", productId);
		
		List<Map<String, Object>> scoreMapList = jdbc.queryForList(SELECT_SCORE_BY_PRODUCT_ID, params);
		
		List<BigDecimal> listForReturn = new ArrayList<>();
		for(Map<String, Object> scoreMap : scoreMapList) {
			listForReturn.add((BigDecimal) scoreMap.get("score"));
		}
		
		return listForReturn;
	}
	
	public Long selectTotalCount(Integer productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("product_id", productId);
		Map<String, Object> objectMap = jdbc.queryForMap(SELECT_TOTAL_COUNT_BY_PRODUCT_ID, params);
		
		return (Long) objectMap.get("count");
	}
	
	public Long selectTotalCount() {
		Map<String, Integer> params = new HashMap<>();
		Map<String, Object> objectMap = jdbc.queryForMap(SELECT_TOTAL_COUNT, params);
		
		return (Long) objectMap.get("count");
	}
}
