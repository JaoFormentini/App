package exemplo.Api.repository.repositoryPosto;

import exemplo.Api.model.modelPosto.Posto;

import java.util.List;

public interface postoRepository {

    List<Posto> findByCnpj(String cnpj);
}
