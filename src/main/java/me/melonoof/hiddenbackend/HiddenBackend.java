package me.melonoof.hiddenbackend;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class HiddenBackend extends JavaPlugin {

    Logger logger = getLogger();
    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(new PingListener(this), this);
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);


        logger.info(" _    _ _     _               ____            _               _ ");
        logger.info("| |  | (_)   | |             |  _ \\\\          | |             | |");
        logger.info("| |__| |_  __| | ___  _ __   | |_) | __ _  __| | ___  _ __   | |");
        logger.info("|  __  | |/ _` |/ _ \\\\| '_ \\\\  |  _ < / _` |/ _` |/ _ \\\\| '_ \\\\  | |");
        logger.info("| |  | | | (_| | (_) | | | | | |_) | (_| | (_| | (_) | | | | |_|");
        logger.info("|_|  |_|_|\\\\__,_|\\\\___/|_| |_| |____/ \\\\__,_|\\\\__,_|\\\\___/|_| |_| (_)");
        logger.info("");
        logger.info("Version:" + getDescription().getVersion() + "Enabled");
        logger.info("Author:" + getDescription().getAuthors());

        saveDefaultConfig();
        saveConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        logger.info(" _    _ _     _               ____            _               _ ");
        logger.info("| |  | (_)   | |             |  _ \\\\          | |             | |");
        logger.info("| |__| |_  __| | ___  _ __   | |_) | __ _  __| | ___  _ __   | |");
        logger.info("|  __  | |/ _` |/ _ \\\\| '_ \\\\  |  _ < / _` |/ _` |/ _ \\\\| '_ \\\\  | |");
        logger.info("| |  | | | (_| | (_) | | | | | |_) | (_| | (_| | (_) | | | | |_|");
        logger.info("|_|  |_|_|\\\\__,_|\\\\___/|_| |_| |____/ \\\\__,_|\\\\__,_|\\\\___/|_| |_| (_)");
        logger.info("");
        logger.info("Version:" + getDescription().getVersion() + "Enabled");
        logger.info("Author:" + getDescription().getAuthors());
    }
}
