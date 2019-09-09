package modelo;


public class Jugador implements Comparable<Jugador>{

	private String nombre;
	private String apellido;
	private Posicion posicion;
	private Integer edad;
	private float altura;
	private float peso;
	
	private Integer puntaje;
	
	public Jugador(String nombre, String apellido, Posicion posicion, Integer edad, float altura, float peso, Integer puntaje)
	{
		this.altura=altura;
		this.apellido=apellido;
		this.nombre=nombre;
		this.posicion=posicion;
		this.edad=edad;
		this.peso=peso;		
		this.puntaje=puntaje;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public Integer getEdad() {
		return edad;
	}

	public float getAltura() {
		return altura;
	}

	public float getPeso() {
		return peso;
	}
	
	public Integer getPuntaje() {
		return this.puntaje;
	}



	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	@Override
	public int compareTo(Jugador o) {
		Integer a=this.getPuntaje();
		Integer b=o.getPuntaje();
		return a.compareTo(b);
	}



	
	
}
