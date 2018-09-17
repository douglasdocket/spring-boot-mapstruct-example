package com.github.douglasdocket.mapstruct.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", ""})
public class HomeController {

	@RequestMapping
	public String redirect() {
		return "redirect:/empresa";
	}

}
