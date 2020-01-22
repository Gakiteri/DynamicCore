package es.dynamic.dynamiccore.tasks;

import es.dynamic.dynamiccore.DynamicCore;
import es.dynamic.dynamiccore.Variables;
import org.bukkit.scheduler.BukkitRunnable;
import static org.bukkit.Bukkit.getServer;

public class UpdatePlaytime extends BukkitRunnable {

    DynamicCore plugin;

    public UpdatePlaytime(DynamicCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {

        if (!getServer().getOnlinePlayers().isEmpty()) {
            getServer().getOnlinePlayers().forEach(player -> {

                Variables.playerData.get(player.getUniqueId().toString()).updateTime();

            });
        }

    }

}
