
import java.util.Random;


public class GOLFactory implements CellFactory<MooreNeighbourhood, Boolean> {

	@Override
	public GOLCell createCell() {
		Random random = new Random();
		return new GOLCell(random.nextBoolean());
	}

}
