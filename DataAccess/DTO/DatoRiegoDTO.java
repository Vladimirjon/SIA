package DataAccess.DTO;

public class DatoRiegoDTO {
    
    
    private Integer IdDato;
    private Integer  HumedadSuelo;
    private Integer IdTipoRiego;
    private String  FechaCrea;    
    private String  FechaModifica;

    public DatoRiegoDTO() {
    }

    public DatoRiegoDTO(int idDato, int humedadSuelo, int idTipoRiego, String fechaCrea,
        String fechaModifica) {
        IdDato = idDato;
        HumedadSuelo = humedadSuelo;
        IdTipoRiego = idTipoRiego;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public String getFechaCrea() {
        return FechaCrea;
    }
    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }
    public String getFechaModifica() {
        return FechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }
    public Integer getIdDato() {
        return IdDato;
    }
    public void setIdDato(int idDato) {
        IdDato = idDato;
    }
    public Integer getHumedadSuelo() {
        return HumedadSuelo;
    }
    public void setHumedadSuelo(int humedadSuelo) {
        HumedadSuelo = humedadSuelo;
    }
    public Integer getIdTipoRiego() {
        return IdTipoRiego;
    }
    public void setIdTipoRiego(int idTipoRiego) {
        IdTipoRiego = idTipoRiego;
    }

    public String toString(){
        return getClass().getName()
        + "\n IdRiego:       "+ getIdDato()       
        + "\n Fecha Riego:       "+ getFechaCrea()       
        + "\n Humedad:       "+ getHumedadSuelo()       
        + "\n FechaCrea:    "+ getFechaCrea()    
        + "\n FechaModifica:"+ getFechaModifica();
    }

}
