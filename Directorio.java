public class Directorio {
	private String nombre;
	private long tamanio;
	private final int MAXCAR= 40;
	
	Directorio(String nom, long tam){
		nombre= nom;
		tamanio= tam;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nom) {
		nombre= nom;
	}
	
	public long getTamanio() {
		return tamanio;
	}
		
	public void setTamanio(long tam) {
		tamanio= tam;
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////
	public void ver() {
		System.out.println("Directorio: " + nombre + "\nTamaño: " + tamanio + " bytes");
	}
	
	public int niveles() {
		int nivel= 1;
		for(int i= 0; i<= nombre.length()-1; i++) {
			if(nombre.charAt(i)=='/')
				nivel++;
		}
		
		return nivel;
	}
	
	public String ultimo() {
		String carpeta="";
		for(int i= nombre.length()-1; i>= 0 && nombre.charAt(i)!='/'; i--) {
				carpeta= nombre.substring(i);
		}
		
		return carpeta;
	}
	
	private boolean carIlegales() {
		for(int i= 0; i<= nombre.length()-1; i++) {
			if(nombre.charAt(i)=='*' || nombre.charAt(i)=='#' || nombre.charAt(i)=='@')
				return false;
		}
		
		return true;
	}
	
	public String dirValido() {
		String diagnostico="";
		
		if(nombre.length()> MAXCAR)
			diagnostico+= "-Excede el número máximo de caracteres (" + MAXCAR + ")";
		
		if(carIlegales()==false)
			diagnostico+= "\n-Contiene caracteres ilegales";
		
		if(nombre.indexOf("//")!= -1)
			diagnostico+= "\n-Contiene la cadena '//'";
		
		if(!(nombre.charAt(0)>= 'a' && nombre.charAt(0)<= 'z' && nombre.charAt(1)==':'))
			diagnostico+= "\n-No empieza por una unidad de disco";
		
		if(diagnostico.equals(""))
			return "ok";
		else
			return "No es válido:\n" + diagnostico;
		
	}
	
	public void compactarDir() {
		String nombreCompactado="";
		int ini= 0;
		
		for(int i= 0; i<= nombre.length()-1; i++) {
			
			if(nombre.charAt(i)=='/') {
				nombreCompactado+= nombre.substring(ini, i).trim() + "/";
				ini= i+1;
			}
		}
		nombreCompactado+= nombre.substring(ini).trim();
		
		nombre= nombreCompactado;
		
		
	}
	
	
	
	
}