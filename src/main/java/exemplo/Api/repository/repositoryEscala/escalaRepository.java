package exemplo.Api.repository.repositoryEscala;

import exemplo.Api.model.modelEscala.Escala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface escalaRepository extends JpaRepository<Escala, Long> {
    List<Escala> findByid(int id);
}

