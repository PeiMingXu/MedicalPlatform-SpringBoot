package com.xmut.config;

import com.xmut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * @author PMX
 * @date: 2024/1/13 12:54
 * @Description：
 **/
//AOP：拦截器
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页只有对应又权限的人才能访问
        http.authorizeRequests()
                .antMatchers("/").permitAll() //所有人都可以访问主页
                .antMatchers("/level1/**").hasRole("vip1") //vip1可以访问
                .antMatchers("/level2/**").hasRole("vip2") //vip2可以访问
                .antMatchers("/level3/**").hasRole("vip3");//vip3可以访问
        //没有权限默认会到登陆页面 login
        //loginPage("") 自己设置一个登录页  定制登录页 不设置就默认 login
        //loginProcessingUrl("/login") 登陆认证时请求的路径
        //.usernameParameter("username").passwordParameter("password") 可设置指定前端 input的name属性
        http.formLogin().loginPage("/toLogin").usernameParameter("username").passwordParameter("password").loginProcessingUrl("/login");

        //防止网址攻击： get post
        http.csrf().disable();//关闭 csrf功能

        //注销 ,开启注销功能，跳到首页
        http.logout().logoutSuccessUrl("/");

        //开启记住我的功能 cookie默认保存两周
        //自定义接收前端的参数 .rememberMeParameter("remember") 前端的记住我的 name属性的值
        http.rememberMe().rememberMeParameter("remember");
    }
    //认证
    //密码编码: PasswordEncoder 报错
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // //使用数据库数据
        // User.UserBuilder users=User.withDefaultPasswordEncoder();
        // auth.jdbcAuthentication()
        //         .dataSource(dataSource)
        //         .withDefaultSchema()
        //         .withUser(users.username("user").password("password").roles("USER"))
        //         .withUser(users.username("admin").password("password").roles("USER","ADMIN"));

        // System.out.println("auth=="+auth);
        // auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()) //设置密码加密
        //         .withUser("pmx").password(new BCryptPasswordEncoder().encode("123")).roles("vip2","vip3") //密码编码
        //         .and()
        //         .withUser("root").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip2","vip3")
        //         .and()
        //         .withUser("guest").password(new BCryptPasswordEncoder().encode("123")).roles("vip1");
        //
      }

    /*
     * 忽略静态文件得访问控制
     * 放行静态资源
     * */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //配置静态文件不需要认证
        web.ignoring().antMatchers("/css/**" ,"/app-assets/**","/js/**" ,"/plugins/**" ,"/fonts/**" ,"/images/**" , "/img/**" ,"**/favicon.ico","/index.html" );
    }



}


