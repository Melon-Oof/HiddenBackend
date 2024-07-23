package me.melonoof.hiddenbackend;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class HiddenBackend extends JavaPlugin {

    Logger logger = getLogger();
    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(new PingListener(this), this);
        getCommand("hiddenbackend").setExecutor(new CommandClass(this));
        getCommand("hiddenbackend").setTabCompleter(new TabCompleter(this));


        logger.info("HiddenBackend loading...");
        logger.info("");
        logger.info("Version: " + getDescription().getVersion() + " Enabled");
        logger.info("Author:" + getDescription().getAuthors());


        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        logger.info("HiddenBackend unloading...");
        logger.info("");
        logger.info("Version: " + getDescription().getVersion() + " Disabled");
        logger.info("Author: " + getDescription().getAuthors());
    }
}
