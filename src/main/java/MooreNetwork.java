

public class MooreNetwork<S> extends Gridded2DNetwork<MooreNeighbourhood, S> {
	
	public MooreNetwork(int width, int height, Type type, CellFactory<MooreNeighbourhood, S> cellFactory) {
		this.width = width;
		this.height = height;
		this.type = type;
		this.factory = cellFactory;
		this.constructNextwork(MooreNeighbourhood.values());
	}
}
