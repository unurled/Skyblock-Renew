package gq.unurled.skyblockrenew.listener.player;

import gq.unurled.skyblockrenew.SkyblockRenew;
import gq.unurled.skyblockrenew.utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {
    @EventHandler
    public void PlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);
        Bukkit.broadcastMessage("§b[§a+§b] " + player.getDisplayName());
    }
}
