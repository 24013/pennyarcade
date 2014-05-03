package pennyarcade.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
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
import pennyarcade.block.tileentity.TileEntityFruitMachine;

public class BlockFruitMachine extends BlockContainer {
	
	private Random prizeChance = new Random();
	private Random coinReturnAmount = new Random();
	private Random img = new Random();

	public BlockFruitMachine() {
		super(Material.iron);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.setHardness(1.5F);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		
		if (entity == null) {
		return;
		}

		TileEntityFruitMachine tile = (TileEntityFruitMachine) world.getTileEntity(x, y, z);
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
    	 else if(!par1World.isRemote && itemstack.getItem() == PennyArcade.goldCoin) {
    		 
    		 if(!par5EntityPlayer.capabilities.isCreativeMode) itemstack.stackSize = itemstack.stackSize - 1;
    		 
    		 int pic1 = img.nextInt(3);
    		 String img1 = (pic1 == 0 ? "Cherry" : pic1 == 1 ? "Lemon" : pic1 == 2 ? "7" : "Watermelon");
    		 int pic2 = img.nextInt(3);
    		 String img2 = (pic2 == 0 ? "Cherry" : pic2 == 1 ? "Lemon" : pic2 == 2 ? "7" : "Watermelon");
    		 int pic3 = img.nextInt(3);
    		 String img3 = (pic3 == 0 ? "Cherry" : pic3 == 1 ? "Lemon" : pic3 == 2 ? "7" : "Watermelon");
    		 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "[Fruit Machine] You got a " + img1 + ", " + img2 + " and " + img3 + "!"));
    		 
    		 if(pic1 == pic2 && pic2 == pic3) {
    			 Random pitch = new Random();
    			 par1World.playSoundAtEntity(par5EntityPlayer, "pennyarcade:pennyarcade.coindrop", 10.0F, (pitch.nextFloat() - pitch.nextFloat()) * 0.2F + 1.0F);
        		
    			 int prize = prizeChance.nextInt(100);
    			 
    			 if(prize <= 55) {
        			 int coinAmount = (pic1 + 1) * 5;
            		 EntityItem item = par5EntityPlayer.dropItem(PennyArcade.goldCoin, coinAmount);
            		 item.delayBeforeCanPickup = 0;
            		 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "[Fruit Machine] " + "Yay! You won " + coinAmount + " coins!"));
    			 }
    			 if(prize > 55 && prize <= 70) { 
        				 EntityItem item = par5EntityPlayer.dropItem(Items.diamond, 1);
        				 item.delayBeforeCanPickup = 0;
        				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "[Fruit Machine] " + "Yay! You won a diamond!")); 
    			 }
    			 if(prize > 70 && prize <= 85) { 
        				 EntityItem item = par5EntityPlayer.dropItem(Items.emerald, 1);
        				 item.delayBeforeCanPickup = 0;
        				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "[Fruit Machine] " + "Yay! You won an emerald!")); 
    			 }
    			 if(prize > 85) { 
        				 EntityItem item = par5EntityPlayer.dropItem(PennyArcade.emeraldToken, 1);
        				 item.delayBeforeCanPickup = 0;
        				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "[Fruit Machine] " + "Yay! You won an emerald token!")); 
        			 
    			 }
    		 }
    		 else {
				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "[Fruit Machine] " + "Unlucky! You got nothing!"));
    	 }
    		 return true;
    	 }
    	 else {
    		 return false;
    	 }
     }
     
     public void registerBlockIcons(IIconRegister icon) {
         this.blockIcon = icon.registerIcon(PennyArcade.MODID + ":fruitMachine");
 }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityFruitMachine();
	}

}
