package kr.or.connect.guestbook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuessNumberController {
	
//	private static final int COOKIE_AGE = 30 * 60;
//	private static final String COOKIE_PATH = "/";
	
	// cookie방식
//	@GetMapping(path="/guess")
//	public String guess(@RequestParam(name="number", required=false) Integer number,
//								@CookieValue(value="count", defaultValue="0", required=true) Integer count,
//								@CookieValue(value="randomNumber", defaultValue="0", required=true) Integer randomNumber,
//								ModelMap model,
//								HttpServletResponse response) {
//		
//		String message = null;
//		
//		if(number == null) {
//			count = 0;
//			randomNumber = (int) (Math.random() * 100) + 1;
//			message = "내가 생각한 숫자를 맞춰 보세요.";
//			
//			Cookie countCookie = getCountCookie(count);
//			Cookie randomNumberCookie = getRandomNumberCookie(randomNumber);
//			response.addCookie(countCookie);
//			response.addCookie(randomNumberCookie);
//			
//		} else {
//			
//			if(number < randomNumber) {
//				message = "입력한 숫자는 내가 생각한 숫자보다 작습니다.";
//
//				Cookie countCookie = getCountCookie(count);
//				Cookie randomNumberCookie = getRandomNumberCookie(randomNumber);
//				response.addCookie(countCookie);
//				response.addCookie(randomNumberCookie);
//				
//			} else if(number > randomNumber) {
//				message = "입력한 숫자는 내가 생각한 숫자보다 큽니다.";
//
//				Cookie countCookie = getCountCookie(count);
//				Cookie randomNumberCookie = getRandomNumberCookie(randomNumber);
//				response.addCookie(countCookie);
//				response.addCookie(randomNumberCookie);
//				
//			} else {
//				message = ++count + "번째만에 맞췄습니다. 내가 생각한 숫자는 " + number + "입니다.";
//			}
//			
//		}
//		
//		model.addAttribute("message", message);
//		model.addAttribute("count", count);
//		
//		return "guess";
//	}
//	
//	private Cookie getRandomNumberCookie(int randomNumber) {
//		Cookie randomNumberCookie = new Cookie("randomNumber", Integer.toString(randomNumber));
//		randomNumberCookie.setMaxAge(COOKIE_AGE); // 30분동안 유지
//		randomNumberCookie.setPath(COOKIE_PATH);
//		
//		return randomNumberCookie;
//	}
//	
//	private Cookie getCountCookie(int count) {
//		Cookie countCookie = new Cookie("count", Integer.toString(++count));
//		countCookie.setMaxAge(COOKIE_AGE); // 30분동안 유지
//		countCookie.setPath(COOKIE_PATH);
//		
//		return countCookie;
//	}
	
	// session, servlet방식
	@GetMapping(path="/guess")
	public String guess(@RequestParam(name="number", required=false) Integer number,
						HttpSession session,
						ModelMap model) {
		
		String message = null;
		
		if(number == null) {
			session.setAttribute("count", 0);
			session.setAttribute("randomNumber", (int)(Math.random() * 100) + 1);
			message = "내가 생각한 숫자를 맞춰보세요.";
		} else {
			
			int count = (Integer) session.getAttribute("count");
			int randomNumber = (Integer) session.getAttribute("randomNumber");
			
			if(number < randomNumber) {
				message = "입력한 숫자는 생성된 임의의 숫자보다 작습니다";
				session.setAttribute("count", ++count);
			} else if(number > randomNumber) {
				message = "입력한 숫자는 생성된 임의의 숫자보다 큽니다";
				session.setAttribute("count", ++count);
			} else {
				message = ++count + "번째만에 맞췄습니다. 내가 생각한 숫자는 " + randomNumber + "입니다.";
				session.removeAttribute("count");
				session.removeAttribute("randomNumber");
			}
		}
		
		model.addAttribute("message", message);
		
		return "guess";
	}
	
}
