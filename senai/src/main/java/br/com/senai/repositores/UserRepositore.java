package br.com.senai.repositores;

import br.com.senai.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepositore extends JpaRepository<User,Long> {
}
