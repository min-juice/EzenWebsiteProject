package kr.co.ezen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/visibleOrhidden", method = RequestMethod.GET)
	public String test101(){
		
		return "test101";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "main";
	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test() {
		
	}

}
