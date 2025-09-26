package exemplo.Api.repository.repositoryMedico;

import exemplo.Api.model.modelMedico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface medicoRepository extends JpaRepository<Medico, Long> {
    List<Medico> findBycrm (String crm);
}
