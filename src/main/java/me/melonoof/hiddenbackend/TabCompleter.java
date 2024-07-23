package me.melonoof.hiddenbackend;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.util.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabCompleter implements org.bukkit.command.TabCompleter {


    public TabCompleter(HiddenBackend hiddenBackend) {
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {


        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("debug", "disable", "enable", "reload"), new ArrayList<>());
        }
        return null;
    }
}
