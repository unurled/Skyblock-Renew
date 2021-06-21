package gq.unurled.skyblockrenew.listener.player;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerQuitEvent implements Listener {
    @EventHandler
    public void PlayerJoinEvent(org.bukkit.event.player.PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.quitMessage(null);
        Bukkit.broadcast(Component.text("§b[§c-§b] " + player.getName()));

    }
}
