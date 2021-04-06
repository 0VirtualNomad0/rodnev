package vendorapplication;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import vendorapplication.captcha.CaptchaDetailsSource;
import vendorapplication.captcha.CaptchaGenServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import vendorapplication.captcha.CaptchaGenServletLogin;
import vendorapplication.property.FileStorageProperties;

import java.io.UnsupportedEncodingException;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableConfigurationProperties({FileStorageProperties.class})
public class VendorManagementApplication {

	public static void main(String[] args) throws UnsupportedEncodingException { SpringApplication.run(VendorManagementApplication.class, args);

	}


		@Bean
	ServletRegistrationBean captchaServletRegistration () {
		ServletRegistrationBean srb = new ServletRegistrationBean();
		srb.setName("CaptchaServlet");
		srb.setServlet(new CaptchaGenServlet());
		srb.addUrlMappings("/captcha.jpg");
		return srb;
	}



	@Bean
	public CaptchaDetailsSource getCaptchaDetailsSource() {
		return new CaptchaDetailsSource();
	}



}
