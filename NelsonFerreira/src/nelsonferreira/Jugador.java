package nelsonferreira;

public class Jugador implements Premiable{
	private String nombreJ;
	private int numPremios;
	private static int noPremiados;
	
	Jugador(String nombre){
		this.nombreJ=nombre;
		compactaNombre();
		this.numPremios=0;
		noPremiados++;
	}
	
	public String getNombreJ() {
		return nombreJ;
	}

	private void compactaNombre() {
		String str2="";
		this.nombreJ.toLowerCase();
		int numPalabra=0;
		for(int i=0;i<this.nombreJ.length();i++) {
			if(this.nombreJ.charAt(i)==' ') {
				str2=str2+"";
			}else {
				if(numPalabra==0&&this.nombreJ.charAt(i)>='a'&&this.nombreJ.charAt(i)<='z') {
					str2+=this.nombreJ.substring(i+1, i+2).toUpperCase();
					numPalabra++;
				}else {
					str2+=this.nombreJ.charAt(i);
					numPalabra++;
				}
			}
		}
		this.nombreJ=str2;
	}
	
	@Override
	public String toString() {
		return "Jugador: "+this.nombreJ+", premios: "+this.numPremios;
	}

	@Override
	public String premiar() {
		if(this.numPremios==0) {
			noPremiados--;
		}
		this.numPremios++;
		return "Enhorabuena. Es el premio Nº "+this.numPremios;
	}
	
	public void verNoPremiados() {
		System.out.println(noPremiados);
	}
}
