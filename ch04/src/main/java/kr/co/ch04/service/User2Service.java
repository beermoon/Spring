package kr.co.ch04.service;


import kr.co.ch04.dao.User2DAO;
import kr.co.ch04.dto.User2DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User2Service {

    @Autowired
    private User2DAO dao;

    public void save(User2DTO dto) {
        dao.insertUser2(dto);
    }

    public List<User2DTO> findAll() {
        return dao.selectAllUser2();
    }

    public User2DTO findById(String uid) {
        return dao.selectUser2(uid);
    }

    public void delete(String uid) {}
    public void update(User2DTO dto) {
        dao.updateUser2(dto);
    }


}
