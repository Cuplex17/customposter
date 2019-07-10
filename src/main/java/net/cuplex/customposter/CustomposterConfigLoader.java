package net.cuplex.customposter;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;

public class CustomposterConfigLoader
{
    private static Logger logger = LogManager.getLogger();
    private String jsonLocation = FabricLoader.getInstance().getConfigDirectory().getPath() + "/Customposter.json";
    private File configFile = new File(jsonLocation);
    public CustomposterConfig.ModConfig config = new CustomposterConfig.ModConfig();

    private JsonObject configObject;

    public void loadConfig()
    {
        try
        {
            FileReader fileReader = new FileReader(configFile);
            config = new GsonBuilder().create().fromJson(fileReader, CustomposterConfig.ModConfig.class);
        }
        catch (FileNotFoundException e)
        {
            buildFile();
        }
    }

    public void buildFile()
    {
        try
        {
            FileWriter fileWriter = new FileWriter(jsonLocation);
            new GsonBuilder().setPrettyPrinting().create().toJson(CustomposterConfig.getDefaultConfig(), CustomposterConfig.ModConfig.class, fileWriter);
            fileWriter.flush();
        }
        catch(IOException e)
        {
            logger.fatal("Config IO Error", e);
        }
    }

    public List<CustomposterConfig.CompostableItem> getCompostableItems()
    {
        return config.compostableItemList;
    }
}
