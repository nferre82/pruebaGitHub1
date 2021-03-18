package nelsonferreira;

public class Juego {
	private int duracionJuego;
	private Integer n;
	private Jugador p1;
	private Jugador p2;
	private static final int N=4;
	Juego(int dJ, Integer n, Jugador p1, Jugador p2){
		this.duracionJuego=dJ;
		this.n=n;
		this.p1=p1;
		this.p2=p2;
	}
	
	Juego(int dJ){
		this.duracionJuego=dJ;
		this.n=N;
	}
	
	public Jugador jugar() {
		boolean turnoP1=true;
		int pregunta;
		boolean acierto;
		final int ND=6;
		int aciertosP1=0;
		int aciertosP2=0;
		int respP1=0;
		int respP2=0;
		
		for(int p=1;p<=n;p++) {
			if(turnoP1==true) {
				respP1++;
				if(p1.getNombreJ().isEmpty()==false) {
					System.out.println("es el turno "+p1.getNombreJ());
				}else {
					System.out.println("es el turno del jugador1");
				}
				
			}else {
				respP2++;
				if(p2.getNombreJ().isEmpty()==false) {
					System.out.println("es el turno "+p2.getNombreJ());
				}else {
					System.out.println("es el turno del jugador2");
				}
			}
			
			pregunta=1+(int)(Math.random()*3);
			if(pregunta==1) {
				Punto p1=new Punto();
				Punto p2=new Punto();
				double z=distancia(p1,p2);
				System.out.println("Adivina la distancia entre dos puntos");
				double respuesta=Consola.leeDouble();
				if(Math.abs(z-respuesta)<=0.3) {
					retroal(true);
					if(turnoP1==true) {
						aciertosP1++;
					}else {
						aciertosP2++;
					}
				}else {
					retroal(false);
					acierto=false;
					if(turnoP1==true) {
						turnoP1=false;
					}else {
						turnoP1=true;
					}
				}
			}else {
				int numero=(int)Math.pow(10, ND+1);
				int numerito=0+(int)(Math.random()*numero);
				int copyNum=numerito;
				int recursive=0;
				while(recursive==0&&recursive>9) {
					while(copyNum!=0) {
						recursive+=copyNum%10;
						copyNum=copyNum/10;
					}
					copyNum=recursive;
				}
				System.out.println("Cual es la forma recursiva de "+numerito+"?");
				int respuesta=Consola.leeInt();
				if(respuesta==recursive) {
					retroal(true);
				}else {
					retroal(false);
					acierto=false;
					if(turnoP1==true) {
						turnoP1=false;
					}else {
						turnoP1=true;
					}
				}
			}
		}
		double porcenP1;
		double porcenP2;
		if(aciertosP1>0) {
			porcenP1=respP1/aciertosP1;
		}else {
			porcenP1=0;
		}
		if(aciertosP2>0) {
			porcenP2=respP2/aciertosP2;
		}else {
			porcenP2=0;
		}
		if(porcenP1>porcenP2) {
			if(porcenP1>=porcenP2*2) {
				p1.premiar();
			}
			return p1;
		}else {
			if(porcenP2>=porcenP1*2) {
				p2.premiar();
			}
			return p2;
		}
	}
	private static void retroal(boolean resp) {
		if(resp==true) {
			System.out.println("Bien");
		}else {
			System.out.println("Mal");
		}
	}
	private static double distancia(Punto p1, Punto p2) {
		int n=p1.getX()-p2.getX();
		int m=p1.getY()-p2.getY();
		n=Math.abs(n);
		m=Math.abs(m);
		return Math.sqrt(Math.pow(n, 2)+Math.pow(m, 2));
	}
}
