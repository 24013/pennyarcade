package pennyarcade.event;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import pennyarcade.PennyArcade;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class AchievementManager {
	
	@SubscribeEvent
	public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		
		if(event.crafting.getItem() == PennyArcade.goldCoin) {
			event.player.addStat(PennyArcade.achievementGoldCoins, 1);
		}
		
		if(Block.getBlockFromItem(event.crafting.getItem()) == PennyArcade.pennyPusher1 || Block.getBlockFromItem(event.crafting.getItem()) == PennyArcade.pennyPusher2) {
			event.player.addStat(PennyArcade.achievementPennyPusher, 1);
		}
		
		if(Block.getBlockFromItem(event.crafting.getItem()) == PennyArcade.pennyPusher3) {
			event.player.addStat(PennyArcade.achievementEmeraldPusher, 1);
		}
		if(Block.getBlockFromItem(event.crafting.getItem()) == PennyArcade.clawMachine) {
			event.player.addStat(PennyArcade.achievementClawMachine, 1);
		}
	}
	
	@SubscribeEvent
	public void onItemPickedUp(PlayerEvent.ItemPickupEvent event) {
		
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(PennyArcade.goldCoin))) {
			event.player.addStat(PennyArcade.achievementGoldCoins, 1);
		}
		
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(PennyArcade.emeraldToken))) {
			event.player.addStat(PennyArcade.achievementEmeraldToken, 1);
		}
		
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(PennyArcade.nyanCat))) {
			event.player.addStat(PennyArcade.achievementNyanCat, 1);
		}
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(PennyArcade.stephano))) {
			event.player.addStat(PennyArcade.achievementStephano, 1);
		}
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(PennyArcade.playerHerobrine))) {
			event.player.addStat(PennyArcade.achievementHerobrine, 1);
		}

	}
}
