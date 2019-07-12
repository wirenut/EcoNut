package org.wnut.EcoNut.Commands.Economy;


import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.wnut.EcoNut.EcoNut;

public class Balance implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            return false;
        }

        if(!EcoNut.getPermissions().has(sender, "wnut.economy.balance")){

            return false;
        }


        sender.sendMessage("Your balance is: " + EcoNut.getEconomy().format(EcoNut.getEconomy().getBalance((OfflinePlayer) sender)));

        return true;

    }
}
