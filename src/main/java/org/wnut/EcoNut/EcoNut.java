package org.wnut.EcoNut;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.wnut.EcoNut.Commands.Economy.Pay;

public class EcoNut extends JavaPlugin {

    private static Economy econ = null;
    private static Permission perms = null;

    @Override
    public void onEnable(){
        getLogger().info("EcoNut Enabled");
        if(!setupEconomy()){
            getServer().getPluginManager().disablePlugin(this);
        }

        setupPermissions();

        this.getCommand("pay").setExecutor(new Pay());
    }

    @Override
    public void onDisable(){
        getLogger().info("EcoNut Disabled");
    }

    private boolean setupEconomy(){
        if(getServer().getPluginManager().getPlugin("Vault") == null){
            return false;
        }

        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);

        if(rsp == null){
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
