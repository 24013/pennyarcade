package pennyarcade.block.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMiniCreeper extends TileEntity {
	
	public int direction;
	
        public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        	par1NBTTagCompound.setInteger("direction", direction);
        }
        
        public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        	this.direction = par1NBTTagCompound.getInteger("direction");
        }
}
