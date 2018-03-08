package ejemplo.com;

public class JuegoAdivinaPar extends JuegoAdivinaNumero {

	public JuegoAdivinaPar(int vidasInic, int num) {
		super(vidasInic, num);
	}
	
	public boolean ValidaNumero(int num) {
		if(num%2 != 0) {
			System.out.println("Error!!!!!!");
			return false;
		}else
			return true;
	}

}
