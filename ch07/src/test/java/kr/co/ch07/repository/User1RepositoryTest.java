package kr.co.ch07.repository;

import kr.co.ch07.entity.Child;
import kr.co.ch07.entity.Parent;
import kr.co.ch07.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;


    @Test
    void findUser1ByUid() {

        // given
        String uid = "a1001";

        // when
        User1 user1 = user1Repository.findUser1ByUid(uid);

        // then
        System.out.println(user1);
    }

    @Test
    void findUser1ByName() {
        List<User1> user1List = user1Repository.findUser1ByName("홍길동");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameNot() {
        List<User1> user1List = user1Repository.findUser1ByNameNot("홍길동");
        System.out.println(user1List);
    }


    @Test
    void findUser1ByUidAndName() {
        User1 user = user1Repository.findUser1ByUidAndName("a101", "홍길동");
        System.out.println(user);
    }

    @Test
    void findUser1ByUidOrName() {
        List<User1> user1List = user1Repository.findUser1ByUidOrName("a101","홍길동");
        System.out.println(user1List);

    }

    @Test
    void findUser1ByAgeGreaterThan() {
        List<User1> user1List = user1Repository.findUser1ByAgeGreaterThan(23);
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
        List<User1> user1List = user1Repository.findUser1ByAgeGreaterThanEqual(23);
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeLessThan() {
        List<User1> user1List = user1Repository.findUser1ByAgeLessThan(45);
        System.out.println(user1List);

    }

    @Test
    void findUser1ByAgeLessThanEqual() {
        List<User1> user1List = user1Repository.findUser1ByAgeLessThanEqual(45);
        System.out.println(user1List);

    }

    @Test
    void findUser1ByAgeBetween() {
        List<User1> user1List = user1Repository.findUser1ByAgeBetween(10,40);
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameLike() {
        List<User1> user1List = user1Repository.findUser1ByNameLike("김주찬");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameContains() {
        List<User1> user1List = user1Repository.findUser1ByNameContains("김주찬");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameStartsWith() {
        List<User1> user1List = user1Repository.findUser1ByNameStartsWith("김");
        System.out.println(user1List);

    }

    @Test
    void findUser1ByNameEndsWith() {
        List<User1> user1List = user1Repository.findUser1ByNameEndsWith("동");
        System.out.println(user1List);

    }

    @Test
    void findUser1ByOrderByName() {
        List<User1> user1List = user1Repository.findUser1ByOrderByName();
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameOrderByUid() {
        List<User1> user1List = user1Repository.findUser1ByNameOrderByUid("홍길동");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByOrderByAgeAsc() {
        List<User1> user1List = user1Repository.findUser1ByOrderByAgeAsc();
        System.out.println(user1List);
    }

    @Test
    void findUser1ByOrderByAgeDesc() {
        List<User1> user1List = user1Repository.findUser1ByOrderByAgeDesc();
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeGreaterThanOrderByAgeDesc() {
        List<User1> user1List = user1Repository.findUser1ByAgeGreaterThanOrderByAgeDesc(40);
        System.out.println(user1List);
    }

    @Test
    void countUser1ByName() {
       int count = user1Repository.countUser1ByName("홍길동");
        System.out.println(count);
    }

    @Test
    void selectUser1UnderAge30() {
        List<User1> users = user1Repository.selectUser1UnderAge30();

        // 출력
        users.forEach(user -> {
            System.out.println(user);
        });

        // 검증 예시
        assertFalse(users.isEmpty(), "30세 이하 유저가 없습니다!");
    }

    @Test
    void selectUser1ByName() {
    }

    @Test
    void selectUser1ByNameParam() {
    }

    @Test
    void selectUser1ByUid() {
    }

    @Test
    void selectAllParentWithChild() {

        // given
        String pid = "p101";

        // when
        List<Object[]> list = user1Repository.selectAllParentWithChild(pid);

        // then
        for(Object[] arr : list){

            Parent parent = (Parent) arr[0];
            Child child = (Child) arr[1];

            System.out.println(parent);
            System.out.println(child);
        }
    }
}