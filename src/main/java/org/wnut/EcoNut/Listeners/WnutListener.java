package org.wnut.EcoNut.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.wnut.EcoNut.EcoNut;
import org.bukkit.event.Listener;

public class WnutListener implements Listener{

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        EcoNut.getEconomy().createPlayerAccount(player);

    }
}
