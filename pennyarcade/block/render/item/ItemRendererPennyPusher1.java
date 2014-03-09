package pennyarcade.block.render.item;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import pennyarcade.block.render.model.ModelPennyPusher1;
import pennyarcade.block.tileentity.TileEntityPennyPusher1;

public class ItemRendererPennyPusher1 implements IItemRenderer {
	
	private ModelPennyPusher1 model;
	private TileEntity entity;
	private TileEntitySpecialRenderer renderer;
	
	public ItemRendererPennyPusher1(TileEntitySpecialRenderer renderer, TileEntity te) {
		this.model = new ModelPennyPusher1();
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
