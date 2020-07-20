import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.angelica.modelos.Articulo;
import com.angelica.modelos.Autor;
import com.angelica.modelos.Pago;
import com.angelica.modelos.Pseudonimo;
import com.angelica.modelos.Revista;

public class Sistema {
	
	private static Scanner in = new Scanner(System.in);
	
	private List<Revista> revistas = new ArrayList<Revista>();
	private List<Articulo> articulos = new ArrayList<Articulo>();
	private List<Autor> autores = new ArrayList<Autor>();
	private List<Pago> pagos = new ArrayList<Pago>();
	private Integer secuenciaRevistas = 0;
	private Integer secuenciaAutores = 0;
	private Integer secuenciaArticulos = 0;
	private Integer secuenciaPagos = 0;
	
	public static void main(String... strings) {
		Integer opcion = 0;
		System.out.println("Bienvenido al Sistema Editorial Writter's Digest");
        Sistema sistema = new Sistema();
        do {
        	
        	sistema.escribeMenu();
	        try {
	        	opcion = Integer.parseInt(in.nextLine());
				switch(opcion) {
					case 1: sistema.altaAutor();break;
					case 2: sistema.altaArticulo();break;
					case 3: sistema.altaPago();break;
					case 4: sistema.agregarRevista();break;
					case 5: sistema.mostrarRevistas();break;
					case 6: sistema.mostrarArticulos();break;
					case 7: sistema.mostrarAutores();break;
					case 8: sistema.mostrarPagos();break;
				}
	        } catch(Exception e) {
	        	System.out.println("Opcion no valida");
	        }
        } while(opcion != 9);
        in.close();
	}
	
	
	public void escribeMenu() {
		System.out.println("Elige una opcion:\n");
		System.out.println("1:\tDar de alta Autor");
		System.out.println("2:\tRegitrar Articulo");
		System.out.println("3:\tRegistrar Pago");
		System.out.println("4:\tCrear Revista");
		System.out.println("5:\tConsultar Revistas");
		System.out.println("6:\tMostrar Articulos");
		System.out.println("7:\tMostrar Autores");
		System.out.println("8:\tMostrar Pagos");
		System.out.println("9:\tSalir\n");
	}
	
	public void mostrarAutores() {
		System.out.println("Autores:\n");
		autores.forEach(autor -> System.out.println(autor.toString()));
	}
	
	public void mostrarArticulos() {
		System.out.println("Articulos:\n");
		articulos.forEach(articulo -> System.out.println(articulo.toString()));
	}
	
	public void mostrarPagos() {
		System.out.println("Pagos:\n");
		pagos.forEach(pago -> System.out.println(pago.toString()));
	}
	
	public void mostrarRevistas() {
		System.out.println("Revistas:\n");
		revistas.forEach(revista -> System.out.println(revista));
	}
	
	private Integer seleccionarAutor() {
		Integer autorSeleccionado = 0;
		do {
			mostrarAutores();
			System.out.println("Ingresa el id del autor:\n");
	        try {
	        	autorSeleccionado = Integer.parseInt(in.nextLine());
				System.out.println("Autor Seleccionado: " + autorSeleccionado);
	        } catch(Exception e) {
	        	autorSeleccionado = 0;
	        	System.out.println("Autor no valida");
	        }
        } while(autorSeleccionado == 0);

        return autorSeleccionado;
	}
	
	public void altaAutor() throws Exception {
		System.out.println("Ingresa el nombre del autor:");
		String nombre = in.nextLine();
		if(autores.size() > 0) {
			System.out.println("Es pseudonimo S/N?");
			String esPseudonimo = in.nextLine();
			if("S".equals(esPseudonimo) || "s".equals(esPseudonimo)) {
				Integer autorReal = seleccionarAutor();
				autores.forEach(autor -> {
	        		if(autor.getIdAutor() == autorReal) {
	        			Autor nuevoPseudonimo = new Pseudonimo(++secuenciaAutores, nombre, autor);
	    				autores.add(nuevoPseudonimo);
	        		}
	        	});
			} else {
				Autor nuevo = new Autor(++secuenciaAutores, nombre);
				autores.add(nuevo);
			}
		} else {
			Autor nuevo = new Autor(++secuenciaAutores, nombre);
			autores.add(nuevo);
		}
	}
	
	public void altaArticulo() throws Exception {
		if(autores.size() < 1) {
			System.out.println("Debes agregar al menos 1 autor\n\n");
		} else {
			System.out.println("Ingresa el titulo del articulo");
			String titulo = in.nextLine();
			Articulo nuevo = new Articulo(++secuenciaArticulos, titulo);
			List<Autor> autoresArticulo = new ArrayList<Autor>();
			String agregarOtro;
			do {
				Integer autorArticulo = seleccionarAutor();
				autores.forEach(autor -> {
	        		if(autor.getIdAutor() == autorArticulo) {
	        			autoresArticulo.add(autor);
	        		}
	        	});
				System.out.println("Agregar otro autor S/N?");
				agregarOtro = in.nextLine();
			} while("S".equals(agregarOtro) || "s".equals(agregarOtro));
			nuevo.setAutores(autoresArticulo);
			articulos.add(nuevo);
		}
	}
	
	public void altaPago() throws Exception {
		if(autores.size() < 1) {
			System.out.println("Debes agregar al menos 1 autor\n\n");
		} else if(articulos.size() < 1) {
			System.out.println("Debes agregar al menos 1 articulo\n\n");
		} else {
			Double monto = 0d;
			do {
				System.out.println("Ingresa el monto del pago");
		        try {
		        	monto = Double.parseDouble(in.nextLine());
		        } catch(Exception e) {
		        	monto = 0d;
		        	System.out.println("Monto no valido debe ser un numero mayor a 0, puede llevar decimales");
		        }
	        } while(monto == 0d);
			
			Integer idArticulo = 0;
			do {
				System.out.println("Selecciona el Id del articulo:\n");
				articulos.forEach(articulo -> System.out.println(articulo.toStringSimple()));
		        try {
		        	idArticulo = Integer.parseInt(in.nextLine());
		        } catch(Exception e) {
		        	idArticulo = 0;
		        	System.out.println("Id articulo no valido");
		        }
	        } while(idArticulo == 0d);
			Integer idAutor = seleccionarAutor();
			Integer articuloFinal = idArticulo;
			Pago nuevo = new Pago(++secuenciaPagos, monto);
			autores.forEach(autor -> {
        		if(autor.getIdAutor() == idAutor) {
        			articulos.forEach(articulo -> {
        				if(articulo.getIdArticulo() == articuloFinal) {
        					nuevo.setArticulo(articulo);
        					nuevo.setAutor(autor);
        				}
        			});
        		}
        	});
			pagos.add(nuevo);
		}
	}
	
	public void agregarRevista() throws Exception {
		if(articulos.size() < 1) {
			System.out.println("Debes agregar al menos 1 articulo\n\n");
		} else {
			Double precio = 0d;
			do {
				System.out.println("Ingresa el precio de la revista");
		        try {
		        	precio = Double.parseDouble(in.nextLine());
		        } catch(Exception e) {
		        	precio = 0d;
		        	System.out.println("Precio no valido debe ser un numero mayor a 0, puede llevar decimales");
		        }
	        } while(precio == 0d);
			
			String agregarOtro;
			Revista nueva = new Revista(++secuenciaRevistas, precio);
			do {
				Integer idArticulo = 0;
				do {
					System.out.println("Selecciona el Id del articulo:\n");
					articulos.forEach(articulo -> System.out.println(articulo.toStringSimple()));
			        try {
			        	idArticulo = Integer.parseInt(in.nextLine());
			        } catch(Exception e) {
			        	idArticulo = 0;
			        	System.out.println("Id articulo no valido");
			        }
		        } while(idArticulo == 0d);
				Integer articuloFinal = idArticulo;
				articulos.forEach(articulo -> {
					if(articulo.getIdArticulo() == articuloFinal) {
						nueva.agregarArticulo(articulo);
					}
				});
				System.out.println("Agregar otro articulo S/N?");
				agregarOtro = in.nextLine();
			} while("S".equals(agregarOtro) || "s".equals(agregarOtro));
			revistas.add(nueva);
		}
	}
}
