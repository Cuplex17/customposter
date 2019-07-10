package net.cuplex.customposter;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Customposter implements ModInitializer
{
	public static CustomposterConfigLoader customposterConfigLoader;

	@Override
	public void onInitialize()
	{
		System.out.println("Composter says hello.");

		customposterConfigLoader = new CustomposterConfigLoader();
		customposterConfigLoader.loadConfig();
		for(CustomposterConfig.CompostableItem compostableItem : customposterConfigLoader.getCompostableItems())
		{
			ItemConvertible item = Registry.ITEM.get(new Identifier(compostableItem.item));
			float chance = compostableItem.chance;
			CompostingChanceRegistry.INSTANCE.add(item, chance);
		}
	}
}
