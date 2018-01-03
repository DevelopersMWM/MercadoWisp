package mx.com.mwm.bo;

import java.util.List;

import mx.com.mwisp.model.Torre;
import mx.com.mwm.dto.DTOTorres;

public interface BOTorresInterface {
	public DTOTorres modelTorresToDtoTorres(Torre torre);
	public List<DTOTorres> listModelTorreTolistDtoTorre(List<Torre> listModelTorre);
	public Torre dtoTorreToModelTorre(DTOTorres dtoTorre);
	public List<Torre> listDtoTorreToListModelTorre(List<DTOTorres> listDtoTorre);
}
