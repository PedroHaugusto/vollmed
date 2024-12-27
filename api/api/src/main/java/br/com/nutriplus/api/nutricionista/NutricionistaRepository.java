package br.com.nutriplus.api.nutricionista;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long> {

    Page<Nutricionista> findAllByAtivoTrue(Pageable paginacao);
}
