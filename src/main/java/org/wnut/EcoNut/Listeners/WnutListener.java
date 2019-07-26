package org.wnut.EcoNut.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.wnut.EcoNut.Configurations.Accounts;
import org.wnut.EcoNut.Configurations.Players;

public class WnutListener implements Listener{

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        String player = e.getPlayer().getName();
        String uuid = e.getPlayer().getUniqueId().toString();

        Players players = new Players();
        players.create(uuid, player);

        Accounts accounts = new Accounts(uuid);

    }
}
