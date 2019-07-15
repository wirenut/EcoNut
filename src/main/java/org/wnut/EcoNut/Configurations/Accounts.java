package org.wnut.EcoNut.Configurations;

import org.wnut.EcoNut.Managers.ConfigManager;

import java.io.File;

public class Accounts {

    private static ConfigManager configManager;

    public Accounts (String uuid){

        configManager = new ConfigManager("data" + File.separator + uuid);
        configManager.setup();

        this.createDefault();
    }

    public static void createDefault(){
        if(!configManager.keyExists("balance")){
            configManager.create("balance", 1000);
        }
    }

    public static boolean exists(String key){
        if(configManager.keyExists(key)){
            return true;
        }
        return false;
    }

    public void set(String key, String value){
        configManager.set(key, value);
    }

    public void set(String key, Integer value){
        configManager.set(key, value);
    }

    public void set(String key, double value){
        configManager.set(key, value);
    }

    public static int balance(){
        String balance = configManager.get("balance");
        return Integer.parseInt(balance);
    }


}
