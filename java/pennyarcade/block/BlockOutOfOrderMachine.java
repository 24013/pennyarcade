package pennyarcade.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import pennyarcade.PennyArcade;
import pennyarcade.block.tileentity.TileEntityOutOfOrderMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOutOfOrderMachine extends BlockContainer {

	public BlockOutOfOrderMachine() {
		super(Material.iron);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.setHardness(1.5F);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		if (entity == null) {
		return;
		}

		TileEntityOutOfOrderMachine tile = (TileEntityOutOfOrderMachine) world.getTileEntity(x, y, z);
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
		
		if(!this.canBlockStay(world, x, y, z)) {
			
			world.setBlock(x, y, z, this);
			
		}
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
     
     public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
     {
    	 if(!par1World.isRemote) {
    	 ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
    	 
    	 if(itemstack == null || itemstack.getItem() != PennyArcade.goldCoin) {
    		 par5EntityPlayer.addChatComponentMessage(new ChatComponentText("[Penny Pusher] We're terribly sorry, but this machine is out of order. Do not try and insert coins, or bad things will happen. Thanks for your cooperation"));
    		 return false;
    	 }
    	 else if(itemstack.getItem() == PennyArcade.goldCoin) {
    		 if(!par5EntityPlayer.capabilities.isCreativeMode) itemstack.stackSize = itemstack.stackSize - 1;
    		 EntityPlayer p = par5EntityPlayer;
    		 
    		 par1World.createExplosion(p, p.posX, p.posY, p.posZ, 5, true);
    	 }
    	 else {
    		 return false;
    	 }
    	 }
    	 return false;
     }
     
     @SideOnly(Side.CLIENT)
     public void registerBlockIcons(IIconRegister icon) {
         this.blockIcon = icon.registerIcon(PennyArcade.MODID + ":pennyPusher1");
 }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityOutOfOrderMachine();
	}

}
