import java.util.Collection;


public interface Cell<D extends Direction<D>, S> {
	
	// define getters and setters
	public void setNeighbour(D direction, Cell<D, S> neighbour);
	public Cell<D, S> getNeighbour(D direction);
	public Collection<? extends Cell<D, S>> getNeighbours();
	
	public void setState(S state);
	public S getState();
	
	// getters and setters for next generation
	public void setNextState(S state);
	public S getNextState();
	
	public void updateNextState();
	public void updateState();
	
}
