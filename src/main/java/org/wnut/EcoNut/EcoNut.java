package org.wnut.EcoNut;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;


import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;
import org.wnut.EcoNut.Commands.Economy.Balance;
import org.wnut.EcoNut.Commands.Economy.Pay;
import org.wnut.EcoNut.Listeners.WnutListener;
import org.wnut.EcoNut.Managers.EconManager;

public class EcoNut extends JavaPlugin {

    private static Economy econ = null;
    private static Permission perms = null;

    @Override
    public void onEnable(){
        getLogger().info("EcoNut Enabled");
        if(!setupEconomy()){
            getServer().getPluginManager().disablePlugin(this);
            getLogger().info("Vault not detected");
            return;
        }

        setupPermissions();

        this.getCommand("pay").setExecutor(new Pay());
        this.getCommand("balance").setExecutor(new Balance());
        getServer().getPluginManager().registerEvents(new WnutListener(), this);
    }

    @Override
    public void onDisable(){
        getLogger().info("EcoNut Disabled");
    }



    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            getLogger().info("No Vault");
            return false;
        }
        getServer().getServicesManager().register(Economy.class, EconManager, this, ServicePriority.High);
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            getLogger().info("RSP Null");
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public static Economy getEconomy(){
        return econ;
    }

    public static Permission getPermissions(){
        return perms;
    }

}
