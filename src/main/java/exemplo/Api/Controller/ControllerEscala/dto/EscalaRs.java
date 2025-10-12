package exemplo.Api.Controller.ControllerEscala.dto;

import exemplo.Api.model.modelEscala.Escala;

public class EscalaRs {
        private Long id;
        private Long id_medico;
        private String nome;
        private String especialidade;
        private String dia;
        private String horainic;
        private String horafim;
        private Long id_user_posto;

    public static EscalaRs converter(Escala e){
        var  escala =  new EscalaRs();
        escala.setId(e.getId());
        escala.setId_medico(e.getId_medico());
        escala.setNome(e.getNome());
        escala.setEspecialidade(e.getEspecialidade());
        escala.setDia(e.getDia());
        escala.setHorainic(e.getHorainic());
        escala.setHorafim(e.getHorafim());
        escala.setId_user_posto(e.getId_user_posto());

        return escala;
    }

    public Long getId(){
    return id;
}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_medico() {
        return id_medico;
    }

    public void setId_medico(Long id_medico) {
        this.id_medico = id_medico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorainic() {
        return horainic;
    }

    public void setHorainic(String horainic) {
        this.horainic = horainic;
    }

    public String getHorafim() {
        return horafim;
    }

    public void setHorafim(String horafim) {
        this.horafim = horafim;
    }

    public Long getId_user_posto() {
        return id_user_posto;
    }

    public void setId_user_posto(Long id_user_posto) {
        this.id_user_posto = id_user_posto;
    }
    }


