package ejemplo.com;

public class Aplicacion {

	public static void main(String[] args) {
		JuegoAdivinaNumero j1 = new JuegoAdivinaNumero(3,8);
		JuegoAdivinaPar jpar = new JuegoAdivinaPar(3, 10);
		JuegoAdivinaImpar jimpar = new JuegoAdivinaImpar(3, 9);
		
		j1.Juega();
		jpar.Juega();
		jimpar.Juega();
	}

}
