package me.melonoof.hiddenbackend;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PingListener implements Listener {

    private final HiddenBackend plugin;

    public PingListener(HiddenBackend plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PingEvent(PaperServerListPingEvent e) {
        Bukkit.getScheduler().runTaskAsynchronously (new HiddenBackend(), () -> {

            if (plugin.getConfig().getBoolean("enabled")) {
                e.setServerIcon(null);
                e.setMaxPlayers(-1);
                e.setProtocolVersion(-1);
                e.setVersion("Pinging...");
                e.setNumPlayers(-1);
                e.setHidePlayers(true);
                e.motd(MiniMessage.miniMessage().deserialize("<#ff0000>Can't connect to server"));
            }
        });




    }
}
