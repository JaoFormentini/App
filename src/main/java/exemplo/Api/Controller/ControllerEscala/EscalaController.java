package exemplo.Api.Controller.ControllerEscala;

import exemplo.Api.Controller.ControllerEscala.dto.EscalaRq;
import exemplo.Api.Controller.ControllerEscala.dto.EscalaRs;
import exemplo.Api.model.modelEscala.Escala;
import exemplo.Api.repository.repositoryEscala.escalaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/app")
public class EscalaController {

    private final escalaRepository repositoryEscala;

    public EscalaController(escalaRepository repositoryEscala){
        this.repositoryEscala = repositoryEscala;
    }


@GetMapping("/allescalas")
    public List<EscalaRs> findAll(){
        var escala = repositoryEscala.findAll();
        return escala.stream().map(EscalaRs::converter).collect(Collectors.toList());
    }

@GetMapping("/escala/{id}")
public EscalaRs findById(@PathVariable("id") Long id){
        var esc = repositoryEscala.findById(id);

    if (esc.isPresent()) {
        var escala = esc.get();
        return EscalaRs.converter(escala);
    } else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Escala não encontrada");
    }

}

@PostMapping
    public ResponseEntity<String> SaveEscala(@RequestBody EscalaRq escala){
        var esc = new Escala();

        esc.setId_medico(escala.getId_medico());
        esc.setNome(escala.getNome());
        esc.setEspecialidade(escala.getEspecialidade());
        esc.setDia(escala.getDia());
        esc.setHorainic(escala.getHorainic());
        esc.setHorafim(escala.getHorafim());

        repositoryEscala.save(esc);
        return ResponseEntity.status(HttpStatus.CREATED).body("Escala Inserida com Sucesso!");
    }
}
