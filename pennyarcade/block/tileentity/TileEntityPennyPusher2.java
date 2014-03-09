package pennyarcade.block.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileEntityPennyPusher2 extends TileEntity {
	public int direction;
	
	/**
	public Packet getDescriptionPacket() {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
        }

        public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
        	
        }
        
        public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        	par1NBTTagCompound.setInteger("direction", direction);
        }
        
        public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        	this.direction = par1NBTTagCompound.getInteger("direction");
        }
        */
}
