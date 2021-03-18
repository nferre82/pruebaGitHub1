package nelsonferreira;

public abstract class VerificadorCadena {
	private String cadenaAverificar;
	private static int numeroVerificador=0;
	
	VerificadorCadena(String cadenaV){
		
		this.cadenaAverificar=cadenaV;
		numeroVerificador++;
	}
	
	public abstract boolean esValida();
	
	public int vecesContiene(String str) {
		int n=0;
		if(this.cadenaAverificar.contains(str)) {
			String str2=this.cadenaAverificar;
			str2.indexOf(str);
			
			return n;
		}else {
			return 0;
		}
		
		
	}

	public String getCadenaAverificar() {
		return cadenaAverificar;
	}
}
