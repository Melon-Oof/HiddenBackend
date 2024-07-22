package me.melonoof.hiddenbackend;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private final HiddenBackend plugin;




    public JoinListener(HiddenBackend plugin) {
        this.plugin = plugin;
    }



    @EventHandler
    public void JoinEvent(PlayerJoinEvent e) {
        Bukkit.getScheduler().runTaskAsynchronously (new HiddenBackend(), () -> {
            if (plugin.getConfig().getBoolean("enabled")) {
                e.getPlayer().kickPlayer("Unknown host");
            }
        });
        Bukkit.getScheduler().runTaskAsynchronously (new HiddenBackend(), () -> {
            switch (plugin.getConfig().getString("debug")) {
                case "high":
                    plugin.logger.info("Player " + e.getPlayer().getName() + " joined the server");
                    break;

                case "medium":
                    plugin.logger.info("Player " + e.getPlayer().getName() + " joined the server");
                    break;

                case "low":
                    plugin.logger.info("Player " + e.getPlayer().getName() + " joined the server");
                    break;
                case "none":
                default:
                    break;
            }
        });
    }





}
