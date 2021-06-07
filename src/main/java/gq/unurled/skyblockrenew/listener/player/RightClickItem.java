package gq.unurled.skyblockrenew.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class RightClickItem implements Listener {
    @EventHandler
    public void PlayerJoinEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
    }
}
