package com.yurtmod.init;

import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.config.Configuration;

public class Config 
{
	public static boolean ALLOW_CRAFT_SUPER_MALLET;
	public static boolean ALLOW_CRAFT_YURT_SMALL;
	public static boolean ALLOW_CRAFT_YURT_MED;
	public static boolean ALLOW_CRAFT_YURT_LARGE;
	public static boolean ALLOW_CRAFT_TEPEE_SMALL;
	public static boolean ALLOW_CRAFT_TEPEE_MED;
	public static boolean ALLOW_CRAFT_TEPEE_LARGE;
	public static boolean ALLOW_CRAFT_BED_SMALL;
	public static boolean ALLOW_CRAFT_BED_MED;
	public static boolean ALLOW_CRAFT_BED_LARGE;

	public static boolean REQUIRE_MORE_CANVAS;
	public static boolean REQUIRE_MORE_LEATHER;
	public static boolean REQUIRE_CARPET;
	public static int NUM_YURT_WALL_OUTPUT;
	public static int NUM_TEPEE_WALL_OUTPUT;
	public static int NUM_TEPEE_WALL_OUTPUT_RABBIT;
	public static int NUM_BED_WALL_OUTPUT;

	public static boolean ALLOW_REFUND;
	public static boolean REQUIRE_GOLD_BLOCKS;
	public static int TEPEE_DECORATED_CHANCE;
	
	public static boolean ALLOW_SLEEP_TENT_DIM;
	public static boolean SLEEP_TO_DAY_IN_TENT_DIM;
	public static boolean ALLOW_RESPAWN_TENT_DIM;
	
	public static int DIM_ID;

	private static final String C_TEPEE_WALL = "wall_piece_tepee";
	private static final String C_YURT_WALL = "wall_piece_yurt";
	private static final String C_BED_WALL = "wall_piece_bedouin";
	private static final String CATEGORY_CRAFTING = "crafting";

	public static void mainRegistry(Configuration config)
	{
		config.load();

		ALLOW_CRAFT_SUPER_MALLET = config.getBoolean("Craft Super Mallet", CATEGORY_CRAFTING, true, 
				"Whether the Super Mallet is craftable");
		ALLOW_CRAFT_YURT_SMALL = config.getBoolean("Craft Small Yurt", CATEGORY_CRAFTING, true, 
				"Whether the Small Yurt can be crafted");
		ALLOW_CRAFT_YURT_MED = config.getBoolean("Craft Medium Yurt", CATEGORY_CRAFTING, true, 
				"Whether the Medium Yurt can be crafted");
		ALLOW_CRAFT_YURT_LARGE = config.getBoolean("Craft Large Yurt", CATEGORY_CRAFTING, true, 
				"Whether the Large Yurt can be crafted");
		ALLOW_CRAFT_TEPEE_SMALL = config.getBoolean("Craft Small Tepee", CATEGORY_CRAFTING, true, 
				"Whether the Small Tepee can be crafted");
		ALLOW_CRAFT_TEPEE_MED = config.getBoolean("Craft Medium Tepee", CATEGORY_CRAFTING, true, 
				"Whether the Medium Tepee can be crafted");
		ALLOW_CRAFT_TEPEE_LARGE = config.getBoolean("Craft Large Tepee", CATEGORY_CRAFTING, true, 
				"Whether the Large Tepee can be crafted");
		ALLOW_CRAFT_BED_SMALL = config.getBoolean("Craft Small Bedouin", CATEGORY_CRAFTING, true, 
				"Whether the Small Bedouin can be crafted");
		ALLOW_CRAFT_BED_MED = config.getBoolean("Craft Medium Bedouin", CATEGORY_CRAFTING, true, 
				"Whether the Medium Bedouin can be crafted");
		ALLOW_CRAFT_BED_LARGE = config.getBoolean("Craft Large Bedouin", CATEGORY_CRAFTING, true, 
				"Whether the Large Bedouin can be crafted");
		ALLOW_REFUND = config.getBoolean("Allow tent refund", CATEGORY_CRAFTING, false, 
				"When true, using an invalid tent item makes it drop new crafting materials for that item (slightly buggy)");
		REQUIRE_GOLD_BLOCKS	= config.getBoolean("Use Gold Blocks for Super Mallet", CATEGORY_CRAFTING, true, 
				"When true, the Super Tent Mallet recipe will use gold blocks instead of enchanted golden apples");

		REQUIRE_CARPET = config.getBoolean("Require Carpet", C_BED_WALL, false, 
				"When true, the Bedouin Wall recipe requires 4 carpet instead of 4 wool");
		NUM_BED_WALL_OUTPUT = config.getInt("Recipe Output Amount", C_BED_WALL, 1, 1, 6, 
				"Number of Bedouin Wall Pieces generated by one recipe");
		REQUIRE_MORE_CANVAS = config.getBoolean("Require More Canvas", C_YURT_WALL, false, 
				"When true, the Yurt Wall recipe requires 6 canvas instead of 4");
		NUM_YURT_WALL_OUTPUT = config.getInt("Recipe Output Amount", C_YURT_WALL, 1, 1, 6, 
				"Number of Yurt Wall Pieces generated by one recipe");
		REQUIRE_MORE_LEATHER = config.getBoolean("Require More Leather", C_TEPEE_WALL, false, 
				"When true, the Tepee Wall recipe requires 6 leather instead of 4");
		NUM_TEPEE_WALL_OUTPUT = config.getInt("Recipe Output Amount - Leather", C_TEPEE_WALL, 1, 1, 6, 
				"Number of Tepee Wall Pieces generated by one recipe, using leather");
		NUM_TEPEE_WALL_OUTPUT_RABBIT = config.getInt("Recipe Output Amount - Rabbit Hide", C_TEPEE_WALL, 1, 1, 6, 
				"Number of Tepee Wall Pieces generated by one recipe, using 6 rabbit hide");

		TEPEE_DECORATED_CHANCE = config.getInt("Tepee Design Chance", Configuration.CATEGORY_GENERAL, 35, 0, 100, 
				"Percentage chance that a plain tepee block will randomly have a design");
		SLEEP_TO_DAY_IN_TENT_DIM = config.getBoolean("Reset time from Tent dim", Configuration.CATEGORY_GENERAL, true, 
				"When true, waking up in Tent Dimension will reset the time for overworld and tent dim");
		ALLOW_SLEEP_TENT_DIM = !config.getBoolean("Beds explode in Tent Dim", Configuration.CATEGORY_GENERAL, false, 
				"When true, beds used in the Tent Dimension will explode");
		ALLOW_RESPAWN_TENT_DIM = config.getBoolean("Respawn in Tent dim", Configuration.CATEGORY_GENERAL, false, 
				"When true, players who die in the Tent dim can respawn there");
		DIM_ID = config.getInt("Tent Dimension ID", Configuration.CATEGORY_GENERAL, DimensionManager.getNextFreeDimId(), -255, 255, 
				"The ID for the Tent Dimension. Delete this field whenever you add/remove a dimension-adding mod");

		config.save();
	}
}
