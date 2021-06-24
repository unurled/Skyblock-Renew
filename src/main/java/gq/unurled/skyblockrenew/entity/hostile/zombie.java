package gq.unurled.skyblockrenew.entity.hostile;

import com.comphenix.protocol.wrappers.nbt.NbtCompound;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTEntity;
import de.tr7zw.nbtinjector.NBTInjector;
import gq.unurled.skyblockrenew.SkyblockRenew;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class zombie {
    public void spawnZombie(Location loc, World world, Integer level, Double health) {
        Zombie z = (Zombie) Bukkit.getWorld(world.getUID()).spawnEntity(loc, EntityType.ZOMBIE);
        NamespacedKey key =  new NamespacedKey(SkyblockRenew.getInstance(), "LEVEL");
        @NotNull PersistentDataContainer d = z.getPersistentDataContainer();
        d.set(key, PersistentDataType.INTEGER, level);
        key =  new NamespacedKey(SkyblockRenew.getInstance(), "ID");
        d.set(key, PersistentDataType.STRING, "ZOMBIE");
        key =  new NamespacedKey(SkyblockRenew.getInstance(), "HEALTH");
        d = z.getPersistentDataContainer();
        d.set(key, PersistentDataType.DOUBLE, health);
        key =  new NamespacedKey(SkyblockRenew.getInstance(), "ACTUAL_HEALTH");
        d = z.getPersistentDataContainer();
        d.set(key, PersistentDataType.DOUBLE,health);

        z.setCustomName("§7[Lvl." + getLevel(z).toString() + "] §cZombie §a" + getActualHealth(z) + "/" + maxHealth(z).toString() + "§c❤");
        z.setCustomNameVisible(true);
    }

    public String name (Entity e) {
        return "§7[Lvl." + getLevel(e).toString() + "] §cZombie §a" + getActualHealth(e) + "/" + maxHealth(e).toString() + "§c❤";
    }

    public Integer baseLevel() {
        return 1;
    }

    public Double getActualHealth(Entity e) {
        Double health = baseHealth();
        NamespacedKey key =  new NamespacedKey(SkyblockRenew.getInstance(), "ACTUAL_HEALTH");
        PersistentDataContainer d = e.getPersistentDataContainer();
        if(d.get(key, PersistentDataType.DOUBLE) != null) {
            health =  d.get(key, PersistentDataType.DOUBLE);
        }
        else {
            d.set(key, PersistentDataType.DOUBLE,baseHealth());
        }
        return health;
    }

    public Integer getLevel(Entity e) {
        Integer level = baseLevel();
        NamespacedKey key =  new NamespacedKey(SkyblockRenew.getInstance(), "LEVEL");
        PersistentDataContainer d = e.getPersistentDataContainer();
        if(d.get(key, PersistentDataType.INTEGER) != null) {
            level =  d.get(key, PersistentDataType.INTEGER);
        }
        else {
            d.set(key, PersistentDataType.INTEGER,baseLevel());
        }
        return level;
    }

    public Double baseHealth() {
        return 100.0;
    }

    public Double maxHealth(Entity e) {
        Double health = baseHealth();
        NamespacedKey key =  new NamespacedKey(SkyblockRenew.getInstance(), "HEALTH");
        PersistentDataContainer d = e.getPersistentDataContainer();
        if(d.get(key, PersistentDataType.DOUBLE) != null) {
            health =  d.get(key, PersistentDataType.DOUBLE);
        }
        else {
            d.set(key, PersistentDataType.DOUBLE,baseHealth());
        }
        return health;
    }
}
