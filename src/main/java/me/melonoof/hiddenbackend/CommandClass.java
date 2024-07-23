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
                plugin.getConfig().set("Debug", !plugin.getConfig().getBoolean("Debug"));
                plugin.saveConfig();
                plugin.reloadConfig();
                commandSender.sendMessage("Debug set to " + plugin.getConfig().getBoolean("Debug"));
                return true;
            }

            if (args[0].equalsIgnoreCase("reload")) {
                plugin.reloadConfig();
                commandSender.sendMessage("Config reloaded");
                return true;
            }


        }

        if (args.length == 0) {
            plugin.getConfig().set("Enabled", !plugin.getConfig().getBoolean("Enabled"));
            plugin.saveConfig();
            plugin.reloadConfig();
            commandSender.sendMessage("Enabled set to " + plugin.getConfig().getBoolean("Enabled"));
            return true;
        }
        return false;
    }
}
