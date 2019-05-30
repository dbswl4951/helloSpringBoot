package kr.ac.hansung.cse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// Java Class를 사용하여 Configuration
@Configuration // 해당 클래스가 Configuration 클래스임을 명시
@EnableWebSecurity // WebSecurity 기능 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		.anyRequest() // 어떤 request든
        		.permitAll() // 다 허용
        		.and()
            .csrf().disable(); // csrf기능 사용 X
    }
}