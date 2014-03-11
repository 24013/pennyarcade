package pennyarcade.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import pennyarcade.PennyArcade;
import pennyarcade.block.render.RenderRubixCube;
import pennyarcade.block.tileentity.TileEntityRubixCube;

public class BlockRubixCube extends BlockContainer {

	
	private Random rand = new Random();
	
	public BlockRubixCube(int par1) {
		super(Material.ground);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		System.out.println("Rubix Cube Block Initialized");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int var2) {
		return new TileEntityRubixCube();
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase entity, ItemStack stack) {
		if (entity == null) {
			return;
		}

		TileEntityRubixCube tile = (TileEntityRubixCube) world
				.getTileEntity(x, y, z);
		tile.direction = MathHelper
				.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
			EntityLiving par5EntityLiving, ItemStack par6ItemStack) {

	}

	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		return false;
	}

	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon(PennyArcade.MODID + ":rubixCube");
	}

}
