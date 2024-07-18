public class estudiante {
    String cedula;
    Double nota;

    public estudiante() {
    }

    public estudiante(String cedula, Double nota) {
        this.cedula = cedula;
        this.nota = nota;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
