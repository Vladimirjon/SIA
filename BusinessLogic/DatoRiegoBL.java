package BusinessLogic;
import java.util.List;
import DataAccess.DatoRiegoDAO;
import DataAccess.DTO.DatoRiegoDTO;


public class DatoRiegoBL {
    private DatoRiegoDTO Riego;
    private DatoRiegoDAO RiegoDAO = new DatoRiegoDAO();

    public DatoRiegoBL(){}

    public List<DatoRiegoDTO> getAll() throws Exception{
        return RiegoDAO.readAll();
    }
    public DatoRiegoDTO getByIdDato(int idDato) throws Exception{
        Riego = RiegoDAO.readBy(idDato);
        return Riego;
    }
    public boolean create(DatoRiegoDTO riegoDTO) throws Exception{   
        return RiegoDAO.create(riegoDTO);
    }
    public boolean update(DatoRiegoDTO riegoDTO) throws Exception{
        return RiegoDAO.update(riegoDTO);
    }
    public boolean delete(int idDato) throws Exception{
        return RiegoDAO.delete(idDato);
    }

}
