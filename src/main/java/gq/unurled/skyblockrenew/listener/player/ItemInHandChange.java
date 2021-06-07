package gq.unurled.skyblockrenew.listener.player;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

public class ItemInHandChange implements Listener {
    @EventHandler
    public void onItemChange(PlayerItemHeldEvent event) {
        Player p = event.getPlayer();

        if(!(p.getInventory().getItem(event.getPreviousSlot()) == null)) {
            ItemStack previouItem = p.getInventory().getItem(event.getPreviousSlot());
            NBTItem nbti = new NBTItem(previouItem);
            if(nbti.hasKey("SPEED")) {
                float speed = nbti.getFloat("SPEED");
                System.out.println("Speed -" + speed);
            }
            if(nbti.hasKey("HEALTH")) {
                double health = nbti.getDouble("HEALTH");
                System.out.println("Health -" + health);
            }
            if(nbti.hasKey("INTELLIGENCE")) {
                double intel = nbti.getDouble("INTELLIGENCE");
                System.out.println("Intel " + intel);
            }
        }

        if(!(p.getInventory().getItem(event.getNewSlot()) == null)) {
            ItemStack newItem = p.getInventory().getItem(event.getNewSlot());
            NBTItem nbti = new NBTItem(newItem);
            if(nbti.hasKey("SPEED")) {
                float speed = nbti.getFloat("SPEED");
                System.out.println("Speed " + speed);
            }
            if(nbti.hasKey("HEALTH")) {
                double health = nbti.getDouble("HEALTH");
                System.out.println("Health " + health);
            }
            if(nbti.hasKey("INTELLIGENCE")) {
                double intel = nbti.getDouble("INTELLIGENCE");
                System.out.println("Intel " + intel);
            }
        }
    }
}
