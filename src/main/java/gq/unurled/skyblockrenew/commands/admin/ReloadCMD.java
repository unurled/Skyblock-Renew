package gq.unurled.skyblockrenew.commands.admin;

import gq.unurled.skyblockrenew.utils.Message;
import gq.unurled.skyblockrenew.utils.Reload;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(cmd.getName().equalsIgnoreCase("rlpl")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(sender.hasPermission("sbre.rlpl")) {
                    Reload.KickAll();
                    Bukkit.shutdown();
                }
                else {
                    sender.sendMessage(Message.getNoPerm(player));
                }
            }
            else {
                Reload.KickAll();
                Bukkit.shutdown();
            }
        }
        return true;
    }
}
