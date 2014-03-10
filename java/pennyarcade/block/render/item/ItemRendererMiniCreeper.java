package pennyarcade.block.render.item;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import pennyarcade.block.render.model.ModelMiniCreeper;
import pennyarcade.block.tileentity.TileEntityMiniCreeper;

public class ItemRendererMiniCreeper implements IItemRenderer {

	private ModelMiniCreeper model;
	private TileEntity entity;
	private TileEntitySpecialRenderer renderer;
	
	public ItemRendererMiniCreeper(TileEntitySpecialRenderer renderer, TileEntity te) {
		model = new ModelMiniCreeper();
		this.entity = te;
		this.renderer = renderer;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {	
		renderer.renderTileEntityAt(entity, 0.0D, 0.0D, 0.0D, 0.0F);
	}

}
