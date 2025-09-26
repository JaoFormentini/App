package exemplo.Api.Controller.CotrollerMedico;


import exemplo.Api.Controller.CotrollerMedico.dto.MedicoRs;
import exemplo.Api.repository.repositoryMedico.medicoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/app")
public class MedicoController {

    private final medicoRepository repositoryMedico;

    public MedicoController(medicoRepository repositoryMedico) {
        this.repositoryMedico = repositoryMedico;
    }


@GetMapping("/allmedico")
    public List<MedicoRs> findAll(){
        var medico = repositoryMedico.findAll();
    return medico.stream().map(MedicoRs::converter).collect(Collectors.toList());
}


}
