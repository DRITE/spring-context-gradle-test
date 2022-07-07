package dev.drite.config;

import dev.drite.Application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInit implements WebApplicationInitializer {

	private static final Logger log = LogManager.getLogger(Application.class);

	@Override
	public void onStartup(ServletContext context) throws ServletException {
		System.out.println("!!!!");
		log.error("!!!WebInit::onStartup!!!");
		AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
//		servletContext.register(WebConfig.class);
		ServletRegistration.Dynamic dispatcher = context.addServlet("dispatcher",
				new DispatcherServlet(servletContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}
