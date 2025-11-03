package org.example.simplecrud.Repositories;



import org.example.simplecrud.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Integer> {

}
