package br.com.silva.app.repository;

import br.com.silva.app.model.domain.Produtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor, Integer> {
}
