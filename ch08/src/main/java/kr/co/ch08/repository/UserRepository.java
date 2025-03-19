package kr.co.ch08.repository;

import kr.co.ch08.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User, String> {


}
