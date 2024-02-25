package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.DatoRiegoDTO;

public class DatoRiegoDAO extends SQLiteDataHelper implements IDAO<DatoRiegoDTO> {

    @Override
    public DatoRiegoDTO readBy(Integer id) throws Exception {
        DatoRiegoDTO dT = new DatoRiegoDTO();
        String query = " SELECT IdDato  "
                + " ,Humedad        "
                + " ,IdTipoRiego        "
                + " ,FechaCrea     "
                + " ,FechaModificacion "
                + " FROM    DatoRiego   "
                + " WHERE   IdDato =   " + id.toString();
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                dT = new DatoRiegoDTO(rs.getInt(1) // IdDato
                        , rs.getInt(2) // HumedadSuelo
                        , rs.getInt(3) // TipoRiego
                        , rs.getString(4) // FechaCrea
                        , rs.getString(5)); // FechaModifica
            }
        } catch (SQLException e) {
            throw e;
        }
        return dT;
    }

    @Override
    public List<DatoRiegoDTO> readAll() throws Exception {
        List<DatoRiegoDTO> lst = new ArrayList<>();
        String query = " SELECT IdDato  "
                + " ,Humedad        "
                + " ,IdTipoRiego        "
                + " ,FechaCrea     "
                + " ,FechaModificacion "
                + " FROM    DatoRiego   ";

        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                DatoRiegoDTO s = new DatoRiegoDTO(rs.getInt(1) // IdSexo
                        , rs.getInt(2) // Nombre
                        , rs.getInt(3) // Estado
                        , rs.getString(4) // FechaCrea
                        , rs.getString(5));// FechaModifica
                lst.add(s);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public boolean create(DatoRiegoDTO entity) throws Exception {
        String query = " INSERT INTO DatoRiego (Humedad, IdTipoRiego) VALUES (?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getHumedadSuelo());
            pstmt.setInt(2, entity.getIdTipoRiego());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(DatoRiegoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE DatoRiego SET Humedad = ?, FechaModificacion = ? WHERE IdDato = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getHumedadSuelo());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdDato());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " Delete DatoRiego WHERE IdDato = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

}
