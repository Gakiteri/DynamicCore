package es.dynamic.dynamiccore.functions;

import es.dynamic.dynamiccore.Variables;
import es.dynamic.dynamiccore.data.DataPlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getPluginManager;

public class MngConf {

    private Plugin plugin = getPluginManager().getPlugin(Variables.pluginName);
    private FileConfiguration config = plugin.getConfig();

    public void load() {

        // Load players playtime
        config.getMapList("players.playtime").forEach(set -> {
            set.forEach((player, time) -> {
                Variables.playerData.put((String) player, new DataPlayer(Integer.parseInt((String) time)));
            });
        });

        config.getMapList("database.config").forEach(set -> {
            set.forEach((key, value) -> {
                Variables.configSql.put((String) key, value);
            });
        });

    }


    public void save() {

        // Add players playtime
        Variables.playerData.forEach((player, dataset) -> {
            config.set("players.playtime." + player, dataset.getTime());
        });

        // Saves to file
        plugin.saveConfig();

    }

}
