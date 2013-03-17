
public class SimulationRunner {

	public static void main(String[] args) {
		int width = 20;
		int height = 20;
		MooreNetwork<Boolean> network = new MooreNetwork<Boolean>(width, height, MooreNetwork.Type.Torus, new GOLFactory());
		
		System.out.println(network);
		network.updateState();
		System.out.println(network);
	}

}
