package exemplo.Api.Controller.CotrollerMedico;


import exemplo.Api.Controller.ControllerEscala.dto.EscalaRq;
import exemplo.Api.Controller.ControllerEscala.dto.EscalaRs;
import exemplo.Api.Controller.CotrollerMedico.dto.MedicoRq;
import exemplo.Api.Controller.CotrollerMedico.dto.MedicoRs;
import exemplo.Api.Service.MedicoService;
import exemplo.Api.model.modelEscala.Escala;
import exemplo.Api.model.modelMedico.Medico;
import exemplo.Api.repository.repositoryMedico.medicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public List<MedicoRs> findAll() {
        var medico = repositoryMedico.findAll();
        return medico.stream().map(MedicoRs::converter).collect(Collectors.toList());
    }

    @GetMapping("/medico/crm/{crm}")
    public MedicoRs findBycrm(@PathVariable("crm") String crm) {
        var med = repositoryMedico.findBycrm(crm);

        if (med.isPresent()) {
            var medico = med.get();
            return MedicoRs.converter(medico);
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
            medUpdate.setNome(Medico.getCrm());
            medUpdate.setEspecialidade(Medico.getEspecialidade());

            repositoryMedico.save(medUpdate);

            return ResponseEntity.ok("Escala Atualizada");
        } else {
            return ResponseEntity.ok("Não possui nenhuma escala com este id.");
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