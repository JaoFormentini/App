package exemplo.Api.Controller.ControllerEscala;

import exemplo.Api.Controller.ControllerEscala.dto.EscalaRq;
import exemplo.Api.Controller.ControllerEscala.dto.EscalaRs;
import exemplo.Api.model.modelEscala.Escala;
import exemplo.Api.repository.repositoryEscala.escalaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        //            CORRIGIR ERRO DE NAO LANÇAR O ERRO QUANDO NAO ENCONTRA A ESCALA
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Escala não encontrada");
    }
}

@PostMapping("/escala/post")
    public ResponseEntity<String> SaveEscala(@RequestBody EscalaRq escala){
        var esc = new Escala();

        esc.setCrm(escala.getCrm());
        esc.setNome(escala.getNome());
        esc.setEspecialidade(escala.getEspecialidade());
        esc.setDia(escala.getDia());
        esc.setHorainic(escala.getHorainic());
        esc.setHorafim(escala.getHorafim());
        esc.setId_user_posto(esc.getId_user_posto());

        repositoryEscala.save(esc);
        return ResponseEntity.status(HttpStatus.CREATED).body("Escala Inserida com Sucesso!");
    }

@PutMapping("/escala/{id}")
    public ResponseEntity<String> updateEsc(@PathVariable("id") Long id, @RequestBody EscalaRq Escala) throws Exception{
    var esc = repositoryEscala.findById(id);

    if (esc.isPresent()) {
        var escalaUpdate = esc.get();

        escalaUpdate.setCrm(Escala.getCrm());
        escalaUpdate.setNome(Escala.getNome());
        escalaUpdate.setEspecialidade(Escala.getEspecialidade());
        escalaUpdate.setDia(Escala.getDia());
        escalaUpdate.setHorainic(Escala.getHorainic());
        escalaUpdate.setHorafim(Escala.getHorafim());
        escalaUpdate.setId_user_posto(Escala.getId_user_posto());

        repositoryEscala.save(escalaUpdate);
        return ResponseEntity.ok("Escala Atualizada");
    } else {
        return ResponseEntity.ok("Não possui nenhuma escala com este id.");
    }
}

@DeleteMapping("/escala/{id}")
    public ResponseEntity<String> deleteEsc(@PathVariable Long id) {

        var esc = repositoryEscala.findById(id);

        if(esc.isPresent()) {
            repositoryEscala.deleteById(id);
            return ResponseEntity.ok("Escala deletada com sucesso!");
        }
        else {
            return ResponseEntity.ok("Nao foi possivel deletar, Escala nao encontrada");
        }
    }
}
