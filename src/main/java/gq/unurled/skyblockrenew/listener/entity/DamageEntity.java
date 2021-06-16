package gq.unurled.skyblockrenew.listener.entity;

import de.tr7zw.nbtapi.NBTEntity;
import gq.unurled.skyblockrenew.utils.CalcStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEntity implements Listener {
    CalcStats stats = new CalcStats();

    @EventHandler
    public void DamageEntity(EntityDamageByEntityEvent e) {
        if(e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            if(e.getDamager() instanceof Player) {
                Player attacker = (Player) e.getDamager();
                Double damage = stats.getFinalDamage(attacker);
                NBTEntity nbtent = new NBTEntity(e.getEntity());
                if(nbtent.hasKey("ACTUAL_HEALTH")) {
                    Double health =  nbtent.getDouble("ACTUAL_HEALTH");
                    health = health - damage;
                    if(health < 0) {
                        e.getEntity().remove();
                    }
                }

                attacker.sendMessage(damage.toString());
            }
            if(e.getEntity() instanceof Player) {
                Player victim = (Player) e.getEntity();
            }

        }
    }
}
