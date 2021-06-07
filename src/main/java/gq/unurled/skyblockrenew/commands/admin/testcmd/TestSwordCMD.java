package gq.unurled.skyblockrenew.commands.admin.testcmd;

import de.tr7zw.nbtapi.NBTItem;
import gq.unurled.skyblockrenew.SkyblockRenew;
import gq.unurled.skyblockrenew.utils.Message;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TestSwordCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack testSword = new ItemStack(Material.GOLDEN_SWORD, 1);
            ItemMeta itm = testSword.getItemMeta();
            itm.setDisplayName("§7§kaaa§c§lTest Sword§f§7§kaaa");
            itm.setUnbreakable(true);
            List<String> lore = new ArrayList<>();
            lore.add("§4Damage: §c+802");
            lore.add("§4Strength: §c+802");
            lore.add("§4Health: §c+802");
            lore.add("§4Defense: §c+802");
            lore.add("§4Speed: §c+80");
            lore.add("§4Intelligence: §c+802");
            itm.setLore(lore);
            testSword.setItemMeta(itm);

            NBTItem nbti = new NBTItem(testSword);
            nbti.setString("ID", "TEST_SWORD");
            nbti.setDouble("DAMAGE", 802.0);
            nbti.setDouble("STRENGTH", 802.0);
            nbti.setDouble("CRIT_DAMAGE", 802.0);
            nbti.setDouble("HEALTH", 802.0);
            nbti.setDouble("DEFENSE", 802.0);
            nbti.setFloat("SPEED", 80f);
            nbti.setDouble("INTELLIGENCE", 802.0);
            testSword = nbti.getItem();
            player.getInventory().addItem(testSword);
            player.sendMessage(SkyblockRenew.getPrefix() + "You successfully get the sword.");
        }
        else {
            SkyblockRenew.getInstance().getServer().getConsoleSender().sendMessage(SkyblockRenew.getPrefix() + Message.getConsoleError());
        }
        return true;
    }
}
