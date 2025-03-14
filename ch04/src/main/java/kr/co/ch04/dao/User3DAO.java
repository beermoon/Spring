package kr.co.ch04.dao;

import kr.co.ch04.dto.User3DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User3DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser3(User3DTO dto) {

        String sql = "insert into user3 values(?,?,?,?)";

        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getHp(),
                dto.getAge()
        };

        jdbcTemplate.update(sql, params);

    }

    public User3DTo selectUser3(String uid) {
        String sql = "select * from user3 where uid=?";
        Object[] params = {uid};

        return jdbcTemplate.queryForObject(sql,new User3RowMapper(), params);
    }

    public List<User3DTO> selectAllUser3() {
        String sql = "select * from user3";
        return jdbcTemplate.query(sql, User3RowMapper());
    }

    public void updateUser3(User3DTO dto) {

        String sql = "update user3 set name=?,hp=?,age=? where uid=?";
        Object[] params = {
                dto.getName(),
                dto.getHp(),
                dto.getAge(),
                dto.getUid()
        };

        jdbcTemplate.update(sql, params);


    }

    public void deleteUser3(String uid) {

    }

}
