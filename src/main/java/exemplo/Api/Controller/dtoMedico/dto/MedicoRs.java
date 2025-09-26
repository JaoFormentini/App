package exemplo.Api.Controller.dtoMedico.dto;

import exemplo.Api.model.modelMedico.Medico;

public class MedicoRs {
    private Long id;
    private String nome;
    private String crm;
    private String especialidade;

    public static MedicoRs converter(Medico med){
        var medico = new MedicoRs();
        medico.setId(med.getId());
        medico.setNome(med.getNome());
        medico.setCrm(med.getCrm());
        medico.setEspecialidade(med.getEspecialidade());

        return medico;
    }

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
