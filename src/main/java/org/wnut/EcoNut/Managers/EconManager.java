package org.wnut.EcoNut.Managers;


import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class EconManager implements Economy {

    @Override
    public boolean isEnabled(){
        return true;
    }

    @Override
    public String getName(){
        return null;
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
    public String format(double v){
        return "Nutty Coins";
    }

    @Override
    public String currencyNamePlural(){
        return "Nutty Coins";
    }

    @Override
    public String currencyNameSingular(){
        return "Nutty Coins";
    }

    @Override
    public boolean hasAccount(String uuid){
        // To add validate from econ players yml
        return false;
    }

    @Override
    public boolean hasAccount(OfflinePlayer offlinePlayer){
        //To add validate from econ players yml
        return false;
    }

    @Override
    public boolean hasAccount(String uuid, String worldName){
        // To add validate from econ players yml
        return false;
    }

    @Override
    public boolean hasAccount(OfflinePlayer offlinePlayer, String worldName){
        // To Validate from econ players yml
        return false;
    }

    @Override
    public double getBalance(String uuid){
        Integer balance = 0;
        return balance;
    }

    @Override
    public double getBalance(OfflinePlayer offlinePlayer){
        Integer balance = 0;
        return balance;
    }

    @Override
    public double getBalance(String uuid, String worldName){
        Integer balance = 0;
        return balance;
    }

    @Override
    public double getBalance(OfflinePlayer offlinePlayer, String worldName){
        Integer balance = 0;
        return balance;
    }

    @Override
    public boolean has(String uuid, double v){
        return false;
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, double v){
        return false;
    }

    @Override
    public boolean has(String uuid, String worldName, double v){
        return false;
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, String worldName, double v){
        return false;
    }

    @Override
    public EconomyResponse withdrawPlayer(String uuid, double amount){

        Player player = Bukkit.getPlayer(UUID.fromString(uuid));

        /* if (hasAccount(uuid)){
            double balance = 0;

            return new EconomyResponse(amount, balance, EconomyResponse.ResponseType.SUCCESS, "Paid Money");

            return new EconomyResponse(amount, balance, EconomyResponse.ResponseType.FAILURE, "Not enough Money");
        }*/
        return null;


    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, double amount){
        return null;
    }

    @Override
    public EconomyResponse withdrawPlayer(String uuid, String world, double amount){
        return null;
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, String world, double amount){
        return null;
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
