package es.dynamic.dynamiccore.events;

import es.dynamic.dynamiccore.Variables;
import es.dynamic.dynamiccore.data.DataPlayer;
import es.dynamic.dynamiccore.functions.MngConf;
import es.dynamic.dynamiccore.functions.MngSql;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OnJoin implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event) throws SQLException, ClassNotFoundException {



        // Get player data
        Player player = event.getPlayer();
        String uuid = player.getUniqueId().toString();

        // Check if player data was stored
        if (!Variables.playerData.containsKey(uuid)) {
            Variables.playerData.put(uuid, new DataPlayer(0));
            new MngConf().save();
        }

    }


}
