package pennyarcade;

import pennyarcade.block.render.RenderClawMachine;
import pennyarcade.block.render.RenderEmeraldPusher;
import pennyarcade.block.render.RenderMiniCreeper;
import pennyarcade.block.render.RenderMiniEnderman;
import pennyarcade.block.render.RenderMiniPig;
import pennyarcade.block.render.RenderNyanCat;
import pennyarcade.block.render.RenderPennyPusher1;
import pennyarcade.block.render.RenderPennyPusher2;
import pennyarcade.block.render.RenderPinball;
import pennyarcade.block.render.RenderRubixCube;
import pennyarcade.block.render.RenderStephano;
import pennyarcade.block.render.player.RenderHerobrine;
import pennyarcade.block.tileentity.TileEntityClawMachine;
import pennyarcade.block.tileentity.TileEntityEmeraldPusher;
import pennyarcade.block.tileentity.TileEntityMiniCreeper;
import pennyarcade.block.tileentity.TileEntityMiniEnderman;
import pennyarcade.block.tileentity.TileEntityMiniPig;
import pennyarcade.block.tileentity.TileEntityNyanCat;
import pennyarcade.block.tileentity.TileEntityPennyPusher1;
import pennyarcade.block.tileentity.TileEntityPennyPusher2;
import pennyarcade.block.tileentity.TileEntityPinball;
import pennyarcade.block.tileentity.TileEntityRubixCube;
import pennyarcade.block.tileentity.TileEntityStephano;
import pennyarcade.block.tileentity.player.TileEntityHerobrine;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	public void registerRenderers() {
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPennyPusher1.class, new RenderPennyPusher1());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPennyPusher2.class, new RenderPennyPusher2());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEmeraldPusher.class, new RenderEmeraldPusher());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityClawMachine.class, new RenderClawMachine());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPinball.class, new RenderPinball());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiniCreeper.class, new RenderMiniCreeper());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiniPig.class, new RenderMiniPig());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiniEnderman.class, new RenderMiniEnderman());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRubixCube.class, new RenderRubixCube());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNyanCat.class, new RenderNyanCat());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStephano.class, new RenderStephano());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHerobrine.class, new RenderHerobrine());	
	}
}
