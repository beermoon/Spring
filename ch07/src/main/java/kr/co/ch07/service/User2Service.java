package kr.co.ch07.service;

import jakarta.transaction.Transactional;
import kr.co.ch07.dto.User1DTO;
import kr.co.ch07.dto.User2DTO;
import kr.co.ch07.entity.User1;
import kr.co.ch07.entity.User2;
import kr.co.ch07.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class User2Service {

    private final User2Repository repository;

    public void register(User2DTO user2DTO){
        log.info("user2DTO: {}", user2DTO);

        // DTO를 Entity로 변환
        User2 user2 = user2DTO.toEntity();
        log.info("user2: {}", user2);

        // Entity 저장(Insert 실행)
        repository.save(user2);
    }

    public List<User2DTO> findAll() {

        List<User2> user2Entities = repository.findAll();

        List<User2DTO> user2DTOs = user2Entities
                .stream()
                .map(entity -> entity.toDTO())
                .toList();


        return user2DTOs;

    }

    public User2DTO findById(String uid) {

        Optional<User2> optUser2 = repository.findById(uid);
        log.info("optUser2: {}", optUser2);

        if (optUser2.isPresent()) {
            User2  user2 = optUser2.get();
            return user2.toDTO();
        }
        return null;
    }

    public void modify(User2DTO user2DTO) {

        boolean exist = repository.existsById(user2DTO.getUid());

        if (exist) {
            User2 user2 = user2DTO.toEntity();

            repository.save(user2);
        }


    }


    @Transactional
    public void update(User2DTO user2DTO){
        User2 user2 = repository.findById(user2DTO.getUid()).get();
        user2.setName(user2DTO.getName());
        user2.setHp(user2DTO.getHp());
        user2.setAge(user2DTO.getAge());
    }



    public void delete(String uid) {

        repository.deleteById(uid);

    }



}
