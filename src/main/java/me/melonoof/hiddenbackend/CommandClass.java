package me.melonoof.hiddenbackend;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandClass implements CommandExecutor {


    private final HiddenBackend plugin;

    public CommandClass(HiddenBackend plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {


        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("debug")) {
                if (plugin.getConfig().getBoolean("debug")) {

                    plugin.getConfig().set("debug", false);
                    plugin.saveConfig();
                    plugin.reloadConfig();
                    commandSender.sendMessage("Debug set to false");
                    return true;

                } else if (!plugin.getConfig().getBoolean("debug")) {
                    plugin.getConfig().set("debug", true);
                    plugin.saveConfig();
                    plugin.reloadConfig();
                    commandSender.sendMessage("Debug set to true");
                    return true;
                } else {
                    plugin.logger.info("Invalid value for debug in config.ym");
                    return false;
                }

            }


        }
        return false;
    }
}
