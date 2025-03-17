package kr.co.ch07.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch07.dto.User2DTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user2")
public class User2 {


    @Id
    private String uid;

    @Column(name = "name")
    private String name;

    @Column(name="hp")
    private String hp;

    private int age;

    // DTO 변환 메서드 정의
    public User2DTO toDTO() {
        return User2DTO.builder()
                .uid(uid)
                .name(name)
                .hp(hp)
                .age(age)
                .build();
    }

}
