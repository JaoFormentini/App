package exemplo.Api.repository.repositoryPosto;

import exemplo.Api.model.modelPosto.Posto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface postoRepository extends JpaRepository<Posto, Long> {
    Optional<Posto> findByCnpj(String cnpj);
    void deleteByCnpj (String cnpj);
}
