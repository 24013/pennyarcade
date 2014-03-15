package pennyarcade.block.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityClawMachine extends TileEntity {
	public int direction;
	public NBTTagCompound par1NBTTagCompound;
        
        public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        	this.par1NBTTagCompound.setInteger("direction", direction);
        }
        
        public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        	this.direction = this.par1NBTTagCompound.getInteger("direction");
        }
}
