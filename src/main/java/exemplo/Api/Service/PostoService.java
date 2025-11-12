package exemplo.Api.Service;

import exemplo.Api.repository.repositoryPosto.postoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostoService {

    @Autowired
    private postoRepository postoRepository;

    @Transactional
    public void deleteByCnpj(String cnpj) {
        postoRepository.deleteByCnpj(cnpj);
    }
}
