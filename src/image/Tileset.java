package image;

public enum Tileset {

	GRASS("src/image/grass.png", true),
	WATER("src/image/water.png", false),
	HOUSE("src/image/house1.png", false),
	TREE("src/image/tree1.png", false),
	PATH("src/image/path1.png", true);
	
	private final String texturePath;
	private final boolean canWalkOn;
	
	Tileset(String texturePath, boolean canWalkOn)
	{
		this.texturePath = texturePath;
		this.canWalkOn = canWalkOn;
	}
	
	public String getTexture()
	{
		return texturePath;
	}

	public boolean canWalkOn() {
		return canWalkOn;
	}
}
