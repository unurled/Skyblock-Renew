package gq.unurled.skyblockrenew.listener.player;

import de.tr7zw.nbtapi.NBTItem;
import gq.unurled.skyblockrenew.commands.item.addNBT.addNBTGUI;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if(e.getClickedInventory() == null) {
            System.out.println("null");
            return;
        }

        if(e.getCurrentItem() != null && e.getCurrentItem().getType() != Material.AIR) {
            ItemStack it = e.getCurrentItem();
            NBTItem nbti = new NBTItem(it);
            if (nbti.hasKey("ID")) {
                if(nbti.getString("ID").equals("CLOSE_MENU")) {
                    player.closeInventory();
                    e.setCancelled(true);
                }
            }
        }

        if(e.getView().title().contains(Component.text("Add NBT"))) {
            if(e.getCurrentItem() != null) {
                if(e.getCurrentItem().getItemMeta().displayName().contains(Component.text("Add Health"))) {
                    addNBTGUI.openGUIHealth((Player) e.getWhoClicked(), e.getWhoClicked().getInventory().getItemInMainHand());
                }
                if(e.getCurrentItem().getItemMeta().displayName().contains(Component.text("Add Defense"))) {
                    addNBTGUI.openGUIDefense((Player) e.getWhoClicked(), e.getWhoClicked().getInventory().getItemInMainHand());
                }
            }
            e.setCancelled(true);
        }
    }
}
