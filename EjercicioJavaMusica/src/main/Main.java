
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		File archivoCanciones = new File("archivoCanciones.txt");
		
		try {
			
			if(!archivoCanciones.exists()) {
				archivoCanciones.createNewFile();
			}
			
		
			
			FileReader fr = new FileReader(archivoCanciones.getAbsolutePath());
			BufferedReader br = new BufferedReader(fr);
			
			ArrayList<Cancion> cancionList = new ArrayList<>();
			
			String[] cancionParts = new String[6];
			String texto;
			

			while((texto = br.readLine()) != null) {
				cancionParts = texto.split(",");
				Cancion cancionHecha = new Cancion(cancionParts[1],cancionParts[2], Integer.parseInt(cancionParts[3]), cancionParts[4], cancionParts[5]);
				cancionList.add(cancionHecha);
				
				
			}
			
			br.close();
			fr.close();
			
			

		
		while(!salir) {
			
			System.out.println("----OPCIONES---\n");
			System.out.println("1. Anadir cancion");
			System.out.println("2. Borrar cancion");
			System.out.println("3. Modificar cancion");
			System.out.println("4. Guardar y salir\n");
			
			
			try {
				int decision = sc.nextInt();
				sc.nextLine();
				switch(decision) {
				case 1:
					crearCancion(cancionList, sc);
					break;
				case 2: 
					borrarCancion(cancionList, sc);
					break;
				case 3: 
					editarCancion(cancionList, sc);
					break;
				case 4:
					salir = true;
					break;
				default:
					System.out.println("Opcion no valida");
				}
			}catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("\nOpcion no contemplada, porfavor introduzca un numero\n");
			}
			
			
			
			
			
		}
		
		FileWriter fw = new FileWriter(archivoCanciones.getAbsolutePath());
		PrintWriter pw = new PrintWriter(fw);
		
		for(int i = 0 ; i < cancionList.size(); i++) {
			pw.println((i+1) + "," + cancionList.get(i).getTitulo() + "," +  cancionList.get(i).getArtista() + "," +  cancionList.get(i).getDuracion() 
					+ "," +  cancionList.get(i).getAlbum() + "," +  cancionList.get(i).getLyricPath());
		}
		
		
		pw.flush();
		pw.close();
		fw.close();
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		

	}
	
	public static void crearCancion(ArrayList<Cancion> cancionList, Scanner sc) {
		System.out.println("Que titulo tiene la cancion?");
		String titulo = sc.nextLine();
		if(titulo.equals("")) {
			titulo = "No title defined";
		}
		
		System.out.println("De quien es la cancion?");
		String artista = sc.nextLine();
		if(artista.equals("")) {
			artista = "No artist defined";
		}
		
		System.out.println("Cuanto dura en segundos?");
		int duracion = sc.nextInt();
		sc.nextLine();
		
		System.out.println("A que album pertenece?");
		String album = sc.nextLine();
		if(album.equals("")) {
			album = "No album defined";
		}
		
		System.out.println("cual es el path de su archivo de lyrics?");
		String lyricPath = sc.nextLine();
		if(lyricPath.equals("")) {
			lyricPath = "No path defined";
		}
		
		Cancion cancion = new Cancion(titulo, artista, duracion, album, lyricPath);
		cancionList.add(cancion);
		
		System.out.println("Cancion Creada");
		
	}
	
	
	
	
	
	
	
	
	
	public static void borrarCancion(ArrayList<Cancion> cancionList, Scanner sc) {
		System.out.println("Que cancion quieres borrar?");
		System.out.println("-----LISTA----");
		for(int i = 0; i<cancionList.size(); i++) {
			System.out.println(i +1+". " +cancionList.get(i).getTitulo());
		}
		
		int deci = sc.nextInt();
		sc.nextLine();
		
		if(deci <=0 || deci >= cancionList.size()) {
			System.out.println("La cancion no se encuentra en la lista");
		}else {
			cancionList.remove(deci-1);
			
			System.out.println("Cancion elimada");
		}
		
		
		
	}
	
	
	
	public static void editarCancion(ArrayList<Cancion> cancionList, Scanner sc) {
		System.out.println("Que cancion quieres editar?\n -----LISTA----");
		for(int i = 0; i<cancionList.size(); i++) {
			System.out.println(i +1+". " +cancionList.get(i).getTitulo());
		}
		
		int deci = sc.nextInt();
		sc.nextLine();
		
		if(deci <=0 || deci >= cancionList.size()) {
			System.out.println("La cancion no se encuentra en la lista");
		}else {
			System.out.println("quieres editar la cancion: " +  cancionList.get(deci-1).getTitulo() + "\n-------------------------");
			System.out.println("1. Editar titulo\n2. Editar artista\n3. Editar duracion\n4. Editar album\n5. Editar ruta de lyrics\n6. Salir");
			int deciEdit = sc.nextInt();
			sc.nextLine();
			
			switch(deciEdit) {
			case 1: 
				System.out.println("Nuevo titulo: ");		
				cancionList.get(deci-1).setTitulo(sc.nextLine());
				System.out.println("cancion editada");
				break;
			case 2: 
				System.out.println("Nuevo Artista: ");
				cancionList.get(deci-1).setArtista(sc.nextLine());
				System.out.println("cancion editada");
				break;
			case 3: 
				System.out.println("Nueva duracion: ");
				cancionList.get(deci-1).setDuracion(sc.nextInt());
				System.out.println("cancion editada");
				sc.nextLine();
				break;
			case 4: 
				System.out.println("Nuevo album: ");
				cancionList.get(deci-1).setAlbum(sc.nextLine());
				System.out.println("cancion editada");
				break;
			case 5: 
				System.out.println("Nueva Ruta de lyrics: ");
				cancionList.get(deci-1).setLyricPath(sc.nextLine());
				System.out.println("cancion editada");
				sc.nextLine();
				break;
			case 6: 
				break;
			default:
				System.out.println("Opcion no valida");
			}
		}
		
		
		
		
		
	
	}

}

