package pennyarcade.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import pennyarcade.PennyArcade;
import pennyarcade.block.tileentity.TileEntityPennyPusher1;
import pennyarcade.block.tileentity.TileEntityPennyPusher2;

public class BlockPennyPusher2 extends BlockContainer {
	
	private Random prizeChance = new Random();
	private Random prize = new Random();
	private Random coinReturnPercentage = new Random();
	private Random coinReturnAmount = new Random();

	public BlockPennyPusher2() {
		super(Material.iron);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.setHardness(1.5F);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		if (entity == null) {
		return;
		}

		TileEntityPennyPusher2 tile = (TileEntityPennyPusher2) world.getTileEntity(x, y, z);
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
    	 ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
    	 
    	 if(itemstack == null) {
    		 return false;
    	 }
    	 else if(!par1World.isRemote && itemstack.getItem() == PennyArcade.goldCoin) {
    		 
    		 if(!par5EntityPlayer.capabilities.isCreativeMode) itemstack.stackSize = itemstack.stackSize - 1;
    		 if(coinReturnPercentage.nextInt(100) <= PennyArcade.coinChance + 1) {
    			 
    			 Random pitch = new Random();
    			 par1World.playSoundAtEntity(par5EntityPlayer, "pennyarcade:pennyarcade.coindrop", 10.0F, (pitch.nextFloat() - pitch.nextFloat()) * 0.2F + 1.0F);
        		 int coinAmount = coinReturnAmount.nextInt(PennyArcade.maxCoinAmount);
        		 if(coinAmount == 0) coinAmount = 1;
        		 par5EntityPlayer.dropItem(PennyArcade.goldCoin, coinAmount);
        		 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[Penny Pusher] " + "Yay! You won " + coinAmount + " coins!"));
        		 
        		 if(prizeChance.nextInt(100) <= PennyArcade.prizeChance + 1) {
        			 
        			 int wonPrize = prize.nextInt(100);
        			 
        			 if(wonPrize <= 50) { 
        				 int x = PennyArcade.maxCoinAmount * (coinReturnAmount.nextInt(3) + 1);
        				 EntityItem item = par5EntityPlayer.dropItem(PennyArcade.goldCoin, x);
        				 item.delayBeforeCanPickup = 0;
        				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[Penny Pusher] " + "Bonus Prize! You get " + x + " coins!"));
        			 }
        			 if(wonPrize > 50 && wonPrize <= 65) { 
        				 EntityItem item = par5EntityPlayer.dropItem(Items.diamond, 1);
        				 item.delayBeforeCanPickup = 0;
        				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[Penny Pusher] " + "Bonus Prize! You get a diamond!")); 
        			 }
        			 if(wonPrize > 65 && wonPrize <= 80) { 
        				 EntityItem item = par5EntityPlayer.dropItem(Items.emerald, 1);
        				 item.delayBeforeCanPickup = 0;
        				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[Penny Pusher] " + "Bonus Prize! You get an emerald!")); 
        			 }
        			 if(wonPrize > 80) { 
        				 EntityItem item = par5EntityPlayer.dropItem(PennyArcade.emeraldToken, 3);
        				 item.delayBeforeCanPickup = 0;
        				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[Penny Pusher] " + "Bonus Prize! You get 3 Emerald Tokens!")); 
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
     
     @SideOnly(Side.CLIENT)
     public void registerBlockIcons(IIconRegister icon) {
         this.blockIcon = icon.registerIcon(PennyArcade.MODID + ":pennyPusher2");
 }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityPennyPusher2();
	}

}
