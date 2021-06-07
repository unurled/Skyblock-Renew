package gq.unurled.skyblockrenew.utils;

import gq.unurled.skyblockrenew.SkyblockRenew;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Reload {
    public static void KickAll() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            player.kick(Component.text(SkyblockRenew.getPrefix() + "\n §cServer is Restarting\n §cPlease Wait a few Minutes to reconnect."));
        }
    }
}
