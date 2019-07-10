package net.cuplex.customposter;

import java.util.ArrayList;
import java.util.List;

public class CustomposterConfig
{
    public static class ModConfig
    {
        public List<CompostableItem> compostableItemList = new ArrayList<>();
    }

    public static class CompostableItem
    {
        public String item;
        public float chance;
    }

    public static ModConfig getDefaultConfig()
    {
        ModConfig modConfig = new ModConfig();
        CompostableItem compostableItem = new CompostableItem();
        compostableItem.item = "minecraft:bamboo";
        compostableItem.chance = 0.2f;
        modConfig.compostableItemList.add(compostableItem);

        return modConfig;
    }
}
