package gq.unurled.skyblockrenew.listener.player;

import gq.unurled.skyblockrenew.SkyblockRenew;
import gq.unurled.skyblockrenew.utils.ActionBar;
import gq.unurled.skyblockrenew.utils.CalcStats;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.sql.Time;

public class PlayerJoinEvent implements Listener {
    CalcStats stats = new CalcStats();
    ActionBar ab = new ActionBar();

    @EventHandler
    public void PlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.joinMessage(null);
        Bukkit.broadcast(Component.text("§b[§a+§b] " + player.getName()));

        //Action Bar stuff
        ab.sendMessage(player,   "§c" + stats.calcHealth(player).toString() + "/" + stats.calcMaxHealth(player).toString() +
                "❤     §a" + stats.calcDefense(player).toString() + "❈ Defense  §b✎∞/∞ Mana");

        ab.playerActionBar(player);
    }

}
