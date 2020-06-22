package br.com.silva.app.security;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import java.util.Arrays;

@Configuration
@EnableResourceServer
@EnableWebSecurity
@AllArgsConstructor
@Slf4j
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private AppSecurityConfig appSecurityConfig;

    @Qualifier("appUserDetailsService")
    private UserDetailsService userDetailsService;


    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] aPermitAll = appSecurityConfig.getPermitRequests().builderPermitAll().toArray(new String[0]);
        String[] aPermitGet = appSecurityConfig.getPermitRequests().builderPermitGet().toArray(new String[0]);
        log.info("Configuring authorizeRequests authorizing ALL request to with filter " + Arrays.toString(aPermitAll));
        log.info("Configuring authorizeRequests authorizing GET request to with filter " + Arrays.toString(aPermitGet));
        http.authorizeRequests()
                .antMatchers(aPermitGet).permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .headers().frameOptions().disable();
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
