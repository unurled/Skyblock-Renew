package gq.unurled.skyblockrenew.utils;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Message {
    public static String getError(Player player) {
        player.playSound(player.getLocation(), Sound.ENTITY_BAT_DEATH, 1f, 20f);
        return ChatColor.RED + "Error, please retry.";
    }
    public static void getErrorSound(Player player) {
        player.playSound(player.getLocation(), Sound.ENTITY_BAT_DEATH, 1f, 20f);
    }

    public static String getConsoleError() {
        return ChatColor.RED + "Error, please retry or use a player instead to perform the command.";
    }

    public static String getNoPerm(Player player) {
        player.playSound(player.getLocation(), Sound.ENTITY_BAT_DEATH, 1f, 20f);
        return ChatColor.RED + "You don't have the permission needed to perform this command.";
    }
}
