package org.wnut.EcoNut.Managers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.wnut.EcoNut.EcoNut;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    // Players Config file to store player data
    private static File file;
    private static FileConfiguration config;

    protected static String fileName;

    public ConfigManager(String fileName){
        this.fileName = fileName;
    }

    public void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("EcoNut").getDataFolder(), fileName + ".yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        config = new YamlConfiguration().loadConfiguration(file);
    }

    public static void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key){
        return config.getString(key);
    }

    public static void reload(){
        config = YamlConfiguration.loadConfiguration(file);
    }

    public void create(String key, String value){
        config.set(key, value);
        save();
    }

    public void create(String key, Integer value){
        config.set(key, value);
        save();
    }

    public void set(String key, String value){
        config.set(key, value);
        save();
    }

    public void set(String key, Integer value){
        config.set(key, value);
        save();
    }

    public void set(String key, double value){
        config.set(key, value);
        save();
    }

    public boolean keyExists(String key){
        if (config.isSet(key)) {
            return true;
        } else {
            return false;
        }
    }

    public static void createDefaultConfig(){
        // Create default configs using config.yml
        EcoNut.getPlugin().getConfig().options().copyDefaults();
        EcoNut.getPlugin().saveDefaultConfig();

        // Create data directory if not exists
        File dataFile = new File(Bukkit.getServer().getPluginManager().getPlugin("EcoNut").getDataFolder(), "data");
        if (!dataFile.exists()){
            dataFile.mkdir();
        }

    }


}