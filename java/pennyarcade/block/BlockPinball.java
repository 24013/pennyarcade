package pennyarcade.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import pennyarcade.PennyArcade;
import pennyarcade.block.tileentity.TileEntityPinball;

public class BlockPinball extends BlockContainer {

	private int goNumber;
	
	private Random go;
	
	private int go1;
	private int go2;
	private int go3;
	private int total;
	
	public BlockPinball() {
		super(Material.iron);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);
		this.setHardness(1.5F);
		this.go = new Random();
		this.goNumber = 1;
		this.go1 = 0;
		this.go2 = 0;
		this.go3 = 0;
		this.total = 0;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		
		if (entity == null) {
		return;
		}

		TileEntityPinball tile = (TileEntityPinball) world.getTileEntity(x, y, z);
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
    				if(!par5EntityPlayer.capabilities.isCreativeMode)itemstack.stackSize--;
    				this.go1 = go.nextInt(2000);
    				par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "[Pinball Machine] You scored " + this.go1 + " points on your first go!"));
    				this.go2 = go.nextInt(2000);
    				par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "[Pinball Machine] You scored " + this.go2 + " points on your second go!"));
    				this.go3 = go.nextInt(2000);
    				par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "[Pinball Machine] You scored " + this.go3 + " points on your third go!"));
    				this.total = (this.go1 + this.go2 + this.go3);
    				par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "[Pinball Machine] You scored a total of " + this.total + " points!"));
    				
    				if(total < 3000) {
    					par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Unlucky! You don't win anything!"));
    				}
    				else if(total >= 3000 && total < 4500) {
    					par5EntityPlayer.dropItem(PennyArcade.goldCoin, 1);
    					par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Congratulations! You won a gold coin!"));
    				}
    				else if(total >= 4500 && total < 5000) {
    					par5EntityPlayer.dropItem(PennyArcade.emeraldToken, 1);
    					par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Congratulations! You won an emerald token!"));
    				}
    				else if(total >= 5000 && total < 5500) {
    					par5EntityPlayer.dropItem(Items.emerald, 1);
    					par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Congratulations! You won an emerald!"));
    				}
    				else if(total >= 5500 && total < 6000) {
    					par5EntityPlayer.dropItem(Items.diamond, 1);
    					par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Congratulations! You won a diamond!"));
    				}
    				else if(total == 6000) {
    					par5EntityPlayer.dropItem(Item.getItemFromBlock(Blocks.diamond_block), 1);
    					par5EntityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Max Score! Diamond Block!"));
    				}
    			}
    	 else {
    		 return false;
    	 }
		return true;
     }
     
     public void registerBlockIcons(IIconRegister icon) {
         this.blockIcon = icon.registerIcon(PennyArcade.MODID + ":pinball");
 }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityPinball();
	}

}
