package kr.ac.dongseo.reservation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.dongseo.reservation.service.ReservationService;

@RestController
@RequestMapping("/api")
public class ReservationApiController {
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/categories")
	public Map<String, Object> getCategories(){
		return reservationService.getCategories();
	}
	
	@GetMapping("/displayinfos")
	public Map<String, Object> getProducts(@RequestParam(name="categoryId", required=false) Integer categoryId,
			@RequestParam(name="start", required=false) Integer start){
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		
		return reservationService.getProducts(params);
	}
	
	@GetMapping("/promotions")
	public Map<String, Object> getPromotions(){
		return reservationService.getPromotions();
	}
	
	@GetMapping("/displayinfos/{displayId}") 
	public Map<String, Object> getDisplayinfosByDisplayId(@PathVariable Integer displayId){
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		
		return reservationService.getDisplayinfos(params);
	}
	
	@GetMapping("/userComments")
	public Map<String, Object> getReservationUserComments(@RequestParam(name="productId", required=false) Integer productId,
			@RequestParam(name="start", required=false) Integer start){
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		params.put("start", start);
		
		return reservationService.getReservationUserComments(params);
	}
	
	@PostMapping("/reservationInfos")
	public Map<String, Object> addReservationInfo(@RequestBody Map<String, Object> params){
		
		return reservationService.addReservation(params);
	}
	
	@GetMapping("/reservationInfos")
	public Map<String, Object> getReservationInfo(){
		
		return null;
	}
	
	@PutMapping("/reservationInfos")
	public Map<String, Object> deleteReservationInfo(@RequestBody Map<String, Object> params){
		System.out.println(params);
		return reservationService.cancelReservation(params);
	}
}
