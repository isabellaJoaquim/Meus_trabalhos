package br.com.senai.repositores;

import br.com.senai.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepositore  extends JpaRepository<Brand,Long> {
}
