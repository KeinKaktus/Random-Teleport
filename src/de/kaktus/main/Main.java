package de.kaktus.main;

import de.kaktus.main.commands.RTPCommand;
import de.kaktus.main.utils.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    public static FileManager fm;

    @Override
    public void onEnable() {
        instance = this;
        fm = new FileManager();
        fm.getConfig();
        fm.savecfg();
        EventManager();
        getCommand("randomtp").setExecutor(new RTPCommand());
    }

    public void EventManager(){
        PluginManager pm = Bukkit.getPluginManager();
    }

    public static Main getInstance() {
        return instance;
    }
}
