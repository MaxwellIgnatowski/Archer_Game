package image;

public enum Tileset {

	CTR_UP("src/image/archerBackward.png", true),
	CTR_LEFT("src/image/archerLeft.png", true),
	CTR_RIGHT("src/image/archerRight.png", true),
	CTR_DOWN("src/image/archerForward.png", true),
	GRASS("src/image/grass.png", true),
	WATER("src/image/water.png", false),
	HOUSE("src/image/house1.png", false),
	TREE("src/image/tree1.png", false),
	LILYPAD("src/image/lilypad.png", false),
	PATH("src/image/path1.png", true),
	BRIDGE_HORIZONTAL("src/image/bridgeH.png", true),
	BRIDGE_VERTICAL("src/image/bridgeV.png", true);
	
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
