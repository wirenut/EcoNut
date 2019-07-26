package org.wnut.EcoNut.Configurations;

import org.wnut.EcoNut.EcoNut;
import org.wnut.EcoNut.Managers.ConfigManager;

public class Players {


    static ConfigManager configManager = new ConfigManager("players");

    public Players(){
        configManager.setup();

    }

    public static void create(String uuid, String name){
        configManager.set(name, uuid);
    }

    public static String getUuid(String player){
        EcoNut.getPlugin().getLogger().info("Player is: " + player);

        String Uuid = configManager.get(player);

        return Uuid;
    }




}
