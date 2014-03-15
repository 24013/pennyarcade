package pennyarcade.block.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderer implements IItemRenderer {
	
	private ModelBase model;
	private TileEntity entity;
	private TileEntitySpecialRenderer renderer;
	
	public ItemRenderer(TileEntitySpecialRenderer renderer, TileEntity te, ModelBase model) {
		this.model = model;
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
