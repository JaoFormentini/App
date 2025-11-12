package exemplo.Api.repository.repositoryMedico;

import exemplo.Api.model.modelMedico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface medicoRepository extends JpaRepository<Medico, Long> {
    Optional<Medico> findBycrm (String crm);
    void deleteBycrm (String crm);

}
