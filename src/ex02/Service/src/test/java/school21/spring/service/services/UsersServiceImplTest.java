package school21.spring.service.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import school21.spring.service.config.ApplicationConfig;
import school21.spring.service.config.TestApplicationConfig;
import school21.spring.service.repositories.UsersRepository;
import school21.spring.service.repositories.UsersRepositoryJdbcImpl;
import school21.spring.service.repositories.UsersRepositoryJdbcTemplateImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;
import javax.sql.DataSource;
import java.sql.SQLException;

public class UsersServiceImplTest {
    private  UsersServiceImpl usersService;
    private UsersRepositoryJdbcImpl usersRepositoryJdbc;

    private String res;

    @BeforeEach
    void init() throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestApplicationConfig.class);
        usersService = new UsersServiceImpl(context.getBean("getUsersRepository", UsersRepositoryJdbcImpl.class));
        res = usersService.signUp("test@test.ru");
    }

    @Test
    void signUpTest() throws SQLException {
        assertEquals(res,usersService.usersRepository.findByEmail("test@test.ru").get().getPassword());
    }
}
