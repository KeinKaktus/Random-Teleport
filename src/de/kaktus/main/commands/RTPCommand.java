package de.kaktus.main.commands;

import de.kaktus.main.Main;
import de.kaktus.main.utils.Construct;
import de.kaktus.main.utils.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RTPCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("rtp.use")){
            Strings.countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

                @Override
                public void run() {
                    Strings.time --;
                    if (Strings.time == 5){
                        p.sendTitle(Strings.title.replaceAll("&", "§"), "§7" + Strings.time);
                        p.playSound(p.getLocation(), Strings.teleportSound, 2, 1);
                    }
                    if (Strings.time == 4){
                        p.sendTitle(Strings.title.replaceAll("&", "§"), "§7" + Strings.time);
                        p.playSound(p.getLocation(), Strings.teleportSound, 2, 1);
                    }
                    if (Strings.time == 3){
                        p.sendTitle(Strings.title.replaceAll("&", "§"), "§7" + Strings.time);
                        p.playSound(p.getLocation(), Strings.teleportSound, 2, 1);
                    }
                    if (Strings.time == 2){
                        p.sendTitle(Strings.title.replaceAll("&", "§"), "§7" + Strings.time);
                        p.playSound(p.getLocation(), Strings.teleportSound, 2, 1);
                    }
                    if (Strings.time == 1){
                        p.sendTitle(Strings.title.replaceAll("&", "§"), "§7" + Strings.time);
                        p.playSound(p.getLocation(), Strings.teleportSound, 2, 1);
                    }
                    if (Strings.time == 0){
                        Construct construct = new Construct();
                        p.sendTitle("", "");
                        Bukkit.getScheduler().cancelTask(Strings.countdown);
                        construct.teleportPlayer(p);
                    }
                }
            }, 20, 20);
        }else{
            p.sendMessage(Strings.noPerm.replaceAll("&", "§"));
        }
        return false;
    }
}
