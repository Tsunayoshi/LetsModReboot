package net.schuby.letsmodreboot.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import net.schuby.letsmodreboot.reference.Reference;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;
    boolean testValue = false;

    public static void init(File configFile)
    {
        //Create the configuration object from the given configuration file
        if (configuration ==null)
        {
            configuration = new Configuration(configFile);
        }

    }

    @SubscribeEvent
    public void onConfigurationOnChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            //Resync configs
            loadConfiguration();
            //GUI FACTORY HIER GEHTS WEITER

        }
    }

    public void loadConfiguration()
    {
        testValue = configuration.getBoolean("configValue", configuration.CATEGORY_GENERAL, false, "Beispieltext");

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
}
