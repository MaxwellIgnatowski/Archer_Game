package image;

public enum Tileset {

	GRASS("src/image/grass.png"),
	WATER("src/image/water.png"),
	HOUSE("src/image/house1.png"),
	TREE("src/image/tree1.png");
	
	private final String texturePath;
	
	private Tileset(String texturePath)
	{
		this.texturePath = texturePath;
	}
	
	public String getTexture()
	{
		return texturePath;
	}
	
}
