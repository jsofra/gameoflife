

public class Gridded2DNetwork<D extends Direction<D>, S> extends AbstractCellularNetwork<Cell<D, S>> {
	
	public enum Type { Torus, Finite }

	protected int width;
	protected int height;
	protected Type type;
	protected CellFactory<D, S> factory;
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Type getType() {
		return type;
	}
	
	public CellFactory<D, S> getFactory() {
		return factory;
	}
	
	protected void constructNextwork(D[] directions) {
		Cell<D, S>[][] grid = constructGrid();
		
		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				for(D dir : directions) {
					makeConnection(x, y, dir, grid);
				}
				this.addCell(grid[x][y]);
			}
		}
	}
	
	private Cell<D, S>[][] constructGrid() {
		@SuppressWarnings("unchecked")
		Cell<D, S>[][] grid = new Cell[this.height][this.width];
		
		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				grid[y][x] = this.factory.createCell();
			}
		}
		return grid;
	}
	
	private void makeConnection(int x, int y, D direction, Cell<D, S>[][] grid) {
		Cell<D, S> from = grid[x][y];

		int[] xy = direction.moveInDir(x, y);
		x = xy[0]; y = xy[1];
		
		if (x < 0 || x >= this.width || y < 0 || y >= this.height) {
			if (this.type == Gridded2DNetwork.Type.Torus) {
				x = ((this.width - 1) + x) % (this.width - 1);
				y = ((this.height - 1) + y) % (this.height - 1);
			} else {
				return;
			}
		}
		from.setNeighbour(direction, grid[x][y]);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (Cell<D, S> cell : this) {
			i++;
			sb.append(cell.toString());
			if (i == this.width) {
				sb.append('\n');
				i = 0;
			}
		}
		return sb.toString();
	}
}
