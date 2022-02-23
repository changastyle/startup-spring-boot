package com.kc.kasey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootApplication
@EnableWebMvc
@org.springframework.web.bind.annotation.RestController
public class KaseyApplication {

	public static ApplicationContext appContext;
	public static Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(KaseyApplication.class, args);

		String puertoServer = environment.getProperty("local.server.port");
		System.out.println("PUERTO:" + puertoServer);
	}






	@Autowired
	public void setearEnvironment(Environment environment)
	{
		KaseyApplication.environment = environment;
	}

	@GetMapping(value = "/")
	public static RedirectView status()
	{
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("swagger-ui.html");

		return redirectView;
	}

	public static ApplicationContext dameAppContext()
	{
		return appContext;
	}
}
