package kr.co.ch04.dao;

import kr.co.ch04.dto.User2DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class User2DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser2(User2DTO dto) {

        String sql = "insert into user2 values(?,?,?,?)";

        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getHp(),
                dto.getAge()
        };

        jdbcTemplate.update(sql, params);


    }

    public User2DTO selectUser2(String uid) {
        String sql = "select * from user2 where uid=?";
        Object[] params = {uid};

        return jdbcTemplate.queryForObject(sql,new User2RowMapper(), params);
    }

    public List<User2DTO> selectAllUser2() {
        String sql = "select * from user2";
        return jdbcTemplate.query(sql, new User2RowMapper());
    }

    public void updateUser2(User2DTO dto) {

        String sql = "update user2 set name=?,hp=?,age=? where uid=?";
        Object[] params = {
                dto.getName(),
                dto.getHp(),
                dto.getAge(),
                dto.getUid()
        };
        jdbcTemplate.update(sql, params);

    }

    public void deleteUser2(String uid) {

    }


}
