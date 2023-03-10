package com.example.Backend.sec.Secirity;
import com.example.Backend.sec.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AccountService accountService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    public SecurityConfig(AccountService accountService){
        this.accountService = accountService;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login/**","/register/**","/getAdresssByUserName/** ","/Articles","/ajtArticles/**","/addarticleToPanier/**","/Commandes" ,"/ClientPanier/**","/ArticlesPanier","/getRole","/ajtCommandes/**","/qtes").permitAll();
        http.authorizeRequests().antMatchers("/appUsers/**","/appRoles/**").hasAuthority("adminSc");
        http.authorizeRequests().antMatchers("/appUsers/**").hasAuthority("client");
        http.authorizeRequests().antMatchers("/Students/AdminAuth/**").hasAuthority("fournisseur");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);
    }
}
