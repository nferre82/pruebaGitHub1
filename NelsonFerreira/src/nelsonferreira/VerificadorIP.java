package nelsonferreira;

public class VerificadorIP extends VerificadorCadena{
	private static final int MINIPRANGE=0;
	private static final int MAXIPRANGE=255;
	
	VerificadorIP(String cadenaV){
		super(cadenaV);
	}
	public boolean esValida() {
		boolean puntosSeguidos=false;
		int puntos=0;
		int numeros=0;
		int n1=0;
		int n2=0;
		int n3=0;
		boolean esValid=true;
		for(int i=0;i<this.getCadenaAverificar().length();i++) {
			if((this.getCadenaAverificar().charAt(i)<0)||(this.getCadenaAverificar().charAt(i)>9)&&this.getCadenaAverificar().charAt(i)!='.') {
				return false;
			}
			if(this.getCadenaAverificar().charAt(i)=='.') {
				puntos++;
				numeros=0;
				if(puntos>=2) {
					return false;
				}
			}else {
				puntos=0;
				numeros++;
				switch(numeros) {
				case 1:
					n1=this.getCadenaAverificar().charAt(i);
				case 2:
					n2=this.getCadenaAverificar().charAt(i);
				case 3:
					n3=this.getCadenaAverificar().charAt(i);
					if(n1>2||(n1<=2&&n2>5)||(n1<=2&&n2<=5&&n3>5)){
						return false;
					}
				default: return false;
				}
			}
			if(i==0&&this.getCadenaAverificar().charAt(i)=='.') {
				return false;
			}
			if(i==this.getCadenaAverificar().length()-1&&this.getCadenaAverificar().charAt(i)=='.') {
				return false;
			}
			
		}
		if(this.getCadenaAverificar().length()>15) {
			return false;
		}
		return true;
	}

}
