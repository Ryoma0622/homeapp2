package com.home.expenses.security;

import com.home.expenses.security.jwt.AuthEntryPointJwt;
import com.home.expenses.security.jwt.AuthTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(
                "/",
                "/error",
                "/images/**",
                "/css/**",
                "/javascript/**",
                "/webjars/**",
                "/favicon.ico");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests().antMatchers("/api/auth/**").permitAll()
            .antMatchers("/api/test/**").permitAll()
            .anyRequest().authenticated();

        http.formLogin()
            .failureHandler(new LoginAuthenticationFailureHandler())
            .usernameParameter("userId").passwordParameter("password");

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);


//        http.authorizeRequests()
//            .antMatchers("/", "/error").permitAll()
//            .anyRequest().authenticated();
//
//        http.formLogin()
//            .loginProcessingUrl("/login")
//            .loginPage("/")
//            .defaultSuccessUrl("/input")
//            .failureHandler(new LoginAuthenticationFailureHandler())
//            .usernameParameter("userId").passwordParameter("password");
//
//        http.logout()
//            .logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
//            .logoutSuccessUrl("/");
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
