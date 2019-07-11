package org.wnut.EcoNut.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.wnut.EcoNut.Managers.ConfigManager;
import sun.security.krb5.Config;

public class WnutListener implements Listener{

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        String player = e.getPlayer().getName();
        String uuid = e.getPlayer().getUniqueId().toString();

        ConfigManager.createPlayer(uuid, player);

    }
}
