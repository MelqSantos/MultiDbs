package br.com.digisystem.repositories.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digisystem.entities.primary.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
