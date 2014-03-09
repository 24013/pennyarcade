package pennyarcade;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import pennyarcade.block.BlockMiniCreeper;
import pennyarcade.block.BlockMiniPig;
import pennyarcade.block.BlockPennyPusher1;
import pennyarcade.block.BlockPennyPusher2;
import pennyarcade.block.tileentity.TileEntityMiniCreeper;
import pennyarcade.block.tileentity.TileEntityMiniPig;
import pennyarcade.block.tileentity.TileEntityPennyPusher1;
import pennyarcade.block.tileentity.TileEntityPennyPusher2;
import pennyarcade.entity.villager.VillagerTradeHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

@Mod(modid= PennyArcade.MODID, name="Penny Arcade Mod", version="Pre-Alpha 0.0.2")

public class PennyArcade {
	
	public static final String MODID = "pennyarcade";

	@Instance(MODID)
    public static PennyArcade instance;
    @SidedProxy(clientSide="pennyarcade.ClientProxy", serverSide="pennyarcade.CommonProxy")
    public static CommonProxy proxyArcade;
    
    //private ComponentVillage house = new ComponentCoinMerchantHouse();

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static int pennyPusher1ID;
    public static int pennyPusher2ID;
    
    public static int miniCreeperID;
    public static int miniPigID;
    
    public static int goldCoinID;
    public static int emeraldTokenID;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static Block pennyPusher1;
    public static Block pennyPusher2;
    
    public static Block miniCreeper;
    public static Block miniPig;
    
    public static Item goldCoin;
    public static Item emeraldToken;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static int coinChance;
    public static int maxCoinAmount;
    public static int prizeChance;
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static CreativeTabs pennyArcadeTab;
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    	pennyArcadeTab = new CreativeTabs("pennyArcadeTab") {
    		public Item getTabIconItem() {
    			return Items.emerald;
    		}};
    		
    	
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    	config.load();
    	
    	pennyPusher1ID = config.get(Configuration.CATEGORY_GENERAL, "PennyPusher1ID", 4000).getInt();
    	pennyPusher2ID = config.get(Configuration.CATEGORY_GENERAL, "PennyPusher2ID", 4001).getInt();
    	
    	miniCreeperID = config.get(Configuration.CATEGORY_GENERAL, "MiniCreeperID", 4050).getInt();
    	miniPigID = config.get(Configuration.CATEGORY_GENERAL, "MiniPigID", 4051).getInt();
    	
    	goldCoinID = config.get(Configuration.CATEGORY_GENERAL, "GoldCoinID", 10000).getInt();
    	emeraldTokenID = config.get(Configuration.CATEGORY_GENERAL, "EmeraldTokenID", 10001).getInt();
    	
    	coinChance = config.get(Configuration.CATEGORY_GENERAL, "coinChance", 30, "The chance out of 100 that you win coins. Default of 30").getInt();
    	maxCoinAmount = config.get(Configuration.CATEGORY_GENERAL, "maxCoinAmount", 4, "The maximum amount of coins that you win coins. Default of 4").getInt();
    	prizeChance = config.get(Configuration.CATEGORY_GENERAL, "prizeChance", 5, "The chance out of 100 that you win a prize. Default of 5").getInt();
    	
    	config.save();
    	
    	pennyPusher1 = new BlockPennyPusher1(pennyPusher1ID).setBlockName("pennyPusher1").setBlockTextureName(PennyArcade.MODID + "textures/blocks/model/pennyarcade/PennyPusher1").setCreativeTab(pennyArcadeTab);
    	pennyPusher2 = new BlockPennyPusher2(pennyPusher2ID).setBlockName("pennyPusher2").setBlockTextureName(PennyArcade.MODID + ":textures/blocks/model/pennyarcade/PennyPusher2").setCreativeTab(pennyArcadeTab);
    	
    	miniCreeper = new BlockMiniCreeper(miniCreeperID).setBlockName("miniCreeper").setBlockTextureName(PennyArcade.MODID + ":textures/blocks/model/toys/MiniCreeper").setCreativeTab(pennyArcadeTab);
    	miniPig = new BlockMiniPig(miniPigID).setBlockName("miniPig").setBlockTextureName(PennyArcade.MODID + ":textures/blocks/model/toys/MiniPig").setCreativeTab(pennyArcadeTab);
    	
    	goldCoin = new Item(/*goldCoinID*/).setUnlocalizedName("goldCoin").setTextureName(PennyArcade.MODID + ":goldCoin").setCreativeTab(pennyArcadeTab);
    	emeraldToken = new Item(/*emeraldTokenID*/).setUnlocalizedName("emeraldToken").setTextureName(PennyArcade.MODID + ":emeraldToken").setCreativeTab(pennyArcadeTab);
    
    	registerObjects();
    	addCraftingRecipes();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    	proxyArcade.registerRenderers();
    	
    	registerEntities();
    }
    
	public void addCraftingRecipes() {
		
		GameRegistry.addRecipe(new ItemStack(goldCoin, 1), new Object[] { "XX", Character.valueOf('X'), Items.gold_nugget });
		
		GameRegistry.addRecipe(new ItemStack(pennyPusher1, 1), new Object[] { "III", "IPI", "IEI", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('P'), Blocks.glass_pane, Character.valueOf('E'), Items.emerald});
		GameRegistry.addRecipe(new ItemStack(pennyPusher2, 1), new Object[] { "IPI", "IGI", "III", Character.valueOf('I'), Blocks.redstone_block, Character.valueOf('P'), Blocks.glass_pane, Character.valueOf('G'), Items.gold_ingot});
	}
	
	public void registerEntities() {
		GameRegistry.registerTileEntity(TileEntityPennyPusher1.class, "pennyPusher1");
		GameRegistry.registerTileEntity(TileEntityPennyPusher2.class, "pennyPusher2");
		
		GameRegistry.registerTileEntity(TileEntityMiniCreeper.class, "miniCreeper");
		GameRegistry.registerTileEntity(TileEntityMiniPig.class, "miniPig");
		
		registerVillagers();
	}
	
	public void registerObjects() {
		GameRegistry.registerBlock(pennyPusher1, "pennyPusher1");
		GameRegistry.registerBlock(pennyPusher2, "pennyPusher2");
		
		GameRegistry.registerBlock(miniCreeper, "miniCreeper");
		GameRegistry.registerBlock(miniPig, "miniPig");
		
		GameRegistry.registerItem(goldCoin, "goldCoin");
		GameRegistry.registerItem(emeraldToken, "emeraldToken");
	}
	
	public void registerVillagers() {
		//VillagerRegistry.instance().registerVillagerId(999);
		//VillagerRegistry.instance().registerVillagerSkin(999, (new ResourceLocation("pennyarcade:textures/entity/villager/CoinMerchant.png")));
		VillagerTradeHandler coinMerchant = new VillagerTradeHandler();
		VillagerRegistry.instance().registerVillageTradeHandler(1, coinMerchant);
		
		//ArrayList list = new ArrayList();
		//list.add(house);
		
		//VillagerRegistry.addExtraVillageComponents(list, new Random(), 1);
	}
	
}