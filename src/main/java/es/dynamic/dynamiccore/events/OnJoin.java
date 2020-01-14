package es.dynamic.dynamiccore.events;

import es.dynamic.dynamiccore.Variables;
import es.dynamic.dynamiccore.data.DataPlayer;
import es.dynamic.dynamiccore.functions.MngConf;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class OnJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        // Get player data
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        String uuidStr = uuid.toString();

        // Check if player data was stored
        if (!Variables.playerData.containsKey(uuidStr)) {
            Variables.playerData.put(uuidStr, new DataPlayer(uuid));
            new MngConf().save();
        }

    }


}
