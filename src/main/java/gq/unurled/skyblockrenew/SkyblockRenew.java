package gq.unurled.skyblockrenew;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import gq.unurled.skyblockrenew.commands.admin.KickAllCMD;
import gq.unurled.skyblockrenew.commands.admin.ReloadCMD;
import gq.unurled.skyblockrenew.commands.admin.testcmd.TestSwordCMD;
import gq.unurled.skyblockrenew.commands.item.addNBT.addNBTCMD;
import gq.unurled.skyblockrenew.entity.Commands;
import gq.unurled.skyblockrenew.listener.DamageIndicatorListener;
import gq.unurled.skyblockrenew.listener.entity.DamageEntity;
import gq.unurled.skyblockrenew.listener.entity.EntityHider;
import gq.unurled.skyblockrenew.listener.player.*;
import gq.unurled.skyblockrenew.utils.HashMap;
import gq.unurled.skyblockrenew.utils.Reload;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class SkyblockRenew extends JavaPlugin {

    private EntityHider entityHider;
    public static List<ArmorStand> toBeRemovedArmorstands;

    public static ProtocolManager protocolManager;

    public static String prefix = ChatColor.AQUA + "[SBRe] " + ChatColor.DARK_PURPLE + "> ";
    private final PluginManager pm = getServer().getPluginManager();
    public static SkyblockRenew plugin;
    FileConfiguration config;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        config = this.getConfig();

        plugin = this;
        registerCommands();
        registerEvents();
        HashMap.init();
        protocolManager = ProtocolLibrary.getProtocolManager();
        entityHider = new EntityHider(SkyblockRenew.plugin, EntityHider.Policy.BLACKLIST);
        toBeRemovedArmorstands = new ArrayList<>();

        getServer().getConsoleSender().sendMessage(prefix + ChatColor.GREEN +  "Plugin Loaded.");
    }

    public void registerCommands() {
        //getCommand("addspeed").setExecutor(new addSpeedCMD());
        getCommand("rlpl").setExecutor(new ReloadCMD());
        getCommand("kickall").setExecutor(new KickAllCMD());
        getCommand("addnbt").setExecutor(new addNBTCMD());
        getCommand("testsword").setExecutor(new TestSwordCMD());
        getCommand("spawn").setExecutor(new Commands());

        getServer().getConsoleSender().sendMessage(prefix + ChatColor.GREEN +  "Commands Registered.");
    }

    public void registerEvents() {
        pm.registerEvents(new PlayerJoinEvent(), this);
        pm.registerEvents(new PlayerQuitEvent(), this);
        pm.registerEvents(new GuiClose(), this);
        pm.registerEvents(new RightClickItem(), this);
        pm.registerEvents(new ItemInHandChange(), this);
        pm.registerEvents(new InventoryClick(), this);
        pm.registerEvents(new DamageEntity(), this);
        pm.registerEvents(new DamageIndicatorListener(this, this.entityHider, this.config, toBeRemovedArmorstands), this);
        //pm.registerEvents(new onArmorChange(), this);

        getServer().getConsoleSender().sendMessage(prefix + ChatColor.GREEN +  "Events Registered.");
    }

    @Override
    public void onDisable() {
        Reload.KickAll();
        for (ArmorStand armorStand : toBeRemovedArmorstands) {
            armorStand.remove();
        }

        getServer().getConsoleSender().sendMessage(prefix + ChatColor.RED +  "Plugin Unloaded.");
    }

    public static String getPrefix() {
        return prefix;
    }

    public static Plugin getInstance() {
        return plugin;
    }
}
