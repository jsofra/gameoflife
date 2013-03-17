import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class AbstractCellularNetwork<C extends Cell<?, ?>> implements Iterable<C> {

	protected List<C> cells = new LinkedList<>();
	
	public Iterator<C> iterator() {
		return this.cells.iterator();
	}
	
	public void addCell(C cell) {
		cells.add(cell);
	}
	
	public int getCellCount() {
		return cells.size();
	}

	public void updateState() {
		// do update in two steps
		// #1 update the next state of all the cells
		// #2 update the state of the cells to their next state that was just calculated
		for (Cell<?, ?> cell : this) {
			cell.updateNextState();
		}
		for (Cell<?, ?> cell : this) {
			cell.updateState();
		}
	}
}
