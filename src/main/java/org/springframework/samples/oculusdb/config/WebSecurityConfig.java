
package org.springframework.samples.oculusdb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.samples.oculusdb.services.UserService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;


	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/**", "/webjars/**", "/h2-console/**", "/login").permitAll().antMatchers(HttpMethod.GET, "/", "/oups", "/applications/**").permitAll().antMatchers("/user/**").authenticated().antMatchers("/admin/**")
			.hasAnyAuthority("ADMIN").antMatchers("/sponsor/**").hasAnyAuthority("SPONSOR", "ADMIN").antMatchers("/developer/**").hasAnyAuthority("DEVELOPER", "ADMIN").anyRequest().denyAll().and().formLogin().loginPage("/login").failureUrl("/login-error")
			.and().logout().logoutSuccessUrl("/");
	}


	BCryptPasswordEncoder bCryptPasswordEncoder;


	// Crea el encriptador de contraseñas
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		this.bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		// El numero 4 representa que tan fuerte quieres la encriptacion.
		// Se puede en un rango entre 4 y 31.
		// Si no pones un numero el programa utilizara uno aleatoriamente cada vez
		// que inicies la aplicacion, por lo cual tus contrasenas encriptadas no
		// funcionaran bien
		return this.bCryptPasswordEncoder;
	}


	@Autowired
	UserService userDetailsService;


	// Registra el service para usuarios y el encriptador de contrasena
	@Autowired
	public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {

		// Setting Service to find User in the database.
		// And Setting PassswordEncoder
		auth.userDetailsService(this.userDetailsService).passwordEncoder(this.passwordEncoder());
	}

}
