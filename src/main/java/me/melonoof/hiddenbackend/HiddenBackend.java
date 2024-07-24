package me.melonoof.hiddenbackend;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class HiddenBackend extends JavaPlugin {

    Logger logger = getLogger();


    @Override
    public void onEnable() {
        // Plugin startup logic

        int pluginId = 22758;
        Metrics metrics = new Metrics(this, pluginId);

        getServer().getPluginManager().registerEvents(new PingListener(this), this);
        getCommand("hiddenbackend").setExecutor(new CommandClass(this));
        getCommand("hiddenbackend").setTabCompleter(new TabCompleter(this));


        logger.info("Version: " + getDescription().getVersion() + " Enabled");
        logger.info("Author:" + getDescription().getAuthors());


        try {
            Class.forName("com.destroystokyo.paper.ParticleBuilder");
        } catch (ClassNotFoundException e) {
            logger.severe("============= PAPER NOT DETECTED =============");
            logger.severe("HiddenBackend requires Paper to run");
            logger.severe("Download PaperMC here: https://papermc.io/software/paper");
            logger.severe("============= PAPER NOT DETECTED =============");
            getPluginLoader().disablePlugin(this);
        }

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
        saveConfig();
    }
}
