package gq.unurled.skyblockrenew.listener.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerQuitEvent implements Listener {
    @EventHandler
    public void PlayerJoinEvent(org.bukkit.event.player.PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(null);
        Bukkit.broadcastMessage("§b[§c-§b] " + player.getDisplayName());

    }
}
