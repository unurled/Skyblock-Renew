package gq.unurled.skyblockrenew.commands.item.addNBT;

import de.tr7zw.nbtapi.NBTItem;
import gq.unurled.skyblockrenew.SkyblockRenew;
import gq.unurled.skyblockrenew.utils.Message;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class addNBTCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(cmd.getName().equalsIgnoreCase("addnbt")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission("sbre.nbt.add")) {
                    if(player.getInventory().getItem(player.getInventory().getHeldItemSlot()) != null) {
                        if(args != null) {
                            ItemStack it = player.getInventory().getItem(player.getInventory().getHeldItemSlot());
                            addNBTGUI.openGUIMain(player, it);
                            player.getInventory().setItem(player.getInventory().getHeldItemSlot(), it);
                        }
                    }
                    else {
                        player.sendMessage(ChatColor.RED + "Error, Please held an Item in hand to add NBTs.");
                        Message.getErrorSound(player);
                        return true;
                    }
                }
                else {
                    sender.sendMessage(Message.getNoPerm(player));
                    return true;
                }
            }
            else {
                SkyblockRenew.getInstance().getServer().getConsoleSender().sendMessage(SkyblockRenew.getPrefix() + Message.getConsoleError());
                return true;
            }
        }
        return true;
    }
}
