package gq.unurled.skyblockrenew.commands.admin;

import gq.unurled.skyblockrenew.utils.Message;
import gq.unurled.skyblockrenew.utils.Reload;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickAllCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(cmd.getName().equalsIgnoreCase("kickall")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(sender.hasPermission("sbre.kickall")) {
                    Reload.KickAll();
                }
                else {
                    sender.sendMessage(Message.getNoPerm(player));
                }
            }
            else {
                Reload.KickAll();
            }
        }
        return true;
    }
}
