package exemplo.Api.Controller.ControllerPosto.dto;

import exemplo.Api.model.modelPosto.Posto;

public class PostoRs {
    private String cnpj;
    private String nome;
    private String endereco;
    private String horario_atendimento;

    public static PostoRs converter (Posto post){
        var posto = new PostoRs();
        posto.setCnpj(post.getCnpj());
        posto.setNome(post.getNome());
        posto.setEndereco(post.getEndereco());
        posto.setHorario_atendimento(post.getHorario_atendimento());

        return posto;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getHorario_atendimento() {
        return horario_atendimento;
    }

    public void setHorario_atendimento(String horario_atendimento) {
        this.horario_atendimento = horario_atendimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

