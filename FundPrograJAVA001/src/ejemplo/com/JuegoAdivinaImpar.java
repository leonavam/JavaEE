package ejemplo.com;

public class JuegoAdivinaImpar extends JuegoAdivinaNumero {

	public JuegoAdivinaImpar(int vidasInic, int num) {
		super(vidasInic, num);
		// TODO Auto-generated constructor stub
	}
	
	public boolean ValidaNumero(int num) {
		if(num%2 == 0) {
			System.out.println("Error!!!!!!");
			return false;
		}else
			return true;
	}

}
