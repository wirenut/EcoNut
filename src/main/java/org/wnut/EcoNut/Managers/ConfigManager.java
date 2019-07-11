package org.wnut.EcoNut.Managers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.wnut.EcoNut.EcoNut;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    // Players Config file to store player data
    private static File playersConfigFile;
    private static FileConfiguration playersConfig;

    public static void createPlayers() {
        playersConfigFile = new File(Bukkit.getServer().getPluginManager().getPlugin("EcoNut").getDataFolder(), "players.yml");
        if (!playersConfigFile.exists()) {
            try {
                playersConfigFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        playersConfig = new YamlConfiguration().loadConfiguration(playersConfigFile);
    }

    public static FileConfiguration getPlayersConfig() {
        return playersConfig;
    }

    public static void savePlayersConfig() {
        try {
            playersConfig.save(playersConfigFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reload(){
        playersConfig = YamlConfiguration.loadConfiguration(playersConfigFile);
    }

    public static void createPlayer(String uuid, String name){
        playersConfig.set(uuid, name);
        savePlayersConfig();
    }


    public static void createDefaultConfig(){
        EcoNut.getPlugin().getConfig().options().copyDefaults();
        EcoNut.getPlugin().saveDefaultConfig();

    }

}