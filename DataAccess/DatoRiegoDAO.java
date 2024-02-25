package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DataAccess.DTO.DatoRiegoDTO;

public class DatoRiegoDAO extends SQLiteDataHelper implements IDAO<DatoRiegoDTO>{

    @Override
    public DatoRiegoDTO readBy(Integer id) throws Exception {
        DatoRiegoDTO dT = new DatoRiegoDTO();
        String query =" SELECT IdDato  " 
                     +" ,Humedad        " 
                     +" ,IdTipoRiego        " 
                     +" ,FechaCrea     " 
                     +" ,FechaModificacion "
                     +" FROM    DatoRiego   "
                     +" WHERE   IdDato =   "+ id.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                dT = DatoRiegoDTO new (rs.getInt(1)           // IdDato
                                ,rs.getInt(2)        // HumedadSuelo             
                                ,rs.getInt(3)        // TipoRiego        
                                ,rs.getString(4)        // FechaCrea      
                                ,rs.getString(5));      // FechaModifica
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return dT;
    }

    @Override
    public List<DatoRiegoDTO> readAll() throws Exception {
       
    }

    @Override
    public boolean create(DatoRiegoDTO entity) throws Exception {
        
    }

    @Override
    public boolean update(DatoRiegoDTO entity) throws Exception {
        
    }

    @Override
    public boolean delete(Integer id) throws Exception {
       
    }
    
}
