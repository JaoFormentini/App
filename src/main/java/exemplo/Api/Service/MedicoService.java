package exemplo.Api.Service;

import exemplo.Api.repository.repositoryMedico.medicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private medicoRepository medicoRepository;

    @Transactional
    public void deleteBycrm(String crm) {
        medicoRepository.deleteBycrm(crm);
    }
}
