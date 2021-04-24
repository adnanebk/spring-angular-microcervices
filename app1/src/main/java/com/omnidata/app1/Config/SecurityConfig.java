/*
package com.omnidata.app1.Config;


import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests().antMatchers("/employees/**")
                .hasRole("user")
                .anyRequest()
                .authenticated();
        http.cors();
        http.csrf().disable();

        //http.authorizeRequests(authorize -> authorize.anyRequest().authenticated())
                //.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }


}
*/
