package gq.unurled.skyblockrenew.commands.item.addNBT;

import gq.unurled.skyblockrenew.utils.GUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class addNBTGUI {
    private static gq.unurled.skyblockrenew.utils.GUI GUI = new GUI();
    static Inventory inv = Bukkit.createInventory(null, 54, "Add NBT");
    static Inventory healthInv = Bukkit.createInventory(null, 54, "Health");
    static Inventory defenseInv = Bukkit.createInventory(null, 54, "Defense");


    public static void openGUIMain(Player player, ItemStack it) {
        buildItemMain(it);
        GUI.fillPane(inv);
        player.openInventory(inv);
    }

    public static void openGUIHealth(Player player, ItemStack it) {
        buildItemHealth(it);
        GUI.fillPane(healthInv);
        player.openInventory(healthInv);
    }

    public static void openGUIDefense(Player player, ItemStack it) {
        buildItemDefense(it);
        GUI.fillPane(defenseInv);
        player.openInventory(defenseInv);
    }

    public static void buildItemMain(ItemStack it) {
        ItemStack health = new ItemStack(Material.APPLE, 1);
        ItemMeta healthMeta = health.getItemMeta();
        healthMeta.setDisplayName("§aAdd Health");
        health.setItemMeta(healthMeta);

        ItemStack defense = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemMeta defenseMeta = defense.getItemMeta();
        defenseMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        defenseMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        defenseMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        defense.setItemMeta(defenseMeta);

        //place item in right place
        inv.setItem(4, it);
        inv.setItem(10, health);
        inv.setItem(11, defense);
        inv.setItem(49, GUI.Close());
    }
    public static void buildItemHealth(ItemStack it) {
        ItemStack health = new ItemStack(Material.APPLE, 1);
        ItemMeta healthMeta = health.getItemMeta();
        healthMeta.setDisplayName("§aAdd Health");
        health.setItemMeta(healthMeta);

        ItemStack minus1000 = new ItemStack(Material.COAL_BLOCK, 1);
        ItemMeta m1000Meta = minus1000.getItemMeta();
        m1000Meta.setDisplayName("§c-1000 §cHP ❤");
        m1000Meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        m1000Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        m1000Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        minus1000.setItemMeta(m1000Meta);

        ItemStack minus100 = new ItemStack(Material.COAL_ORE, 1);
        ItemMeta m100Meta = minus100.getItemMeta();
        m100Meta.setDisplayName("§c-100 §cHP ❤");
        m100Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        m100Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        minus100.setItemMeta(m100Meta);

        ItemStack minus10 = new ItemStack(Material.COAL, 1);
        ItemMeta m10Meta = minus10.getItemMeta();
        m10Meta.setDisplayName("§c-10 §cHP ❤");
        m10Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        m10Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        minus10.setItemMeta(m10Meta);

        ItemStack plus10 = new ItemStack(Material.GOLD_INGOT, 1);
        ItemMeta p10Meta = plus10.getItemMeta();
        p10Meta.setDisplayName("§c+10 §cHP ❤");
        p10Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        p10Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        plus10.setItemMeta(p10Meta);

        ItemStack plus100 = new ItemStack(Material.GOLD_INGOT, 1);
        ItemMeta p100Meta = plus100.getItemMeta();
        p100Meta.setDisplayName("§c+100 §cHP ❤");
        p100Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        p100Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        plus100.setItemMeta(p100Meta);

        ItemStack plus1000 = new ItemStack(Material.GOLD_INGOT, 1);
        ItemMeta p1000Meta = plus100.getItemMeta();
        p1000Meta.setDisplayName("§c+1000 §cHP ❤");
        m1000Meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        p1000Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        p1000Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        plus1000.setItemMeta(p1000Meta);

        //place item in right place
        healthInv.setItem(4, it);
        healthInv.setItem(28, minus1000);
        healthInv.setItem(29, minus100);
        healthInv.setItem(30, minus10);
        healthInv.setItem(31, health);
        healthInv.setItem(32, plus10);
        healthInv.setItem(33, plus100);
        healthInv.setItem(34, plus1000);


        healthInv.setItem(49, gq.unurled.skyblockrenew.utils.GUI.Close());
    }

    public static void buildItemDefense(ItemStack it) {

    }

}
