package com.dhht;


import javax.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:transaction.xml")
@SpringBootApplication
@ComponentScan(basePackages= {"com.dhht.*"}) //不加默认为启动类所在的包的里的对象
//@ImportResource("classpath:transaction.xml")
public class DemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	//sessionFactory,hibernate必须的
    @Bean
    public SessionFactory sessionFactory(@Qualifier("entityManagerFactory") EntityManagerFactory emf){
         return emf.unwrap(SessionFactory.class);
     }
}
