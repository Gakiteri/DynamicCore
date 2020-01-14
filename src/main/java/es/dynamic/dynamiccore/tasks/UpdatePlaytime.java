package es.dynamic.dynamiccore.tasks;

import es.dynamic.dynamiccore.DynamicCore;
import es.dynamic.dynamiccore.Variables;
import es.dynamic.dynamiccore.data.DataPlayer;
import es.dynamic.dynamiccore.functions.MngConf;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.Date;
import static org.bukkit.Bukkit.getServer;

public class UpdatePlaytime extends BukkitRunnable {

    DynamicCore plugin;

    public UpdatePlaytime(DynamicCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {

        long timeNow = new Date().getTime();

        if (!getServer().getOnlinePlayers().isEmpty()) {
            getServer().getOnlinePlayers().forEach(player -> {

                DataPlayer dataPlayer = Variables.playerData.get(player.getUniqueId().toString());

                long timePlayer = dataPlayer.getTime();
                long delta = timeNow - timePlayer;



                String uuidStr = player.getUniqueId().toString();

                long timePlayer ; //get player time from uuidStr

                timeSaved

                if (Variables.playerData.containsKey(player.getUniqueId().toString())) {
                    Variables.playerData.get(player.getUniqueId().toString()).updateTime();
                }
            });
            new MngConf().save();
        }

    }

}
