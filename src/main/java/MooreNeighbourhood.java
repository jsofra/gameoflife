

public enum MooreNeighbourhood implements Direction<MooreNeighbourhood> {
	North(0, 1), NorthEast(1, 1), East(1, 0), SouthEast(1, -1), South(0, -1), SouthWest(-1, -1), West(-1, 0), NorthWest(-1, 1);

	private int x;
	private int y;

	private MooreNeighbourhood(int x, int y) {
		this.x = x; this.y = y;
	}
	
	@Override
	public MooreNeighbourhood reverseDirection() {
		return MooreNeighbourhood.values()[(this.ordinal() + 4) % 8];
	}
	
	@Override
	public int[] moveInDir(int... args) {
		return new int[] {args[0] - this.x, args[1] - this.y};
		
	}

}
