package gq.unurled.skyblockrenew.listener.player;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class PlayerArmorChange implements Listener {
    @EventHandler
    public void onPlayerArmorChangeEvent(PlayerArmorChangeEvent e) {
        Player player = e.getPlayer();
        if(!(e.getOldItem() == null)) {
            ItemStack previouItem = e.getOldItem();
            NBTItem nbti = new NBTItem(previouItem);
            if(nbti.hasKey("SPEED")) {
                float speed = nbti.getFloat("SPEED");
            }
            if(nbti.hasKey("HEALTH")) {
                double health = nbti.getDouble("HEALTH");
            }
            if(nbti.hasKey("INTELLIGENCE")) {
                double intel = nbti.getDouble("INTELLIGENCE");
            }
        }
        if(!(e.getNewItem() == null)) {
            ItemStack newItem = e.getNewItem();
            NBTItem nbti = new NBTItem(newItem);
            if(nbti.hasKey("SPEED")) {
                float speed = nbti.getFloat("SPEED");
            }
            if(nbti.hasKey("HEALTH")) {
                double health = nbti.getDouble("HEALTH");
            }
            if(nbti.hasKey("INTELLIGENCE")) {
                double intel = nbti.getDouble("INTELLIGENCE");
            }
        }
    }
}
