package gq.unurled.skyblockrenew.listener.player;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import de.tr7zw.nbtapi.NBTItem;
import gq.unurled.skyblockrenew.utils.CalcStats;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;

public class PlayerArmor {
    CalcStats stats = new CalcStats();

    @EventHandler
    public void ArmorChangeEvent(PlayerArmorChangeEvent e) {
        Player p = e.getPlayer();
        if(!(e.getOldItem() == null)) {
            if(e.getOldItem().getType() == Material.AIR) {
                return;
            }
            //Speed stuff
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
        if(!(e.getNewItem() == null) && e.getNewItem().getType() != Material.AIR) {
            if(e.getNewItem().getType() == Material.AIR) {
                return;
            }
            ItemStack newItem = e.getNewItem();
            NBTItem nbti = new NBTItem(newItem);
            //Speed stuff
            if(nbti.hasKey("SPEED")) {
                float speed = nbti.getFloat("SPEED");
                p.setWalkSpeed(stats.calcSpeed(p) * 0.01f);
                System.out.println(stats.calcSpeed(p) * 0.01f);
            }

            //Health stuff
            if(nbti.hasKey("HEALTH")) {
                p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(stats.calcMaxHealth(p));
                p.setHealth(stats.calcHealth(p));
                double health = nbti.getDouble("HEALTH");
            }

            //Intelligence Stuff
            if(nbti.hasKey("INTELLIGENCE")) {
                double intel = nbti.getDouble("INTELLIGENCE");
            }
        }
    }
}
