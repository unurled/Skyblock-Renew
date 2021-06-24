package gq.unurled.skyblockrenew.listener.player;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import gq.unurled.skyblockrenew.SkyblockRenew;
import gq.unurled.skyblockrenew.utils.ActionBar;
import gq.unurled.skyblockrenew.utils.CalcStats;
import net.kyori.adventure.text.Component;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerInfo;
import net.minecraft.world.level.EnumGamemode;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.lang.reflect.Field;
import java.sql.Time;
import java.util.List;
import java.util.UUID;

public class PlayerJoinEvent implements Listener {
    CalcStats stats = new CalcStats();
    ActionBar ab = new ActionBar();

    ProtocolManager pm = SkyblockRenew.protocolManager;

    @EventHandler
    public void PlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent event) {
        //JoinMessage
        Player player = event.getPlayer();
        event.joinMessage(null);
        Bukkit.broadcast(Component.text("§b[§a+§b] " + player.getName()));

        //Action Bar stuff
        ab.sendMessage(player,   "§c" + stats.calcHealth(player).toString() + "/" + stats.calcMaxHealth(player).toString() +
                "❤     §a" + stats.calcDefense(player).toString() + "❈ Defense  §b✎∞/∞ Mana");
        ab.playerActionBar(player);


    }
}
