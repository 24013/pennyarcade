package pennyarcade.entity.villager;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import pennyarcade.PennyArcade;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class VillagerTradeHandler implements IVillageTradeHandler {

	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
		
		recipeList.add(new MerchantRecipe(new ItemStack(PennyArcade.goldCoin, 25), null, new ItemStack(Items.emerald, 1)));
		recipeList.add(new MerchantRecipe(new ItemStack(PennyArcade.goldCoin, 25), null, new ItemStack(Items.diamond, 1)));
		
		recipeList.add(new MerchantRecipe(new ItemStack(PennyArcade.goldCoin, 25), new ItemStack(Items.emerald, 1), new ItemStack(PennyArcade.emeraldToken, 1)));
		
		recipeList.add(new MerchantRecipe(new ItemStack(PennyArcade.emeraldToken, 3), null, new ItemStack(PennyArcade.miniCreeper, 1)));
		recipeList.add(new MerchantRecipe(new ItemStack(PennyArcade.emeraldToken, 3), null, new ItemStack(PennyArcade.miniPig, 1)));
		recipeList.add(new MerchantRecipe(new ItemStack(PennyArcade.emeraldToken, 3), null, new ItemStack(PennyArcade.miniEnderman, 1)));
		
		recipeList.add(new MerchantRecipe(new ItemStack(PennyArcade.emeraldToken, 2), null, new ItemStack(PennyArcade.rubixCube, 1)));
	}

}
