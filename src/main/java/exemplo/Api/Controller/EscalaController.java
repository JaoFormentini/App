package exemplo.Api.Controller;

import exemplo.Api.Controller.dto.EscalaRq;
import exemplo.Api.Controller.dto.EscalaRs;
import exemplo.Api.model.modelEscala.Escala;
import exemplo.Api.repository.repositoryEscala.escalaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

@PostMapping
    public ResponseEntity<String> SaveEscala(@RequestBody EscalaRq escala){
        var esc = new Escala();
        esc.setNome(escala.getNome());
        esc.setEspecialidade(escala.getEspecialidade());
        esc.setDia(escala.getDia());
        esc.setHorainic(escala.getHorainic());
        esc.setHorafim(escala.getHorafim());

        repositoryEscala.save(esc);

        return ResponseEntity.status(HttpStatus.CREATED).body("Escala Inserida com Sucesso!");
    }
}
