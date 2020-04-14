package br.com.pipa.game.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Value("${br.com.pipa.admin.user}")
    private String user;

    @Value("${br.com.pipa.admin.password}")
    private String password;

    String[] staticResources  =  {
            "/images/**",
            "/static/**",
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {

        http.authorizeRequests()
                .antMatchers(staticResources).permitAll()
                .antMatchers("/healthcheck/**").permitAll()
                .anyRequest().authenticated().and().httpBasic();
        http.csrf().disable();

    }




    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception
    {
        auth.inMemoryAuthentication()

                .withUser(user)
                .password("{noop}"+password)
                .roles("USER");
    }
}