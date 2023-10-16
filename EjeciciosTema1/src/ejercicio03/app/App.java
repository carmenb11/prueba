package ejercicio03.app;

import java.util.List;
import java.util.Map;

import ejercicio03.modelo.Pago;
import ejercicio03.service.PagoService;
import ejercicio03.service.PagosException;

public class App {
	public static void main(String[] args) {
		PagoService service = new PagoService();
		try {
			Map<String, List<Pago>> clientesPagos = service.consultarPagos();
			List<Pago> pagos = clientesPagos.get("MARILYN.ROSS@sakilacustomer.org");
			for (Pago pago : pagos) {
				System.out.println(pago);
			}
		
		} catch (PagosException e) {
			e.printStackTrace();
		}
	}


}
