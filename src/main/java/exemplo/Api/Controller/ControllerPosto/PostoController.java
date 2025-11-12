package exemplo.Api.Controller.ControllerPosto;


import exemplo.Api.Controller.ControllerPosto.dto.PostoRq;
import exemplo.Api.Controller.ControllerPosto.dto.PostoRs;
import exemplo.Api.Service.PostoService;
import exemplo.Api.model.modelPosto.Posto;
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
        var post = repositoryPosto.findByCnpj(cnpj);

        if (post.isPresent()) {
            var posto = post.get();
            return PostoRs.converter(posto);
        } else {
//            CORRIGIR ERRO DE NAO LANÇAR O ERRO QUANDO NAO ENCONTRA O posto
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não há Posto com esse CNPJ");
        }
    }

    @PostMapping("/posto/post")
    public ResponseEntity<String> SavePosto(@RequestBody PostoRq Posto) {
        var post = new Posto();

        post.setCnpj(Posto.getCnpj());
        post.setNome(Posto.getNome());
        post.setEndereco(Posto.getEndereco());
        post.setHorario_atendimento(Posto.getHorario_atendimento());

        repositoryPosto.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).body("Posto inserido com sucesso!");
    }

    @PutMapping("/posto/cnpj/{cnpj}")
    public ResponseEntity<String> updatePost(@PathVariable("cnpj") String cnpj, @RequestBody PostoRq Posto) throws Exception{
        var post = repositoryPosto.findByCnpj(cnpj);

        if (post.isPresent()) {
            var postoUpdate = post.get();

            postoUpdate.setNome(Posto.getNome());
            postoUpdate.setEndereco(Posto.getEndereco());
            postoUpdate.setHorario_atendimento(Posto.getHorario_atendimento());

            repositoryPosto.save(postoUpdate);

            return ResponseEntity.ok("Posto Atualizado");
        } else {
            return ResponseEntity.ok("Não possui nenhuma Posto com este Cnpj.");
        }
    }

    @Autowired
    private PostoService postoService;

    @DeleteMapping("/posto/{cnpj}")
    public ResponseEntity<String> deletePosto(@PathVariable String cnpj) {
        var post = repositoryPosto.findByCnpj(cnpj);

        if(post.isPresent()) {
            repositoryPosto.deleteByCnpj(cnpj);
            return ResponseEntity.ok("Unidade deletada com sucesso!");
        }
        else {
            return ResponseEntity.ok("Nao foi possivel deletar, CNPJ da unidade nao encontrado");
        }
    }
}