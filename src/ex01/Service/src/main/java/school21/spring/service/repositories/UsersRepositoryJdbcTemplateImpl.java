package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    static class UserRowMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setIdentifier(rs.getLong("id"));
            user.setEmail(rs.getString("email"));
            return user;
        }
    }

    @Override
    public Optional findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * from users where id = ?",new Object[]{id}, new UserRowMapper()));
    }

    @Override
    public List findAll() {
        List<User> users = jdbcTemplate.query(
                "SELECT * FROM users",
                new UserRowMapper());
        return users;
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO users (id, email) VALUES (?, ?)",user.getIdentifier(),user.getEmail());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE users SET email = ? WHERE id = ?",user.getIdentifier(),user.getEmail());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM products WHERE  id = ?",id);
    }

    @Override
    public Optional findByEmail(String email) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * from users where email = ?",new Object[]{email}, new UserRowMapper()));
    }
}
