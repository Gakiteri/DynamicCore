package es.dynamic.dynamiccore.events;

import es.dynamic.dynamiccore.data.DataPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLException;

public class OnJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) throws SQLException, ClassNotFoundException {
        // Init Player in Database if not created
        new DataPlayer(event.getPlayer());

    }


}
