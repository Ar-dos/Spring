package school21.spring.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;
import school21.spring.service.repositories.*;

import javax.sql.DataSource;
import java.nio.charset.Charset;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class UsersServiceImpl implements UsersService {

    public UsersRepository usersRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")

    public UsersServiceImpl(UsersRepository getUsersRepository) throws SQLException {
        this.usersRepository = getUsersRepository;
    }
    public String signUp(String email) {
        String result = null;
        if (!usersRepository.findByEmail(email).isPresent()) {
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            result = new String(array, Charset.forName("UTF-8"));
            usersRepository.save(new User(0L,email,result));
        }
        return result;
    }
}