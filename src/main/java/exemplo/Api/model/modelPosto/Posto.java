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
}
