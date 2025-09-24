package exemplo.Api.repository.repositoryMedico;

import exemplo.Api.model.modelMedico.Medico;
import java.util.List;

public interface medicoRepository {

    List<Medico> findBy (String id);
}
