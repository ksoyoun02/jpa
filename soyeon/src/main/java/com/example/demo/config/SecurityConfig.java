package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.controller.member.MemberService;

@Configuration // @Bean 어노테이션만 주어도 스프링 컨테이너에 빈으로 등록은 가능, 하지만 싱글톤을 보장받지 못함
@EnableWebSecurity //spring security를 활성화시킴
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	MemberService memberService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); //pwd를 암호화 복호화
	}
	
	@Override
				//configure : WebSecurityConfigurerAdapter를 상속받아 configure메서드를 오버라이딩 함.
	public void configure(WebSecurity web) throws Exception{
						//WebSecurity -> filterchainproxy를 생성하는 필터. 다양한 필터설정 적용가능
										//filterchainproxy -> 스프링 시큐리티 초기화 시 생성되는 필터들을 관리하고 제어
		web.ignoring().antMatchers("/css/**","/js/**","/img/**","/lib/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
						 //http요청에 대한 보안을 설정
		http.authorizeRequests()
			//authorizeRequests : httpServletRequest 요청 url에 따라 접근 권한을 설정
		
			.antMatchers("/member/**").authenticated()	//인증된 사용자
			//antMatchers : 요청 url 경로 패턴을 지정
			//authenticated : 인증된 유저만 접근을 허용
			//anonymous : 인증되지 않은 유저만 허용
			//denyAll : 모든 유저에 대해 접근을 허용하지 않음
			
			.antMatchers("/admin/**").authenticated()	//인증된 사용자
			.antMatchers("/**").permitAll();			//모든사용자
		
		http.formLogin() //로그인 설정
			.loginPage("/login")
			//loginPage : 로그인 페이지 경로와 로그인 인증경로를 등록
			.defaultSuccessUrl("/")
			//defaultSuccessUrl : 로그인 성공시 이동하는 페이지를 등록
			.usernameParameter("username")
			.passwordParameter("password")
			.successHandler(new LoginSuccessHandler())
			.permitAll();
		
		http.logout() //로그아웃 설정
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			//로그아웃 경로 지정
			.logoutSuccessUrl("/login")
			//로그아웃 성공 시 이동할 경로를 지정
			.invalidateHttpSession(true);
			//로그아웃 성공 시 세션을 제거
		
		http.exceptionHandling()
			.accessDeniedPage("/denied");
	}
	
	@Override
						//AuthenticationManagerBuilder : AuthenticationManager를 생성(사용자 인증을 담당)
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
	}
	
}

