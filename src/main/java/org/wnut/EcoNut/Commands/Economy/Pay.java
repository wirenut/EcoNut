package org.wnut.EcoNut.Commands.Economy;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.wnut.EcoNut.EcoNut;

public class Pay implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if(!EcoNut.getPermissions().has(sender, "wnut.economy.pay")){

            return false;
        }

        Player player = Bukkit.getPlayer(args[0]);

        Double amount = Double.valueOf(args[1]);


        if (player == null) {
            return false;
        }


        if (EcoNut.getEconomy().has((OfflinePlayer) sender, amount)){

            EconomyResponse senderResponse = EcoNut.getEconomy().withdrawPlayer((OfflinePlayer) sender, amount);

            if(!senderResponse.transactionSuccess()){
                sender.sendMessage(String.format("An error occured!"));
            }

            EconomyResponse playerResponse = EcoNut.getEconomy().depositPlayer(player, amount);

            if(!playerResponse.transactionSuccess()){
                sender.sendMessage(String.format("An error occured!"));
            }

            sender.sendMessage(String.format("You have transferred " + player.toString() + " " + amount.toString() + " nutty coins"));
            return true;
        }
        return false;
    }
}
