package kr.co.ch04.dao;

import com.mysql.cj.protocol.Resultset;
import kr.co.ch04.dto.User3DTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User3RowMapper implements RowMapper<User3DTO> {

    @Override
    public User3DTO mapRow(Resultset rs , int rowNum) throws SQLException {
        User3DTO dto = new User3DTO();
        dto.setUid(rs.getString(1));
        dto.setName(rs.getString(2));
        dto.setHp(rs.getString(3));
        dto.setAge(rs.getInt(4));
        return dto;
    }


    @Override
    public User3DTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
