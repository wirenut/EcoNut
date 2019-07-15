package org.wnut.EcoNut.Managers;


import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.OfflinePlayer;
import org.wnut.EcoNut.Configurations.Accounts;

import java.text.DecimalFormat;
import java.util.List;

public class EconManager implements Economy {

    @Override
    public boolean isEnabled(){
        return true;
    }

    @Override
    public String getName(){
        return "EcoNut";
    }


    @Override
    public boolean hasBankSupport(){
        return false;
    }

    @Override
    public int fractionalDigits(){
        return 0;
    }

    @Override
    public String format(double amount){
        return new DecimalFormat("#").format(amount).toString() + " NC";
    }

    @Override
    public String currencyNamePlural(){
        return  null;
    }

    @Override
    public String currencyNameSingular(){
        return null;
    }



    /// Check if account exists
    @Override
    public boolean hasAccount(String uuid){
        Accounts accounts = new Accounts(uuid);
        if(Accounts.exists("balance")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasAccount(OfflinePlayer offlinePlayer){
        String uuid = String.valueOf(offlinePlayer.getUniqueId());
        Accounts accounts = new Accounts(uuid);
        if(accounts.exists("balance")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasAccount(String uuid, String worldName){
        Accounts accounts = new Accounts(uuid);
        if(accounts.exists("balance")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasAccount(OfflinePlayer offlinePlayer, String worldName){
        String uuid = String.valueOf(offlinePlayer.getUniqueId());
        Accounts accounts = new Accounts(uuid);
        if(accounts.exists("balance")) {
            return true;
        }
        return false;
    }



    // Get balance of player
    @Override
    public double getBalance(String uuid){
        Accounts accounts = new Accounts(uuid);
        Integer balance = accounts.balance();
        return balance;
    }

    @Override
    public double getBalance(OfflinePlayer offlinePlayer){
        String uuid = String.valueOf(offlinePlayer.getUniqueId());
        Accounts accounts = new Accounts(uuid);
        Integer balance = accounts.balance();
        return balance;
    }

    @Override
    public double getBalance(String uuid, String worldName){
        Accounts accounts = new Accounts(uuid);
        Integer balance = accounts.balance();
        return balance;
    }

    @Override
    public double getBalance(OfflinePlayer offlinePlayer, String worldName){
        String uuid = String.valueOf(offlinePlayer.getUniqueId());
        Accounts accounts = new Accounts(uuid);
        Integer balance = accounts.balance();
        return balance;
    }



    // Check if player has an amount
    @Override
    public boolean has(String uuid, double amount){
        return false;
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, double amount){
        return false;
    }

    @Override
    public boolean has(String uuid, String worldName, double amount){
        return false;
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, String worldName, double amount){
        return false;
    }



    @Override
    public EconomyResponse withdrawPlayer(String uuid, double amount){

        if (hasAccount(uuid)){
            double balance = getBalance(uuid);

            if(balance >= amount){
                balance -= amount;
                Accounts accounts = new Accounts(uuid);
                accounts.set("balance", balance);
                return new EconomyResponse(amount, balance, EconomyResponse.ResponseType.SUCCESS, "You paid " + amount + "!");
            }else{
                return new EconomyResponse(amount, balance, EconomyResponse.ResponseType.FAILURE, "You do not have enough money!");
            }
        }
        return new EconomyResponse(amount, 0, EconomyResponse.ResponseType.FAILURE, "You do not have an account!");

    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, double amount){
        String uuid = String.valueOf(offlinePlayer.getUniqueId());
        if (hasAccount(uuid)){
            double balance = getBalance(uuid);

            if(balance >= amount){
                balance -= amount;
                Accounts accounts = new Accounts(uuid);
                accounts.set("balance", balance);
                return new EconomyResponse(amount, balance, EconomyResponse.ResponseType.SUCCESS, "You paid " + amount + "!");
            }else{
                return new EconomyResponse(amount, balance, EconomyResponse.ResponseType.FAILURE, "You do not have enough money!");
            }
        }
        return new EconomyResponse(amount, 0, EconomyResponse.ResponseType.FAILURE, "You do not have an account!");

    }

    @Override
    public EconomyResponse withdrawPlayer(String uuid, String world, double amount){
        if (hasAccount(uuid)){
            double balance = getBalance(uuid);

            if(balance >= amount){
                balance -= amount;
                Accounts accounts = new Accounts(uuid);
                accounts.set("balance", balance);
                return new EconomyResponse(amount, balance, EconomyResponse.ResponseType.SUCCESS, "You paid " + amount + "!");
            }else{
                return new EconomyResponse(amount, balance, EconomyResponse.ResponseType.FAILURE, "You do not have enough money!");
            }
        }
        return new EconomyResponse(amount, 0, EconomyResponse.ResponseType.FAILURE, "You do not have an account!");
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, String world, double amount){
        String uuid = String.valueOf(offlinePlayer.getUniqueId());
        if (hasAccount(uuid)){
            double balance = getBalance(uuid);

            if(balance >= amount){
                balance -= amount;
                Accounts accounts = new Accounts(uuid);
                accounts.set("balance", balance);
                return new EconomyResponse(amount, balance, EconomyResponse.ResponseType.SUCCESS, "You paid " + amount + "!");
            }else{
                return new EconomyResponse(amount, balance, EconomyResponse.ResponseType.FAILURE, "You do not have enough money!");
            }
        }
        return new EconomyResponse(amount, 0, EconomyResponse.ResponseType.FAILURE, "You do not have an account!");
    }



    @Override
    public EconomyResponse depositPlayer(String uuid, double amount){
       return null;
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, double amount){
        return null;
    }

    @Override
    public EconomyResponse depositPlayer(String sender, String receiver, double amount){
        return null;
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, String receiver, double amount){
        return null;
    }



    @Override
    public EconomyResponse createBank(String name, String player){
        return null;
    }

    @Override
    public EconomyResponse createBank(String name, OfflinePlayer offlinePlayer){
        return null;
    }

    @Override
    public EconomyResponse deleteBank(String name){
        return null;
    }

    @Override
    public EconomyResponse bankBalance(String name){
        return null;
    }

    @Override
    public EconomyResponse bankHas(String name, double amount){
        return null;
    }

    @Override
    public EconomyResponse bankWithdraw(String name, double amount){
        return null;
    }

    @Override
    public EconomyResponse bankDeposit(String name, double amount){
        return null;
    }

    @Override
    public EconomyResponse isBankOwner(String name, String player){
        return null;
    }

    @Override
    public EconomyResponse isBankOwner(String name, OfflinePlayer player){
        return null;
    }

    @Override
    public EconomyResponse isBankMember(String name, String player){
        return null;
    }

    @Override
    public EconomyResponse isBankMember(String name, OfflinePlayer player){
        return null;
    }

    @Override
    public List<String> getBanks(){
        return null;
    }

    @Override
    public boolean createPlayerAccount(String uuid){
        //Add functions to create player acount
        return false;
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer player){
        //Add functions to create player acount
        return false;
    }

    @Override
    public boolean createPlayerAccount(String uuid, String world){
        return false;
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer offlinePlayer, String world){
        return false;
    }

















}
