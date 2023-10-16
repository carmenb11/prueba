package ejercicio01.app;

import java.util.List;

import ejercicio01.modelo.Pelicula;
import ejercicio01.services.PeliculaService;
import ejercicio01.services.PeliculaServiceException;

public class App {
	public static void main(String[] args) {
		PeliculaService service = new PeliculaService();
		List<Pelicula> pelicula;
		try {
			pelicula = service.consultarPeliculas();
			for (Pelicula peliculas : pelicula) {
				System.out.println(peliculas);
			}
		} catch (PeliculaServiceException e) {
			e.printStackTrace();
		}
	}

}
