package exemplo.Api.Controller.dto;

public class EscalaRq {
    private int id;
    private int id_medico;
    private String nome;
    private String especialidade;
    private String dia;
    private String horainic;
    private String horafim;

    public int getId(){
        return  id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId_medico(){
        return  id_medico;
    }

    public void setId_medico(int id_medico){
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
}
