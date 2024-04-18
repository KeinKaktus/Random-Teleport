package de.kaktus.main.utils;

import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class FileManager {

    File file = new File("plugins/RandomTeleport", "config.yml");
    public YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public void getConfig(){
        if (cfg.getString("Permission") == null){
            cfg.set("Permission", Strings.noPerm);
        }else{
            Strings.noPerm = cfg.getString("Permission");
        }
        if (cfg.getString("Title") == null){
            cfg.set("Title", Strings.title);
        }else{
            Strings.title = cfg.getString("Title");
        }
        if (cfg.getString("Sound") == null){
            cfg.set("Sound", Strings.teleportSound);
        }else{
            Strings.teleportSound = Sound.valueOf(cfg.getString("Sound"));
        }
        savecfg();
    }

    public void savecfg(){
        try {
            cfg.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
