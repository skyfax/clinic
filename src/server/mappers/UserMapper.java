package server.mappers;

import server.entities.Role;
import server.entities.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 02/05/2015.
 */
public class UserMapper extends DatabaseAccess {

    private RoleMapper roleMapper = new RoleMapper();

    public boolean insert(User user) {
        String statement = "INSERT INTO user (name, username, password, cnp, icn, address, birthDate, roleId) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement dbStatement = connection.prepareStatement(statement);
            dbStatement.setString(1, user.getName());
            dbStatement.setString(2, user.getUsername());
            dbStatement.setString(3, user.getPassword());
            dbStatement.setLong(4, user.getCnp());
            dbStatement.setLong(5, user.getIcn());
            dbStatement.setString(6, user.getAddress());
            dbStatement.setDate(7, user.getBirthDate());
            dbStatement.setLong(8, user.getRole().getId());
            dbStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void delete(User user) {
        String statement = "DELETE FROM user WHERE (id)= (?)";
        try {
            PreparedStatement dbStatement = connection.prepareStatement(statement);
            dbStatement.setLong(1, user.getId());
            dbStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findByCategory(User user) {
        String statement = "SELECT * FROM user ";
        Boolean first = true;
        List<User> typeList = new ArrayList<User>();
        int counter = 0;
        if (user.getId() != null || user.getName() != null || user.getUsername() != null
                || user.getRole() != null || user.getPassword() != null) {
            statement = statement + " WHERE ";
            if (user.getId() != null) {
                statement = statement + " id = ?";
                first = false;
            }
            if (user.getName() != null) {
                if (first) {
                    statement = statement + " name = ?";
                    first = false;
                } else {
                    statement = statement + " AND name = ?";
                }
            }
            if (user.getUsername() != null) {
                if (first) {
                    statement = statement + " username = ?";
                    first = false;
                } else {
                    statement = statement + " AND username = ?";
                }
            }
            if (user.getPassword() != null) {
                if (first) {
                    statement = statement + " password = ?";
                    first = false;
                } else {
                    statement = statement + " AND password = ?";
                }
            }
            if (user.getRole() != null) {
                if (first) {
                    statement = statement + " role = ?";
                    first = false;
                } else {
                    statement = statement + " AND role = ?";
                }
            }
        }
        statement = statement + ";";
        try {
            PreparedStatement dbStatement = connection.prepareStatement(statement);
            if (user.getId() != null) {
                dbStatement.setLong(++counter, user.getId());
            }
            if (user.getName() != null) {
                dbStatement.setString(++counter, user.getName());
            }
            if (user.getUsername() != null) {
                dbStatement.setString(++counter, user.getUsername());
            }
            if (user.getPassword() != null) {
                dbStatement.setString(++counter, user.getPassword());
            }
            if (user.getRole() != null) {
                dbStatement.setLong(++counter, user.getRole().getId());
            }
            ResultSet rs = dbStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int cnp = rs.getInt("cnp");
                int icn = rs.getInt("icn");
                String address = rs.getString("address");
                Date birthDate = rs.getDate("birthDate");
                int roleId = rs.getInt("roleId");
                User retClint = new User();
                retClint.setId(id);
                retClint.setName(name);
                retClint.setUsername(username);
                retClint.setPassword(password);
                retClint.setCnp(cnp);
                retClint.setAddress(address);
                retClint.setBirthDate(birthDate);
                Role role = new Role();
                role.setId(roleId);
                retClint.setRole(roleMapper.find(role));
                typeList.add(retClint);
            }
            if (!typeList.isEmpty()) {
                return typeList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeList;
    }

    public User find(User user) {

        List <User> userList =findByCategory(user);
        if(userList.isEmpty()){
            user.setId(0);
            return user;
        }
        return userList.get(0);
    }

    public boolean update(User user) {
        String statement = "UPDATE user SET name=?, password=?, cnp=?, icn=?, address=?, birthDate=?, roleId=? WHERE id = ?";
        try {
            PreparedStatement dbStatement = connection.prepareStatement(statement);
            dbStatement.setString(1, user.getName());
            dbStatement.setString(2, user.getPassword());
            dbStatement.setInt(3, user.getCnp());
            dbStatement.setInt(4, user.getIcn());
            dbStatement.setString(5, user.getAddress());
            dbStatement.setDate(6, user.getBirthDate());
            dbStatement.setLong(7, user.getRole().getId());
            dbStatement.setLong(8, user.getId());
            dbStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
