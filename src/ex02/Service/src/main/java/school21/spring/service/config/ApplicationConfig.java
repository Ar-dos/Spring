package school21.spring.service.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import school21.spring.service.repositories.UsersRepository;
import school21.spring.service.repositories.UsersRepositoryJdbcImpl;
import school21.spring.service.repositories.UsersRepositoryJdbcTemplateImpl;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@PropertySource("classpath:db.properties")
public class ApplicationConfig {
    @Value("${db.url}") String url;
    @Value("${db.user}") String user;
    @Value("${db.password}") String password;
    @Bean
    public DataSource getDataSourceHikari() {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);

        config.setMaximumPoolSize(10);
        config.setAutoCommit(false);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(config);
    }

    @Bean
    public UsersRepository getUsersRepositoryTemplate() throws SQLException {
        return new UsersRepositoryJdbcTemplateImpl(getDataSourceHikari());
    }

    @Bean
    public UsersRepository getUsersRepository() throws SQLException {
        return new UsersRepositoryJdbcImpl(getDataSourceHikari());
    }
}