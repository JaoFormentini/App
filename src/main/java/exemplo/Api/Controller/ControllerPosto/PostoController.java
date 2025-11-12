package exemplo.Api.Controller.ControllerPosto.;


import exemplo.Api.Controller.ControllerPosto.dto.PostoRs;
import exemplo.Api.repository.repositoryPosto.postoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/app")
public class PostoController {

    private final postoRepository repositoryPosto;

    public PostoController(postoRepository repositoryPosto) {
        this.repositoryPosto = repositoryPosto;
    }

    @GetMapping("/allposto")
    public List<PostoRs> findAll() {
        var posto = repositoryPosto.findAll();
        return posto.stream().map(PostoRs::converter).collect(Collectors.toList());
    }

    @GetMapping("/posto/cnpj/{cnpj}")
    public PostoRs findByCnpj(@PathVariable("cnpj") String cnpj) {
        var post = postoRepository.findByCnpj(cnpj);

        if (post.isPresent()) {
            var posto = post.get();
            return PostoRs.converter(posto);
        } else {
//            CORRIGIR ERRO DE NAO LANÇAR O ERRO QUANDO NAO ENCONTRA O MEDICO
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não há medico com esse id");
        }
    }

    @PostMapping("/medico/post")
    public ResponseEntity<String> SaveMedico(@RequestBody MedicoRq Medico) {
        var med = new Medico();

        med.setNome(Medico.getNome());
        med.setCrm(Medico.getCrm());
        med.setEspecialidade(Medico.getEspecialidade());

        repositoryMedico.save(med);
        return ResponseEntity.status(HttpStatus.CREATED).body("Medico inserido com sucesso!");
    }

    @PutMapping("/medico/crm/{crm}")
    public ResponseEntity<String> updateMed(@PathVariable("crm") String crm, @RequestBody MedicoRq Medico) throws Exception{
        var med = repositoryMedico.findBycrm(crm);

        if (med.isPresent()) {
            var medUpdate = med.get();

            medUpdate.setNome(Medico.getNome());
            medUpdate.setCrm(Medico.getCrm());
            medUpdate.setEspecialidade(Medico.getEspecialidade());

            repositoryMedico.save(medUpdate);

            return ResponseEntity.ok("Medico Atualizado");
        } else {
            return ResponseEntity.ok("Não possui nenhuma Medico com este id.");
        }
    }

    @Autowired
    private MedicoService medicoService;

    @DeleteMapping("/medico/crm/{crm}")
    public ResponseEntity<?> deleteBycrm(@PathVariable String crm) {

        var med = repositoryMedico.findBycrm(crm);

        if(med.isPresent()) {
            medicoService.deleteBycrm(crm);
            return ResponseEntity.ok("Medico removido");
        }
        else {
            return ResponseEntity.ok("Nao foi possivel deletar, Medico nao encontrada");
        }
    }
}