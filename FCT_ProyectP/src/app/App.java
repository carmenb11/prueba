package app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Fecha;
import modelo.Registro;
import modelo.Usuario;
import service.AutentificarException;
import service.EvaluacionException;
import service.FechaService;
import service.FechaServiceException;
import service.RegistroService;
import service.RegistroServiceException;
import service.UsuarioService;
import service.UsuarioServiceException;

public class App {
	public static void main(String[] args) {
		Usuario user = new Usuario();

		UsuarioService sUser = new UsuarioService();

		user.setNombre("Carmen");
		user.setApellidos("Bejar");
		user.setIdUsuario(1L);
		user.setEmail("carmenb@");
		user.setCiclo("2");
		user.setContraseña("Carmenchu74");
		user.setActivo(true);

		/*
		 * try { sUser.altausuario(user); } catch (UsuarioServiceException e) {
		 * 
		 * e.printStackTrace(); }
		 * 
		 * try { sUser.loginUsuario("carmenb@", "Carmenchu74"); } catch
		 * (AutentificarException e) {
		 * 
		 * e.printStackTrace(); } catch (UsuarioServiceException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		Fecha date = new Fecha();
		date.setAño(2023);
		date.setDisponibilidad(true);
		date.setEvaluación(3);
		date.setFecha(LocalDate.now());
		FechaService sFecha = new FechaService();

		
		 /* try { System.out.println(sFecha.fechaCompleta());
		  
		  } catch (EvaluacionException e) {
		 
		  e.printStackTrace(); } catch (FechaServiceException e) {
		  
		  e.printStackTrace(); }*/
		
		
		/*List<Fecha> listFechas = new ArrayList<>();

		try {
			listFechas = sFecha.fechaCompleta();
		} catch (EvaluacionException e) {
			
			e.printStackTrace();
		} catch (FechaServiceException e) {
			
			e.printStackTrace();
		}
		for (Fecha fecha2 : listFechas) {
			System.out.println(fecha2);
		}*/
		 
		Registro registro = new Registro();
		registro.setIdUsuario(1L);
		registro.setFecha(LocalDate.now());
		registro.setIdRegistro(1L);
		registro.setNumHoras(new BigDecimal(4));
		registro.setDescripcion("Ha sido un dia muy interesante");
		RegistroService sRegist = new RegistroService();

		/*
		 * try { sRegist.insertRegistro(registro); } catch (UsuarioServiceException e) {
		 * 
		 * e.printStackTrace(); } catch (RegistroServiceException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		/*
		 * try { System.out.println(sRegist.consultRegistros(1L)); } catch
		 * (RegistroServiceException e) {
		 * 
		 * e.printStackTrace(); }
		 */
	}
}
