package gq.unurled.skyblockrenew.listener.player;

import gq.unurled.skyblockrenew.utils.CalcStats;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {
    CalcStats stats = new CalcStats();
    @EventHandler
    public void PlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        p.setWalkSpeed(stats.calcSpeed(p) * 0.002f);
    }
}
