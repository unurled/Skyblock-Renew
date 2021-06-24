package gq.unurled.skyblockrenew.entity;

import gq.unurled.skyblockrenew.SkyblockRenew;
import gq.unurled.skyblockrenew.entity.hostile.zombie;
import gq.unurled.skyblockrenew.utils.Message;
import gq.unurled.skyblockrenew.utils.Reload;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class Commands implements CommandExecutor {
    zombie z = new zombie();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(cmd.getName().equalsIgnoreCase("spawn")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(sender.hasPermission("sbre.spawn")) {
                    if(Arrays.toString(args).contains("zombie")) {
                        z.spawnZombie(player.getLocation(), player.getWorld(), Integer.parseInt(args[1]), Double.parseDouble(args[2]));
                        player.sendMessage(SkyblockRenew.getPrefix() + ChatColor.GREEN + "You Have spawned a zombie.");
                    }
                }
                else {
                    sender.sendMessage(Message.getNoPerm(player));
                }
            }
            else {
                SkyblockRenew.getInstance().getServer().getConsoleSender().sendMessage(SkyblockRenew.getPrefix() + Message.getConsoleError());
            }
        }
        return true;
    }
}
