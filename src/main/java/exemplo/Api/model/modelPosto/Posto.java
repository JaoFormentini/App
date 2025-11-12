package exemplo.Api.model.modelPosto;

import jakarta.persistence.*;


@Entity
@Table(name = "posto")
public class Posto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "nome")
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "horario_atendimento")
    private String horario_atendimento;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHorario_atendimento() {
        return horario_atendimento;
    }

    public void setHorario_atendimento(String horario_atendimento) {
        this.horario_atendimento = horario_atendimento;
    }


}
