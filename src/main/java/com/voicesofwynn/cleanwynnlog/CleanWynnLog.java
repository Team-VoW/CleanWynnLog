package com.voicesofwynn.cleanwynnlog;

import com.voicesofwynn.cleanwynnlog.NeatLog.NeatLogger;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = CleanWynnLog.MOD_ID,
        name = CleanWynnLog.MOD_NAME,
        version = CleanWynnLog.VERSION
)
public class CleanWynnLog {

    public static final String MOD_ID = "cleanwynnlog";
    public static final String MOD_NAME = "CleanWynnLog";
    public static final String VERSION = "1.0";

    public static NeatLogger neatLogger;

    /** This is the instance of your mod as created by Forge. It will never be null. */
    @Mod.Instance(MOD_ID)
    public static CleanWynnLog INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        neatLogger = new NeatLogger();
        INSTANCE = this;
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }


}
