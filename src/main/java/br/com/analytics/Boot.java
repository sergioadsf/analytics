package br.com.analytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@ImportResource({ "classpath:application-config.xml" })
public class Boot extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "home";
	}
}
