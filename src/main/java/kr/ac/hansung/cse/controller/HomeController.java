package kr.ac.hansung.cse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// @RequestMapping(value="/", method = RequestMethod.GET)
	@GetMapping("/") // 위와 동일한 역할임. 더 간단히 쓰기 위함
	public String home(Model model) {
		// 로그 출력
		logger.debug("Calling home( )" );
		
		model.addAttribute("message", "hello world");
		return "index"; // html 파일
	}
}