package kr.or.connect.guestbook.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.guestbook.config.ApplicationConfig;
import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.service.GuestbookService;

public class GuestbookServiceTest {
	
	private static ApplicationContext ac;

	public static void main(String[] args) {
		ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GuestbookService guestbookService = ac.getBean(GuestbookService.class);
		
		Guestbook guestbook = new Guestbook();
		guestbook.setName("Jeongmu33");
		guestbook.setContent("Hello, World!! Hello, Java!!");
		Guestbook result = guestbookService.addGuestbook(guestbook, "127.0.0.1");
		System.out.println(result);
	}
}
