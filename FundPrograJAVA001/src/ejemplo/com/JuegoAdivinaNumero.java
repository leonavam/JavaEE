package ejemplo.com;

public class JuegoAdivinaNumero extends Juego {
	int numeroAdivina;
	int numeroPre;
	boolean evalua = true;
	
	public JuegoAdivinaNumero(int vidasInic, int num) {
		super(vidasInic);
		this.numeroPre = num;
	}
	
	public void Juega() {
		ReiniciarPartida();
		System.out.println("Adivina un numero entre 0 y 10");
		this.numeroAdivina = Teclado.LeeEntero();
		while(evalua == true) {
			if (numeroAdivina == numeroPre) {
				System.out.println("Acertaste!!");
				return;
			}
			else if(ValidaNumero(numeroAdivina) != true)
				this.numeroAdivina = Teclado.LeeEntero();
			else if (numeroAdivina != numeroPre) {
				evalua = QuitaVida();
				if(evalua == true) {
					if(numeroPre > numeroAdivina)
						System.out.println("El numero a adivinar es mayor, vuelve a intentarlo!!");
					else
						System.out.println("El numero a adivinar es menor, vuelve a intentarlo!!");
				}
				this.numeroAdivina = Teclado.LeeEntero();
			}
		}
		

	}
	
	public boolean ValidaNumero(int num) {
		
		return true;
	}

}
