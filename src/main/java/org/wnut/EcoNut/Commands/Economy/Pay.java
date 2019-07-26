package org.wnut.EcoNut.Commands.Economy;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.wnut.EcoNut.Configurations.Players;
import org.wnut.EcoNut.EcoNut;

import java.util.UUID;

import static org.wnut.EcoNut.EcoNut.getEconomy;

public class Pay implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if(!EcoNut.getPermissions().has(sender, "wnut.economy.pay")){
            sender.sendMessage("You do not have permissions to run this command!");
            return false;
        }

        Players players = new Players();

        OfflinePlayer player = Bukkit.getOfflinePlayer(UUID.fromString(players.getUuid(sender.getName())));
        OfflinePlayer recipient = Bukkit.getOfflinePlayer(UUID.fromString(players.getUuid(args[0])));

        double amount = Double.valueOf(args[1]);


        if(!getEconomy().has(player, amount)){
            sender.sendMessage("You do not have enough money!");
            return false;
        }

        if(recipient == null){
            sender.sendMessage("Recipient does not exist!");
            return false;
        }

        getEconomy().depositPlayer(recipient, amount);
        getEconomy().withdrawPlayer(player, amount);

        sender.sendMessage("You transferred " + amount + "to " + recipient.getName());


        return true;
    }
}
