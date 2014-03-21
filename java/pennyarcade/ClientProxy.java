package pennyarcade;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import pennyarcade.block.render.ItemRenderer;
import pennyarcade.block.render.RenderClawMachine;
import pennyarcade.block.render.RenderEmeraldPusher;
import pennyarcade.block.render.RenderMiniCreeper;
import pennyarcade.block.render.RenderMiniEnderman;
import pennyarcade.block.render.RenderMiniPig;
import pennyarcade.block.render.RenderNyanCat;
import pennyarcade.block.render.RenderPennyPusher1;
import pennyarcade.block.render.RenderPennyPusher2;
import pennyarcade.block.render.RenderRubixCube;
import pennyarcade.block.render.model.ModelClawMachine;
import pennyarcade.block.render.model.ModelMiniCreeper;
import pennyarcade.block.render.model.ModelMiniEnderman;
import pennyarcade.block.render.model.ModelMiniPig;
import pennyarcade.block.render.model.ModelNyanCat;
import pennyarcade.block.render.model.ModelPennyPusher1;
import pennyarcade.block.render.model.ModelPennyPusher2;
import pennyarcade.block.render.model.ModelRubixCube;
import pennyarcade.block.tileentity.TileEntityClawMachine;
import pennyarcade.block.tileentity.TileEntityEmeraldPusher;
import pennyarcade.block.tileentity.TileEntityMiniCreeper;
import pennyarcade.block.tileentity.TileEntityMiniEnderman;
import pennyarcade.block.tileentity.TileEntityMiniPig;
import pennyarcade.block.tileentity.TileEntityNyanCat;
import pennyarcade.block.tileentity.TileEntityPennyPusher1;
import pennyarcade.block.tileentity.TileEntityPennyPusher2;
import pennyarcade.block.tileentity.TileEntityRubixCube;
import pennyarcade.event.AchievementManager;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	public void registerRenderers() {

		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PennyArcade.pennyPusher1), new ItemRenderer(new RenderPennyPusher1(), new TileEntityPennyPusher1(), new ModelPennyPusher1()));
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PennyArcade.pennyPusher2), new ItemRenderer(new RenderPennyPusher2(), new TileEntityPennyPusher2(), new ModelPennyPusher2()));
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PennyArcade.pennyPusher3), new ItemRenderer(new RenderEmeraldPusher(), new TileEntityEmeraldPusher(), new ModelPennyPusher1()));
		
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PennyArcade.clawMachine), new ItemRenderer(new RenderClawMachine(), new TileEntityClawMachine(), new ModelClawMachine()));

		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PennyArcade.miniCreeper), new ItemRenderer(new RenderMiniCreeper(), new TileEntityMiniCreeper(), new ModelMiniCreeper()));
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PennyArcade.miniPig), new ItemRenderer(new RenderMiniPig(), new TileEntityMiniPig(), new ModelMiniPig()));
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PennyArcade.miniEnderman), new ItemRenderer(new RenderMiniEnderman(), new TileEntityMiniEnderman(), new ModelMiniEnderman()));

		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PennyArcade.rubixCube), new ItemRenderer(new RenderRubixCube(), new TileEntityRubixCube(), new ModelRubixCube()));
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PennyArcade.nyanCat), new ItemRenderer(new RenderNyanCat(), new TileEntityNyanCat(), new ModelNyanCat()));
		
		/////////

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPennyPusher1.class, new RenderPennyPusher1());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPennyPusher2.class, new RenderPennyPusher2());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEmeraldPusher.class, new RenderEmeraldPusher());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityClawMachine.class, new RenderClawMachine());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiniCreeper.class, new RenderMiniCreeper());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiniPig.class, new RenderMiniPig());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiniEnderman.class, new RenderMiniEnderman());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRubixCube.class, new RenderRubixCube());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNyanCat.class, new RenderNyanCat());
		
		/////////

		
	}
}
