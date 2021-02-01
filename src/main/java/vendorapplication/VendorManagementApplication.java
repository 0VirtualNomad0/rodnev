package vendorapplication;

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
//
//	@Bean
//	ServletRegistrationBean captchaServletRegistrationLogin () {
//		ServletRegistrationBean srb = new ServletRegistrationBean();
//		srb.setName("CaptchaServletLogin");
//		srb.setServlet(new CaptchaGenServletLogin());
//		srb.addUrlMappings("/captcha.jpg");
//		return srb;
//	}


	@Bean
	public CaptchaDetailsSource getCaptchaDetailsSource() {
		return new CaptchaDetailsSource();
	}



}
