package kr.co.ch07.dto;


import kr.co.ch07.entity.User2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User2DTO {

    private String uid;
    private String name;
    private String hp;
    private int age;


    public User2 toEntity() {
        return User2.builder()
                .uid(uid)
                .name(name)
                .hp(hp)
                .age(age).build();
    }
}
