package school21.spring.service.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.config.ApplicationConfig;
import school21.spring.service.repositories.UsersRepository;
import school21.spring.service.services.UsersServiceImpl;

import javax.sql.DataSource;


public class Program {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        for (String str : context.getBeanDefinitionNames()){
            System.out.println(str);
        }
//        UsersServiceImpl usersRepository = new UsersServiceImpl( context.getBean("getDataSourceHikari", DataSource.class));
//        System.out.println(usersRepository.findAll());
    }
}
