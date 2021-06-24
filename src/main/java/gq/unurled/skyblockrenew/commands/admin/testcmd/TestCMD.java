package gq.unurled.skyblockrenew.commands.admin.testcmd;

import de.tr7zw.nbtapi.NBTItem;
import gq.unurled.skyblockrenew.SkyblockRenew;
import gq.unurled.skyblockrenew.utils.Message;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TestCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            //TestItems
            //Test sword
            ItemStack testSword = new ItemStack(Material.GOLDEN_SWORD, 1);
            ItemMeta itm = testSword.getItemMeta();
            itm.displayName(Component.text("§7§kaaa§c§lTest Sword§f§7§kaaa"));
            itm.setUnbreakable(true);
            List<Component> lore = new ArrayList<>();
            lore.add(Component.text("§4Damage: §c+802"));
            lore.add(Component.text("§4Strength: §c+802"));
            lore.add(Component.text("§4Health: §c+802"));
            lore.add(Component.text("§4Defense: §c+802"));
            lore.add(Component.text("§4Speed: §c+200"));
            lore.add(Component.text("§4Intelligence: §c+802"));
            itm.lore(lore);
            testSword.setItemMeta(itm);

            NBTItem nbti = new NBTItem(testSword);
            nbti.setString("ID", "TEST_SWORD");
            nbti.setDouble("DAMAGE", 802.0);
            nbti.setDouble("STRENGTH", 802.0);
            nbti.setDouble("CRIT_DAMAGE", 802.0);
            nbti.setDouble("HEALTH", 802.0);
            nbti.setDouble("DEFENSE", 802.0);
            nbti.setFloat("SPEED", 200f);
            nbti.setDouble("INTELLIGENCE", 802.0);
            testSword = nbti.getItem();

            //TestArmor
            ItemStack testHelmet = new ItemStack(Material.GOLDEN_HELMET, 1);
            ItemMeta itmh = testHelmet.getItemMeta();
            itmh.displayName(Component.text("§7§kaaa§c§lTest Helmet§f§7§kaaa"));
            itmh.setUnbreakable(true);
            List<String> loreh = new ArrayList<>();
            loreh.add("§4Damage: §c+802");
            loreh.add("§4Strength: §c+802");
            loreh.add("§4Health: §c+802");
            loreh.add("§4Defense: §c+802");
            loreh.add("§4Speed: §c+200");
            loreh.add("§4Intelligence: §c+802");
            itmh.setLore(loreh);
            testHelmet.setItemMeta(itmh);

            NBTItem nbtih = new NBTItem(testHelmet);
            nbtih.setString("ID", "TEST_SWORD");
            nbtih.setDouble("DAMAGE", 802.0);
            nbtih.setDouble("STRENGTH", 802.0);
            nbtih.setDouble("CRIT_DAMAGE", 802.0);
            nbtih.setDouble("HEALTH", 802.0);
            nbtih.setDouble("DEFENSE", 802.0);
            nbtih.setFloat("SPEED", 200f);
            nbtih.setDouble("INTELLIGENCE", 802.0);
            testHelmet = nbtih.getItem();

            player.getInventory().addItem(testSword);
            player.getInventory().addItem(testHelmet);
            player.sendMessage(SkyblockRenew.getPrefix() + "You successfully get the items.");
        }
        else {
            SkyblockRenew.getInstance().getServer().getConsoleSender().sendMessage(SkyblockRenew.getPrefix() + Message.getConsoleError());
        }
        return true;
    }
}
