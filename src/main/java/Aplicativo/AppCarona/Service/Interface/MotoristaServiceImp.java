package Aplicativo.AppCarona.Service.Interface;
import Aplicativo.AppCarona.DTO.Response.MotoristaResponse;
import Aplicativo.AppCarona.DTO.Resquest.MotoristaRequest;

public interface MotoristaServiceImp {

    MotoristaResponse tornarMotorista(MotoristaRequest motoristaRequest);
}
