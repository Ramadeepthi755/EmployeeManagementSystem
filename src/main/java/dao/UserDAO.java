package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import model.User;
import util.DBConnection;
import org.mindrot.jbcrypt.BCrypt;
public class UserDAO {

    public boolean addUser(User user) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO users(fullname,email,phone,username,password,role,image) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, user.getFullname());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());
            ps.setString(6, "USER");
            ps.setString(7, user.getImage());

            int row =
                    ps.executeUpdate();

            if(row > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    public List<User> getAllUsers() {

        List<User> list = new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM users";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                User user = new User();

                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setUsername(rs.getString("username"));

                list.add(user);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public User getUserById(int id) {

        User user = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "SELECT * FROM users WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                user = new User();

                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setImage(
                        rs.getString("image"));
                user.setPhone(rs.getString("phone"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    
    public boolean deleteUser(int id) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "DELETE FROM users WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int row =
                    ps.executeUpdate();

            if(row > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    public boolean updateUser(User user) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
            "UPDATE users SET fullname=?,email=?,phone=?,username=?,password=? WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, user.getFullname());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getId());

            int row =
                    ps.executeUpdate();

            if(row > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    public int getUserCount() {

        int count = 0;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT COUNT(*) FROM users";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                count =
                        rs.getInt(1);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return count;
    }
    public User validateUser(
            String username,
            String password) {

        User user = null;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM users WHERE username=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                String dbPassword =
                        rs.getString("password");

                if(BCrypt.checkpw(
                        password,
                        dbPassword)) {

                    user = new User();

                    user.setId(
                            rs.getInt("id"));

                    user.setFullname(
                            rs.getString("fullname"));

                    user.setUsername(
                            rs.getString("username"));

                    user.setEmail(
                            rs.getString("email"));
                    user.setImage(
                            rs.getString("image"));
                    user.setRole(
                            rs.getString("role"));
                }
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return user;
    }
    public int getTotalUsers() {

        int count = 0;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT COUNT(*) FROM users";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                count = rs.getInt(1);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return count;
    }
    public List<User> searchUsers(String keyword) {

        List<User> users = new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
            "SELECT * FROM users WHERE fullname LIKE ? OR username LIKE ? OR email LIKE ?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                User u = new User();

                u.setId(rs.getInt("id"));
                u.setFullname(rs.getString("fullname"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                u.setUsername(rs.getString("username"));

                users.add(u);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return users;
    }
    public List<User> getUsersByPage(int start, int total) {

        List<User> list = new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM users LIMIT ?,?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, start);
            ps.setInt(2, total);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                User user = new User();

                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setUsername(rs.getString("username"));

                list.add(user);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}