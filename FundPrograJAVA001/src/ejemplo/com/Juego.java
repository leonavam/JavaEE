package ejemplo.com;

public abstract class Juego {
	private int vidasRestantes;
	private int vidasInic;
	private static int record = 0;
	
	public Juego(int vidasInic) {
		this.vidasInic = vidasInic;
		this.vidasRestantes = this.vidasInic;
	}
	
	public void MuestraVidasRestantes() {
		System.out.println("Vidas del jugador: " + vidasRestantes);
	}
	
	public boolean QuitaVida() {
		if(vidasRestantes <= 0) {
			System.out.println("Juego Terminado");
			return false;
		}else
			vidasRestantes -=1;
		return true;
	}
	
	public void ReiniciarPartida() {
		vidasRestantes = vidasInic;
	}
	
	public void ActualizaRecord() {
		if (vidasRestantes == record)
			System.out.println("Se ha alcanzado el record");
		else if (vidasRestantes > record) {
			record = vidasRestantes;
			System.out.println("El record se ha batido, el valor actual es " + record);
		}	
	}
	public abstract void Juega();
	
}
