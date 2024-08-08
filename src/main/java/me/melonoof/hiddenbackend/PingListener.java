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
        final String ipAddress = e.getAddress().getHostAddress();
        final int protocolVersion = e.getClient().getProtocolVersion();
        boolean enabled = plugin.getConfig().getBoolean("Enabled");
        boolean debug = plugin.getConfig().getBoolean("Debug");


        if (enabled) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }

        if (debug) {
            plugin.getLogger().info("IP Address: " + ipAddress);
            plugin.getLogger().info("Client version: " + protocolVersion);
            plugin.getLogger().info("Enabled value: " + enabled);
        }
    }
}
