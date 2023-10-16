package ejercicio02.app;

import java.util.Map;
import java.util.Scanner;

import ejercicio02.modelo.Cliente;
import ejercicio02.service.ClienteService;
import ejercicio02.service.ClienteServiceException;

public class app {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	ClienteService service = new ClienteService();
	Map<String,Cliente> mapCliente;
	
	try {
		mapCliente = service.consultarClientes();	
		System.out.println("Dame un correo:");
		String correo = scanner.nextLine();
		System.out.println("Los datos del cliente del correo "+ correo + "\n"+ mapCliente.get(correo));
	} catch (ClienteServiceException e) {
		e.getMessage();
	}
	scanner.close();
}
}
