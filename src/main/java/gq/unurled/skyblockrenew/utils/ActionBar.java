package gq.unurled.skyblockrenew.utils;

import gq.unurled.skyblockrenew.SkyblockRenew;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ActionBar {
    CalcStats stats = new CalcStats();

    public void sendMessage(Player p, String s) {
        p.sendActionBar(Component.text(s));
    }



    public void playerActionBar(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                sendMessage(player,   "§c" + stats.calcHealth(player).toString() + "/" + stats.calcMaxHealth(player).toString() +
                        "❤     §a" + stats.calcDefense(player).toString() + "❈ Defense  §b✎∞/∞ Mana");
                if(!(player.isOnline())) {
                    cancel();
                }
            }
        }.runTaskTimer(SkyblockRenew.plugin, 0, 60);
    }
}
