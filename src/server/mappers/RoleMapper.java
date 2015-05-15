package server.mappers;


import server.entities.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 02/05/2015.
 */

public class RoleMapper extends DatabaseAccess {

    public void insert(Role role) {
        String statement = "INSERT INTO role (name) VALUES (?)";
        try {
            PreparedStatement dbStatement = connection.prepareStatement(statement);
            dbStatement.setString(1, role.getName());
            dbStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Role role) {
        String statement = "DELETE FROM role WHERE (id)= (?)";
        try {
            PreparedStatement dbStatement = connection.prepareStatement(statement);
            dbStatement.setLong(1, role.getId());
            dbStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Role> findByCategory(Role role) {
        String statement = "SELECT * FROM role ";
        Boolean first = true;
        List<Role> typeList = new ArrayList<Role>();
        int counter = 0;
        if (role.getId() != null || role.getName() != null) {
            statement = statement + " WHERE ";
            if (role.getId() != null) {
                statement = statement + " id = ?";
                first = false;
            }
            if (role.getName() != null) {
                if (first) {
                    statement = statement + " name = ?";
                    first = false;
                } else {
                    statement = statement + " AND name = ?";
                }
            }
        }
        statement = statement + " order by id;";
        try {
            PreparedStatement dbStatement = connection.prepareStatement(statement);
            if (role.getId() != null) {
                dbStatement.setLong(++counter, role.getId());
            }
            if (role.getName() != null) {
                dbStatement.setString(++counter, role.getName());
            }
            ResultSet rs = dbStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");
                Role retRole = new Role();
                retRole.setId(id);
                retRole.setName(name);
                typeList.add(retRole);
            }
            if (!typeList.isEmpty()) {
                return typeList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Role find(Role role) {
        List<Role> typeList = this.findByCategory(role);
        return typeList.get(0);
    }

    public void update(Role role) {
        String statement = "UPDATE role SET name=? WHERE id = ?";
        try {
            PreparedStatement dbStatement = connection.prepareStatement(statement);
            dbStatement.setString(1, role.getName());
            dbStatement.setLong(2, role.getId());
            dbStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
