package main;

public class Cancion {
	
	private String titulo;
	private String artista;
	private int duracion;
	private String album;
	private String lyricPath;
	

	public Cancion(String titulo, String artista, int duracion, String album, String lyricPath) {
		this.titulo = titulo;
		this.artista = artista;
		this.duracion = duracion;
		this.album = album;
		this.lyricPath = lyricPath;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getArtista() {
		return artista;
	}


	public void setArtista(String artista) {
		this.artista = artista;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public String getAlbum() {
		return album;
	}


	public void setAlbum(String album) {
		this.album = album;
	}


	public String getLyricPath() {
		return lyricPath;
	}


	public void setLyricPath(String lyricPath) {
		this.lyricPath = lyricPath;
	}
	
	
	
	
}
