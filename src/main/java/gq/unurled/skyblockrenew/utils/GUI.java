package gq.unurled.skyblockrenew.utils;

import de.tr7zw.nbtapi.NBTItem;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI {
    public Inventory fillPane(Inventory inv) {
        ItemStack blackPane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta blackmeta = blackPane.getItemMeta();
        blackmeta.setDisplayName("");
        blackPane.setItemMeta(blackmeta);
        for (int i = 0; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null) {
                inv.setItem(i, blackPane);
            }
        }
        return inv;
    }
    public static ItemStack Close() {
        ItemStack close = new ItemStack(Material.BARRIER, 1);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.displayName(Component.text("§l§cClose"));
        closeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        closeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        closeMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        closeMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        closeMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        closeMeta.addItemFlags(ItemFlag.HIDE_DYE);
        closeMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        close.setItemMeta(closeMeta);
        NBTItem nbti = new NBTItem(close);
        nbti.setString("ID", "CLOSE_MENU");
        close = nbti.getItem();
        return close;
    }
}
