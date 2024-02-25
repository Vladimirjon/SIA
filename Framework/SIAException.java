package Framework;

public class SIAException extends Exception {
    public SIAException(String e, String clase, String metodo) {
        //grabar el log
        System.out.println("[ERROR EN SIA program] " + clase +"."+ metodo +" : "+ e );
    }

    @Override 
    public String getMessage(){
        return "Verifique la conexion";
    }    
}
