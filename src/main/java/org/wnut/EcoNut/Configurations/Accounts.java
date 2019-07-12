package org.wnut.EcoNut.Configurations;

import org.wnut.EcoNut.Managers.ConfigManager;

import java.io.File;

public class Accounts {

    private static ConfigManager configManager;

    public Accounts (String uuid){

        configManager = new ConfigManager("data" + File.separator + uuid);
        configManager.setup();

        if(!configManager.keyExists("balance")){
            configManager.create("balance", String.valueOf(1000));
        }

    }

    public static int balance(){
        String balance = configManager.get("balance");
        return Integer.parseInt(balance);
    }


}
