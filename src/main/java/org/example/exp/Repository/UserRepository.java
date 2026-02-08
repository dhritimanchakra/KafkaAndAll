package org.example.exp.Repository;

import org.example.exp.entities.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserInfo,Long> {
    public UserInfo findByUsername(String username);
}
