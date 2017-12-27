package mx.com.mwm.bo;
import java.util.List;

import mx.com.mwisp.model.Router;
import mx.com.mwm.dto.DTORouter;

public interface BORouterInterface {
	public DTORouter modelRouterToDtoRouter(Router modelRouter);
	public List<DTORouter> listModelRouterToListDtoRouter(List<Router> listModelRouter);
	public Router DtoRouterToModelRouter(DTORouter dtoRouter);
	public List<Router> listDtoRouterTolistModelRouter(List<DTORouter> listDtoRouter);
}
