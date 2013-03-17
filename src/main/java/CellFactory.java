

public interface CellFactory<D extends Direction<D>, S> {
	public Cell<D, S> createCell();
}
