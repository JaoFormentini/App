package exemplo.Api.model.modelMedico;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

@Entity

@Table(name = "medico")
public class Medico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_escala")
    private Long id_escala;

    @Column(name = "nome")
    private String nome;

    @Column(name = "crm")
    private String crm;

    @Column(name = "especialidade")
    private String especialidade;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId_escala() {
        return id_escala;
    }

    public void setId_escala(Long id_escala) {
        this.id_escala = id_escala;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
