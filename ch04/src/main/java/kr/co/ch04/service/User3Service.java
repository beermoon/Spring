package kr.co.ch04.service;


import kr.co.ch04.dao.User3DAO;
import kr.co.ch04.dto.User3DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User3Service {

    @Autowired
    private User3DAO dao;

    public void save(User3DTO dto) {
        dao.insertUser3(dto);
    }

    public List<User3DTO> findAll() {
        return dao.selectAllUser3();
    }

    public User3DTO findById(String uid) {
        return dao.selectUser3(uid);
    }

    public void delete(User3DTO dto) {}
    public void update(User3DTO dto) {
        dao.updateUser3(dto);
    }




}
