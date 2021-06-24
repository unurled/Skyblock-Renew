package gq.unurled.skyblockrenew.listener.entity;

import de.tr7zw.nbtapi.NBTEntity;
import gq.unurled.skyblockrenew.SkyblockRenew;
import gq.unurled.skyblockrenew.entity.hostile.zombie;
import gq.unurled.skyblockrenew.utils.CalcStats;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DamageEntity implements Listener {
    CalcStats stats = new CalcStats();

    gq.unurled.skyblockrenew.entity.hostile.zombie Zombie = new zombie();

    @EventHandler
    public void DamageEntity(EntityDamageByEntityEvent e) {
        if(e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            if(e.getDamager() instanceof Player) {
                Player attacker = (Player) e.getDamager();
                Double damage = stats.getFinalDamage(attacker);
                Entity ent = e.getEntity();
                NamespacedKey key =  new NamespacedKey(SkyblockRenew.getInstance(), "ACTUAL_HEALTH");
                PersistentDataContainer d = ent.getPersistentDataContainer();
                if(d.get(key, PersistentDataType.DOUBLE) != null) {
                    ((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.HARM, 2000, 100, true, false));
                    double health =  d.get(key, PersistentDataType.DOUBLE);
                    health = health -damage;
                    d.set(key, PersistentDataType.DOUBLE, health);
                    key = new NamespacedKey(SkyblockRenew.getInstance(), "ID");
                    if (d.get(key, PersistentDataType.STRING).equals("ZOMBIE")) {
                        ent.setCustomName(Zombie.name(ent));
                    }
                    if(health < 0) {
                        e.getEntity().remove();
                    }
                }
                else {
                    key = new NamespacedKey(SkyblockRenew.getInstance(), "ID");
                    if(d.get(key, PersistentDataType.STRING) != null) {
                        if (d.get(key, PersistentDataType.STRING).equals("ZOMBIE")) {
                            key = new NamespacedKey(SkyblockRenew.getInstance(), "ACTUAL_HEALTH");
                            d.set(key, PersistentDataType.DOUBLE, Zombie.baseHealth());
                        }
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
