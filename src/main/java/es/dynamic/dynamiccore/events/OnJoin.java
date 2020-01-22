package es.dynamic.dynamiccore.events;

import es.dynamic.dynamiccore.Variables;
import es.dynamic.dynamiccore.data.DataPlayer;
import es.dynamic.dynamiccore.functions.MngConf;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        // Get player data
        Player player = event.getPlayer();
        String uuid = player.getUniqueId().toString();

        // Check if player data was stored
        if (!Variables.playerData.containsKey(uuid)) {
            Variables.playerData.put(uuid, new DataPlayer(player));
            new MngConf().save();
        }

    }


}
