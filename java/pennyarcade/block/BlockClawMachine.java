package pennyarcade.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import pennyarcade.PennyArcade;
import pennyarcade.block.tileentity.TileEntityClawMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockClawMachine extends BlockContainer {
	
	private Random prizeChance = new Random();
	private Random prize = new Random();

	public BlockClawMachine() {
		super(Material.iron);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.setHardness(1.5F);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		
		if (entity == null) {
		return;
		}

		TileEntityClawMachine tile = (TileEntityClawMachine) world.getTileEntity(x, y, z);
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
    		 
    		 if((prizeChance.nextInt(99) + 1) == PennyArcade.clawMachineChance ) {
    			 
    			 int prizeNo = prize.nextInt(4);
    			 
    			 if(prizeNo == 0) {
    				 EntityItem item = par5EntityPlayer.dropItem(Item.getItemFromBlock(PennyArcade.miniCreeper), 1);
    				 item.delayBeforeCanPickup = 0;
    				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "[Claw Machine] " + "Yay! You won a Creeper Toy!")); 
    			 }
    			 if(prizeNo == 1) {
    				 EntityItem item = par5EntityPlayer.dropItem(Item.getItemFromBlock(PennyArcade.miniPig), 1);
    				 item.delayBeforeCanPickup = 0;
    				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "[Claw Machine] " + "Yay! You won a Pig Toy!")); 
    			 }
    			 if(prizeNo == 2) {
    				 EntityItem item = par5EntityPlayer.dropItem(Item.getItemFromBlock(PennyArcade.miniEnderman), 1);
    				 item.delayBeforeCanPickup = 0;
    				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "[Claw Machine] " + "Yay! You won an Enderman Toy!")); 
    			 }
    			 if(prizeNo == 3) {
    				 EntityItem item = par5EntityPlayer.dropItem(Item.getItemFromBlock(PennyArcade.nyanCat), 1);
    				 item.delayBeforeCanPickup = 0;
    				 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "[Claw Machine] " + "Yay! You won a Nyan Cat Toy!")); 
    			 }
    		 }
    		 else {
    			 par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "[Claw Machine] " + "Unlucky! You got nothing!"));  
    		 }
    		 
    		 return true;
    	 }
    	 else {
    		 return false;
    	 }
     }
    
     @SideOnly(Side.CLIENT)
     public void registerBlockIcons(IIconRegister icon) {
         this.blockIcon = icon.registerIcon(PennyArcade.MODID + ":clawMachine");
 }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityClawMachine();
	}

}
