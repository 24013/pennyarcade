package pennyarcade.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import pennyarcade.PennyArcade;
import pennyarcade.block.tileentity.TileEntityEmeraldPusher;
import pennyarcade.block.tileentity.TileEntityPennyPusher1;

public class BlockEmeraldPusher extends BlockContainer {
	
	private Random prizeChance = new Random();
	private Random prize = new Random();
	private Random coinReturnPercentage = new Random();
	private Random coinReturnAmount = new Random();

	public BlockEmeraldPusher(int id) {
		super(Material.iron);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.setHardness(1.5F);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		if (entity == null) {
		return;
		}

		TileEntityEmeraldPusher tile = (TileEntityEmeraldPusher) world.getTileEntity(x, y, z);
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
     
     public void onBlockPlacedBy() {
    	 
     }
     
     public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
     {
    	 ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
    	 
    	 if(itemstack == null) {
    		 return false;
    	 }
    	 else if(!par1World.isRemote && itemstack.getItem() == PennyArcade.emeraldToken) {
    		 
    		 if(!par5EntityPlayer.capabilities.isCreativeMode) itemstack.stackSize = itemstack.stackSize - 1;
    		 if(coinReturnPercentage.nextInt(100) <= PennyArcade.coinChance + 1) {
    			 
        		 int coinAmount = coinReturnAmount.nextInt(PennyArcade.maxCoinAmount);
        		 if(coinAmount == 0) coinAmount = 1;
        		 par5EntityPlayer.dropItem(PennyArcade.emeraldToken, coinAmount);
        		 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[Emerald Pusher] " + "Yay! You won " + coinAmount + " Emerald Tokens!"));
        		 
        		 if(prizeChance.nextInt(100) <= PennyArcade.prizeChance + 1) {
        			 int wonPrize = prize.nextInt(2);
        			 
        			 if(wonPrize == 0) { 
        				 par5EntityPlayer.dropItem(PennyArcade.emeraldToken, PennyArcade.maxCoinAmount);
        				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[Emerald Pusher] " + "Bonus Prize! You get 4 Emerald Tokens!")); 
        			 }
        			 if(wonPrize == 1) { 
        				 par5EntityPlayer.dropItem(Item.getItemFromBlock(Blocks.diamond_block), 1);
        				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[Emerald Pusher] " + "Bonus Prize! You get a diamond block!")); 
        			 }
        			 if(wonPrize == 2) { 
        				 par5EntityPlayer.dropItem(Item.getItemFromBlock(Blocks.emerald_block), 1);
        				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[Emerald Pusher] " + "Bonus Prize! You get an emerald block!")); 
        			 }
        		 }
        	 }
        	 else {
        		 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[Emerald Pusher] " + "Unlucky! You got nothing!"));
        	 }
    		 
    		 return true;
    	 }
    	 else {
    		 return false;
    	 }
     }
     
     public void registerBlockIcons(IIconRegister icon) {
         this.blockIcon = icon.registerIcon(PennyArcade.MODID + ":pennyArcade");
 }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityEmeraldPusher();
	}

}
