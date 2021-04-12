package vendorapplication.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.WebUtils;
import vendorapplication.captcha.CaptchaAuthenticationProvider;
import vendorapplication.captcha.CaptchaDetailsSource;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {



    @Autowired
    private CaptchaAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
    @Autowired
    private CaptchaDetailsSource detailsSource;

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN));
        http.csrf()
                .csrfTokenRepository(csrfTokenRepository()).and()
                .addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
                http.csrf().ignoringAntMatchers("/nocsrf", "/paymentResponse/**");
                http.headers().frameOptions().sameOrigin();



                http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/downloadFile/**").permitAll()
                .antMatchers("/saveapplication/").hasAnyRole( "Vendor")
                .antMatchers("/paymentpage/**").authenticated()
                .antMatchers("/vendorapplication.ajax/**").authenticated()
                .antMatchers("/admin/**").hasAnyRole("Admin","Super Admin")
                .antMatchers("/createuser/**").hasAnyRole("Admin","Super Admin")
                .antMatchers("/saveuser/").hasAnyRole("Admin","Super Admin")
                .antMatchers("/createrole/").hasAnyRole("Admin","Super Admin")
                .antMatchers("/filterApplications/").hasAnyRole("Admin","Super Admin")
                .antMatchers("/applications/").hasAnyRole("Admin","Super Admin")
                .antMatchers("/getUserDetails/**").hasAnyRole("Admin","Super Admin")
                .antMatchers("/updateApplication/**").hasAnyRole("Admin","Super Admin")
                .antMatchers("/applications_all/**").hasAnyRole("Admin","Super Admin")
                .antMatchers("/checkpayment/**").hasAnyRole("Admin","Super Admin")
                .antMatchers("/index/**").hasAnyRole("Admin","Super Admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(loginSuccessHandler())
                .failureHandler(loginFailureHandler())
                .authenticationDetailsSource(detailsSource).permitAll().and()
                .logout().logoutSuccessHandler(logoutSuccessHandler())
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .and()
                .invalidSessionUrl("/login");


    }

    private Filter csrfHeaderFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

                CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
                if (csrf != null) {
                    Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
                    String token = csrf.getToken();
                    if (cookie == null || token != null && !token.equals(cookie.getValue())) {
                        cookie = new Cookie("XSRF-TOKEN", token);
                        cookie.setPath("/");
                        cookie.setSecure(true);
                        cookie.setHttpOnly(true);
                        response.addCookie(cookie);
                    }
                }

                Collection<String> headers = response.getHeaders("Set-Cookie");
                boolean firstHeader = true;
                for (String header : headers) {
                    if (firstHeader) {
                        response.setHeader("Set-Cookie", String.format("%s; %s", header, "SameSite=Strict"));
                        firstHeader = false;
                        continue;
                    }
                    response.addHeader("Set-Cookie", String.format("%s; %s", header, "SameSite=Strict"));
                }
                request.setCharacterEncoding("UTF-8");
                response.setContentType("text/html; charset=UTF-8");
                response.setHeader("pragma", "no-cache");
                response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
                filterChain.doFilter(request, response);
            }
        };
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");


        return repository;
    }


    private AuthenticationSuccessHandler loginSuccessHandler() {
        return (request, response, authentication) -> response
                .sendRedirect(ServletUriComponentsBuilder.fromCurrentContextPath().path("/index").toUriString());
    }

    private AuthenticationFailureHandler loginFailureHandler() {
        return (request, response, exception) -> {
            request.getSession().setAttribute("error", "Please Enter valid User Credentials and Captcha");
            response.sendRedirect(ServletUriComponentsBuilder.fromCurrentContextPath().path("/login").toUriString());
        };
    }

    private LogoutSuccessHandler logoutSuccessHandler() {
        return (request, response, authentication) -> {
            request.getSession().setAttribute("message", "Logout Successful.");
            response.sendRedirect(ServletUriComponentsBuilder.fromCurrentContextPath().path("/login").toUriString());
        };
    }



}