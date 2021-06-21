package gq.unurled.skyblockrenew.utils;

import de.tr7zw.nbtapi.NBTEntity;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CalcStats {

    Double health = 0.0;
    Double damage = 0.0;
    Double defense = 0.0;

    public Double calcDefense(Player player) {
        health = 0.0;
        defense = 0.0;
        PlayerInventory playerInv = player.getInventory();
        if(playerInv.getItemInMainHand() != null && playerInv.getItemInMainHand().getType() != Material.AIR) {
            Double itemDefense = 0.0;
            ItemStack it = playerInv.getItemInMainHand();
            NBTItem nbti = new NBTItem(it);
            if(nbti.hasKey("DEFENSE")) {
                itemDefense = nbti.getDouble("DEFENSE");
            }
            defense = defense + itemDefense;
        }
        if(playerInv.getArmorContents() != null) {
            Double helmetDefense = 0.0;
            Double chestplateDefense = 0.0;
            Double leggingsDefense = 0.0;
            Double bootsDefense = 0.0;
            Double armorDefense= 0.0;
            if(playerInv.getHelmet() != null && playerInv.getHelmet().getType() != Material.AIR) {
                ItemStack helmet = playerInv.getHelmet();
                NBTItem nbti = new NBTItem(helmet);
                if(nbti.hasKey("DEFENSE")) {
                    helmetDefense = nbti.getDouble("DEFENSE");
                }
            }
            if(playerInv.getChestplate() != null && playerInv.getChestplate().getType() != Material.AIR) {
                ItemStack chestplate = playerInv.getChestplate();
                NBTItem nbti = new NBTItem(chestplate);
                if(nbti.hasKey("DEFENSE")) {
                    chestplateDefense = nbti.getDouble("DEFENSE");
                }
            }
            if(playerInv.getLeggings() != null && playerInv.getLeggings().getType() != Material.AIR) {
                ItemStack leggings = playerInv.getLeggings();
                NBTItem nbti = new NBTItem(leggings);
                if(nbti.hasKey("DEFENSE")) {
                    leggingsDefense = nbti.getDouble("DEFENSE");
                }
            }
            if(playerInv.getBoots() != null && playerInv.getBoots().getType() != Material.AIR) {
                ItemStack boots = playerInv.getBoots();
                NBTItem nbti = new NBTItem(boots);
                if(nbti.hasKey("DEFENSE")) {
                    bootsDefense = nbti.getDouble("DEFENSE");
                }
            }
            armorDefense = helmetDefense + chestplateDefense + leggingsDefense + bootsDefense;
            defense = defense + armorDefense;
        }
        return defense;
    }

    public Double calcMaxHealth(Player player) {
        health = 0.0;
        PlayerInventory playerInv = player.getInventory();
        if(playerInv.getItemInMainHand() != null && playerInv.getItemInMainHand().getType() != Material.AIR) {
            Double itemHealth = 0.0;
            ItemStack it = playerInv.getItemInMainHand();
            NBTItem nbti = new NBTItem(it);
            if(nbti.hasKey("HEALTH")) {
                itemHealth = nbti.getDouble("HEALTH");
            }
            health = health + itemHealth;
        }
        if(playerInv.getArmorContents() != null) {
            Double helmetHealth = 0.0;
            Double chestplateHealth = 0.0;
            Double leggingsHealth = 0.0;
            Double bootsHealth = 0.0;
            Double armorHealth= 0.0;
            if(playerInv.getHelmet() != null && playerInv.getHelmet().getType() != Material.AIR) {
                ItemStack helmet = playerInv.getHelmet();
                NBTItem nbti = new NBTItem(helmet);
                if(nbti.hasKey("HEALTH")) {
                    helmetHealth = nbti.getDouble("HEALTH");
                }
            }
            if(playerInv.getChestplate() != null && playerInv.getChestplate().getType() != Material.AIR) {
                ItemStack chestplate = playerInv.getChestplate();
                NBTItem nbti = new NBTItem(chestplate);
                if(nbti.hasKey("HEALTH")) {
                    chestplateHealth = nbti.getDouble("HEALTH");
                }
            }
            if(playerInv.getLeggings() != null && playerInv.getLeggings().getType() != Material.AIR) {
                ItemStack leggings = playerInv.getLeggings();
                NBTItem nbti = new NBTItem(leggings);
                if(nbti.hasKey("HEALTH")) {
                    leggingsHealth = nbti.getDouble("HEALTH");
                }
            }
            if(playerInv.getBoots() != null && playerInv.getBoots().getType() != Material.AIR) {
                ItemStack boots = playerInv.getBoots();
                NBTItem nbti = new NBTItem(boots);
                if(nbti.hasKey("HEALTH")) {
                    bootsHealth = nbti.getDouble("HEALTH");
                }
            }
            armorHealth = helmetHealth + chestplateHealth + leggingsHealth + bootsHealth;
            health = health + armorHealth;
        }
        return health;
    }

    public Double calcHealth(Player player) {
        health = 0.0;
        NBTEntity nbtent = new NBTEntity(player);
        if(nbtent.hasKey("ACTUAL_HEALTH")) {
            health = nbtent.getDouble("ACTUAL_HEALTH");
        }
        else {
            nbtent.setDouble("ACTUAL_HEALTH", calcMaxHealth(player));
            health = calcMaxHealth(player);
        }
        return health;
    }

    public Double getWeaponDamage(Player player) {
        damage = 0.0;
        if(player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getType() != Material.AIR) {
            ItemStack it = player.getInventory().getItemInMainHand();
            NBTItem nbti = new NBTItem(it);
            if(nbti.hasKey("DAMAGE")) {
                damage = nbti.getDouble("DAMAGE");
            }
            else {
                damage = 0.0;
                return damage;
            }
        }
        else {
            damage = 0.0;
            return damage;
        }
        return damage;
    }

    public Double getStregth(Player player) {
        PlayerInventory playerInv = player.getInventory();
        damage = 0.0;
        if (playerInv.getItemInMainHand() != null && playerInv.getItemInMainHand().getType() != Material.AIR) {
            Double itemDamage = 0.0;
            ItemStack it = playerInv.getItemInMainHand();
            NBTItem nbti = new NBTItem(it);
            if (nbti.hasKey("STRENGTH")) {
                itemDamage = nbti.getDouble("STRENGTH");
            }
            damage = damage + itemDamage;
        }
        if (playerInv.getArmorContents() != null) {
            Double helmetDamage = 0.0;
            Double chestplateDamage = 0.0;
            Double leggingsDamage = 0.0;
            Double bootsDamage = 0.0;
            Double armorDamage = 0.0;
            if (playerInv.getHelmet() != null && playerInv.getHelmet().getType() != Material.AIR) {
                ItemStack helmet = playerInv.getHelmet();
                NBTItem nbti = new NBTItem(helmet);
                if (nbti.hasKey("STRENGTH")) {
                    helmetDamage = nbti.getDouble("STRENGTH");
                }
            }
            if (playerInv.getChestplate() != null && playerInv.getChestplate().getType() != Material.AIR) {
                ItemStack chestplate = playerInv.getChestplate();
                NBTItem nbti = new NBTItem(chestplate);
                if (nbti.hasKey("STRENGTH")) {
                    chestplateDamage = nbti.getDouble("STRENGTH");
                }
            }
            if (playerInv.getLeggings() != null && playerInv.getLeggings().getType() != Material.AIR) {
                ItemStack leggings = playerInv.getLeggings();
                NBTItem nbti = new NBTItem(leggings);
                if (nbti.hasKey("STRENGTH")) {
                    leggingsDamage = nbti.getDouble("STRENGTH");
                }
            }
            if (playerInv.getBoots() != null && playerInv.getBoots().getType() != Material.AIR) {
                ItemStack boots = playerInv.getBoots();
                NBTItem nbti = new NBTItem(boots);
                if (nbti.hasKey("STRENGTH")) {
                    bootsDamage = nbti.getDouble("STRENGTH");
                }
            }
            armorDamage = helmetDamage + chestplateDamage + leggingsDamage + bootsDamage;
            damage = damage + armorDamage;
        }
        return damage;
    }

    public Double getCritDamage(Player player) {
        damage = 0.0;
        PlayerInventory playerInv = player.getInventory();
        if (playerInv.getItemInMainHand() != null && playerInv.getItemInMainHand().getType() != Material.AIR) {
            Double itemDamage = 0.0;
            ItemStack it = playerInv.getItemInMainHand();
            NBTItem nbti = new NBTItem(it);
            if (nbti.hasKey("CRIT_DAMAGE")) {
                itemDamage = nbti.getDouble("CRIT_DAMAGE");
            }
            damage = damage + itemDamage;
        }
        if (playerInv.getArmorContents() != null) {
            Double helmetDamage = 0.0;
            Double chestplateDamage = 0.0;
            Double leggingsDamage = 0.0;
            Double bootsDamage = 0.0;
            Double armorDamage = 0.0;
            if (playerInv.getHelmet() != null && playerInv.getHelmet().getType() != Material.AIR) {
                ItemStack helmet = playerInv.getHelmet();
                NBTItem nbti = new NBTItem(helmet);
                if (nbti.hasKey("CRIT_DAMAGE")) {
                    helmetDamage = nbti.getDouble("CRIT_DAMAGE");
                }
            }
            if (playerInv.getChestplate() != null && playerInv.getChestplate().getType() != Material.AIR) {
                ItemStack chestplate = playerInv.getChestplate();
                NBTItem nbti = new NBTItem(chestplate);
                if (nbti.hasKey("CRIT_DAMAGE")) {
                    chestplateDamage = nbti.getDouble("CRIT_DAMAGE");
                }
            }
            if (playerInv.getLeggings() != null && playerInv.getLeggings().getType() != Material.AIR) {
                ItemStack leggings = playerInv.getLeggings();
                NBTItem nbti = new NBTItem(leggings);
                if (nbti.hasKey("CRIT_DAMAGE")) {
                    leggingsDamage = nbti.getDouble("CRIT_DAMAGE");
                }
            }
            if (playerInv.getBoots() != null && playerInv.getBoots().getType() != Material.AIR) {
                ItemStack boots = playerInv.getBoots();
                NBTItem nbti = new NBTItem(boots);
                if (nbti.hasKey("CRIT_DAMAGE")) {
                    bootsDamage = nbti.getDouble("CRIT_DAMAGE");
                }
            }
            armorDamage = helmetDamage + chestplateDamage + leggingsDamage + bootsDamage;
            damage = damage + armorDamage;
            damage = damage + 50.0;
        }
        return damage;
    }

    public Double getFinalDamage(Player player) {
        damage = (getWeaponDamage(player) + 5) * (1 + getStregth(player)/100) * (1 +getCritDamage(player)/100);
        return damage;
    }
}
