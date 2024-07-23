package me.melonoof.hiddenbackend;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PingListener implements Listener {



    private final HiddenBackend plugin;



    public PingListener(HiddenBackend plugin) {
        this.plugin = plugin;
    }



    @EventHandler
    public void PingEvent(PaperServerListPingEvent e) {
        if (plugin.getConfig().getBoolean("Enabled")) {
            e.setCancelled(true);
            plugin.reloadConfig();
        } else {
            e.setCancelled(false);
            plugin.reloadConfig();
        }



        if (plugin.getConfig().getBoolean("debug")) {
                plugin.logger.info("IP Address: " + e.getAddress());
                plugin.logger.info("Client version: " + e.getClient().getProtocolVersion());
                plugin.logger.info("Enabled value: " + plugin.getConfig().getBoolean("Enabled"));
        }
    }
}
