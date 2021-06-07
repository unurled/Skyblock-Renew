package gq.unurled.skyblockrenew.entity.hostile;

import de.tr7zw.nbtapi.NBTEntity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;

public class zombie {
    public void spawnZombie(Location loc, World world) {
        Zombie z = (Zombie) Bukkit.getWorld(world.getUID()).spawnEntity(loc, EntityType.ZOMBIE);
        NBTEntity nbtent = new NBTEntity(z);
        nbtent.setInteger("LEVEL", baseLevel());

        z.setCustomName("§7[Lvl." + getLevel(z).toString() + "] §cZombie §a" + getActualHealth(z) + "/" + maxHealth(z).toString() + "§c❤");
        z.setCustomNameVisible(true);
    }

    public Integer baseLevel() {
        return 1;
    }

    public Double getActualHealth(Entity e) {
        Double health = baseHealth();
        NBTEntity nbtent = new NBTEntity(e);
        if(nbtent.hasKey("ACTUAL_HEALTH")) {
            health =  nbtent.getDouble("ACTUAL_HEALTH");
        }
        else {
            nbtent.setDouble("ACTUAL_HEALTH", baseHealth());
        }
        return health;
    }

    public Integer getLevel(Entity e) {
        Integer level = baseLevel();
        NBTEntity nbtent = new NBTEntity(e);
        if(nbtent.hasKey("LEVEL")) {
            level =  nbtent.getInteger("LEVEL");
        }
        else {
            nbtent.setInteger("LEVEL", baseLevel());
        }
        return level;
    }

    public Double baseHealth() {
        return 100.0;
    }

    public Double maxHealth(Entity e) {
        Double health = baseHealth();
        NBTEntity nbtent = new NBTEntity(e);
        if(nbtent.hasKey("LEVEL")) {
            health =  nbtent.getDouble("HEALTH");
        }
        else {
            nbtent.setDouble("HEALTH", baseHealth());
        }
        return health;
    }
}
