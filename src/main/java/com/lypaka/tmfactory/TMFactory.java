package com.lypaka.tmfactory;

import com.google.inject.Inject;
import com.lypaka.tmfactory.Commands.AdminCommands;
import com.lypaka.tmfactory.Config.ConfigManager;
import com.lypaka.tmfactory.Utils.ItemHandler;
import net.minecraftforge.common.MinecraftForge;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

import java.nio.file.Path;

@Plugin(
        id = TMFactory.MOD_ID,
        name = TMFactory.MOD_NAME,
        version = TMFactory.VERSION
)
public class TMFactory {

    public static final String MOD_ID = "tmfactory";
    public static final String MOD_NAME = "TM-Factory";
    public static final String VERSION = "1.0-SNAPSHOT";


    @Inject
    @ConfigDir(sharedRoot = false)
    private Path dir;

    @Inject
    public Logger logger;

    @Inject
    private PluginContainer container;

    public static TMFactory instance;

    @Listener
    public void onPreInit (GamePreInitializationEvent event) {

        logger.info("Firing up the factory...!");
        instance = this;
        ConfigManager.setup(dir);
        AdminCommands.registerCommand();
        Sponge.getEventManager().registerListeners(this, new ItemHandler());
        MinecraftForge.EVENT_BUS.register(new ItemHandler());

    }

    public static PluginContainer getContainer() {
        return instance.container;
    }

    public static Logger getLogger() {
        return instance.logger;
    }

}
