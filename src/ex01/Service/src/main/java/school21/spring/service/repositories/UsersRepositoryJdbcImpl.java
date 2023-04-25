package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private Connection connection;

    public UsersRepositoryJdbcImpl(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }


    @Override
    public Optional findById(Long id) {
        User res = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * from users where id = ?";
            pstmt = connection.prepareStatement(SQL);
            pstmt.setLong(1, id);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                res = new User(resultSet.getLong("id"), resultSet.getString("email"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return Optional.ofNullable(res);
    }

    @Override
    public List findAll() {
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<User> res = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM users ORDER BY id ASC";
            pstmt = connection.prepareStatement(SQL);
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
                res.add(new User(resultSet.getLong("id"), resultSet.getString("email")));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return res;
    }

    @Override
    public void save(User user) {
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            String SQL = "INSERT INTO users (id, email) VALUES (?, ?)";
            pstmt = connection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, user.getIdentifier());
            pstmt.setString(2, user.getEmail());
            pstmt.executeUpdate();
            connection.commit();
            resultSet = pstmt.getGeneratedKeys();
            if (resultSet.next())
                user.setIdentifier(resultSet.getLong("id"));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }


    @Override
    public void update(User user) {
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            String SQL = "UPDATE users SET email = ? WHERE id = ?";
            pstmt = connection.prepareStatement(SQL);
            pstmt.setLong(1, user.getIdentifier());
            pstmt.setString(2, user.getEmail());
            pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            String SQL = "DELETE FROM products WHERE  id = ?";
            pstmt = connection.prepareStatement(SQL);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public Optional findByEmail(String email) {
        User res = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            String SQL = "SELECT * from users where email = ?";
            pstmt = connection.prepareStatement(SQL);
            pstmt.setString(1, email);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                res = new User(resultSet.getLong("id"), resultSet.getString("email"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return Optional.ofNullable(res);
    }
}
