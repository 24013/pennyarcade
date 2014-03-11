package pennyarcade.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import pennyarcade.PennyArcade;
import pennyarcade.block.tileentity.TileEntityPennyPusher1;

public class BlockPennyPusher1 extends BlockContainer {
	
	private Random prizeChance = new Random();
	private Random prize = new Random();
	private Random coinReturnPercentage = new Random();
	private Random coinReturnAmount = new Random();

	public BlockPennyPusher1(int id) {
		super(Material.iron);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		if (entity == null) {
		return;
		}

		TileEntityPennyPusher1 tile = (TileEntityPennyPusher1) world.getTileEntity(x, y, z);
		tile.direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
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
    	 else if(!par1World.isRemote && itemstack.getItem() == PennyArcade.goldCoin) {
    		 
    		 if(!par5EntityPlayer.capabilities.isCreativeMode) itemstack.stackSize = itemstack.stackSize - 1;
    		 if(coinReturnPercentage.nextInt(100) <= PennyArcade.coinChance + 1) {
    			 
        		 int coinAmount = coinReturnAmount.nextInt(PennyArcade.maxCoinAmount);
        		 if(coinAmount == 0) coinAmount = 1;
        		 par5EntityPlayer.dropItem(PennyArcade.goldCoin, coinAmount);
        		 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[Penny Pusher] " + "Yay! You won " + coinAmount + " coins!"));
        		 
        		 if(prizeChance.nextInt(100) <= PennyArcade.prizeChance + 1) {
        			 int wonPrize = prize.nextInt(3);
        			 
        			 if(wonPrize == 0) { 
        				 par5EntityPlayer.dropItem(PennyArcade.goldCoin, PennyArcade.maxCoinAmount);
        				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[Penny Pusher] " + "Bonus Prize! You get 4 coins!")); 
        			 }
        			 if(wonPrize == 1) { 
        				 par5EntityPlayer.dropItem(Items.diamond, 1);
        				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[Penny Pusher] " + "Bonus Prize! You get a diamond!")); 
        			 }
        			 if(wonPrize == 2) { 
        				 par5EntityPlayer.dropItem(Items.emerald, 1);
        				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[Penny Pusher] " + "Bonus Prize! You get an emerald!")); 
        			 }
        			 if(wonPrize == 3) { 
        				 par5EntityPlayer.dropItem(PennyArcade.emeraldToken, 1);
        				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[Penny Pusher] " + "Bonus Prize! You get an emerald token!")); 
        			 }
        		 }
        	 }
        	 else {
        		 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[Penny Pusher] " + "Unlucky! You got nothing!"));
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
		return new TileEntityPennyPusher1();
	}

}
