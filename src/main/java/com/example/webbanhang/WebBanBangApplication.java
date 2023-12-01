 package com.example.webbanhang;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebBanBangApplication  {

//	@Autowired
//	UserLoginServiceImpl loginServiceImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(WebBanBangApplication.class, args);
	}
	
	
//	extends WebSecurityConfigurerAdapter
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests().antMatchers("/").permitAll()
//		.anyRequest().authenticated()
//		.and().formLogin().loginPage("/login").defaultSuccessUrl("/").failureUrl("/login?e=error").permitAll().and().logout().permitAll()
//		.and().exceptionHandling().accessDeniedPage("/login?e=deny");
//	
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/css/**","/img/**","/js/**");
//		
//	}
//	 
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(loginServiceImpl).passwordEncoder(passwordEncoder());
//	}
//	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
//		return bCryptPasswordEncoder;
//	}
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setFieldMatchingEnabled(true)
				.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE).setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

}
