import java.util.Collection;
import java.util.HashMap;


public abstract class AbstractCell<D extends Direction<D>, S> implements Cell<D, S> {

	protected S state;
	protected S nextState;
	protected HashMap<D, Cell<D, S>> neigbours = new HashMap<D, Cell<D, S>>();
	
	public AbstractCell(S initState) {
		this.state = initState;
	}

	public void setNeighbour(D direction, Cell<D, S> neighbour) {
		if (neighbour != null) {
			this.neigbours.put(direction, neighbour);
			D revDir = direction.reverseDirection();
			if (neighbour.getNeighbour(revDir) == null || neighbour.getNeighbour(revDir) != this) {
				neighbour.setNeighbour(revDir, this);
			}
		}
	}

	public Cell<D, S> getNeighbour(D direction) {
		return this.neigbours.get(direction);
	}
	
	public Collection<Cell<D, S>> getNeighbours() {
		return this.neigbours.values();
	}

	public void setState(S state) {
		this.state = state;
	}

	public S getState() {
		return state;
	}

	public void setNextState(S state) {
		this.nextState = state;
	}

	public S getNextState() {
		return this.nextState;
	}

	public void updateState() {
		this.state = this.nextState;
		this.nextState = null;
	}

}
