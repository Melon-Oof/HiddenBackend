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
            if (args[0].equalsIgnoreCase("reload")) {
                plugin.reloadConfig();
                commandSender.sendMessage("Config reloaded");
                return true;
            }

            if (args[0].equalsIgnoreCase("enable")) {
                plugin.getConfig().set("Enabled", true);
                plugin.saveConfig();
                plugin.reloadConfig();
                commandSender.sendMessage("Enabled");
                return true;
            }

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


            if (args[0].equalsIgnoreCase("disable")) {
                plugin.getConfig().set("Enabled", false);
                plugin.saveConfig();
                plugin.reloadConfig();
                commandSender.sendMessage("Disabled");
                return true;
            }


        }
        return false;
    }
}
