package pennyarcade.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import pennyarcade.PennyArcade;
import pennyarcade.block.tileentity.TileEntityMiniCreeper;

public class BlockMiniCreeper extends BlockContainer {

	public BlockMiniCreeper(int par1) {
		super(Material.ground);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int var2) {
		return new TileEntityMiniCreeper();
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase entity, ItemStack stack) {
		if (entity == null) {
			return;
		}

		TileEntityMiniCreeper tile = (TileEntityMiniCreeper) world
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

		Random rand = new Random();
		par1World.playSoundAtEntity(par5EntityPlayer, "mob.creeper.say", 1.0F,
				(rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
		return true;
	}

	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon(PennyArcade.MODID + ":miniCreeper");
	}

}
