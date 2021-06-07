package gq.unurled.skyblockrenew.entity;

import de.tr7zw.nbtapi.NBTEntity;
import org.bukkit.entity.Entity;

public class Level {
    Double health;
    public Double getHealth(Entity e) {
        health = 0.0;

        NBTEntity enbt = new NBTEntity(e);
        enbt.getDouble("");

        return health;
    }
}
