package com.danny.checkinapi;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import com.nur.annotations.Generated;
import com.nur.repositories.ICommendPersonRepository;
import com.nur.repositories.ICommendPropertyRepository;
import com.nur.repositories.IUserRepository;
import infraestructure.repositories.commendPerson.CommendPersonCrudRepositoryImpl;
import infraestructure.repositories.commendProperty.CommendPropertyCrudRepositoryImpl;
import infraestructure.repositories.users.UserCrudRepositoryImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@SpringBootApplication(
    scanBasePackages = {"com.danny.checkinapi.service", "com.danny.checkinapi.controllers"})
@ComponentScan(
    basePackages = {
      "com.danny.checkinapi.controllers",
      "com.danny.checkinapi.service",
      "infraestructure.repositories",
      "use.cases",
      "com/nur/event",
      "core",
    })
@EntityScan("infraestructure.model")
@EnableJpaRepositories(basePackages = {"infraestructure.repositories"})
@EnableTransactionManagement
@OpenAPIDefinition(info = @Info(title = "Check in Domain", version = "1.0.0"))
@Generated
@EnableKafka
public class CheckInApiApplication {
  private static final Logger LOG = LoggerFactory.getLogger(CheckInApiApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(CheckInApiApplication.class, args);
  }

	@Bean(name = "usersRepository")
	public IUserRepository usersRepository(){
		return new UserCrudRepositoryImpl();
	}

	@Bean(name = "commendPersonRepository")
	public ICommendPersonRepository commendPersonRepository(){
	  return new CommendPersonCrudRepositoryImpl();
	}

	@Bean
	public ICommendPropertyRepository commendPropertyRepository(){
	  return new CommendPropertyCrudRepositoryImpl();
	}

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();

      Arrays.sort(beanNames);
      for (String beanName : beanNames) {

        System.out.println(beanName);
      }
    };
  }

  @Bean
  Pipeline pipeline(
      ObjectProvider<Command.Handler> commandHandlers,
      ObjectProvider<Notification.Handler> notificationHandlers,
      ObjectProvider<Command.Middleware> middlewares) {
    return new Pipelinr()
        .with(commandHandlers::stream)
        .with(notificationHandlers::stream)
        .with(middlewares::orderedStream);
  }
}
