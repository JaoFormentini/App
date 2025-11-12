package exemplo.Api.Controller.ControllerEscala.dto;

public class EscalaRq {
    private Long id;
    private Long id_medico;
    private String nome;
    private String especialidade;
    private String dia;
    private String horainic;
    private String horafim;
    private Long id_uuser_posto;

    public Long getId(){
        return  id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId_medico(){
        return  id_medico;
    }

    public void setId_medico(Long id_medico){
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
        return id_uuser_posto;
    }

    public void setId_user_posto(Long id_uuser_posto) {
        this.id_uuser_posto = id_uuser_posto;
    }

}