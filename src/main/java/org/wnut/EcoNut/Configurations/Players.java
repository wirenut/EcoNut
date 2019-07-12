package org.wnut.EcoNut.Configurations;

import org.wnut.EcoNut.Managers.ConfigManager;

public class Players {


    static ConfigManager configManager = new ConfigManager("players");

    public Players(String uuid, String name){
        configManager.setup();
        configManager.create(uuid, name);
    }




}
