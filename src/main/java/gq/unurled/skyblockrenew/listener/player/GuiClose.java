package gq.unurled.skyblockrenew.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class GuiClose implements Listener {
    @EventHandler
    public void GuiClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
    }
}
