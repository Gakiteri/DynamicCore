package es.dynamic.dynamiccore.functions;

import es.dynamic.dynamiccore.Variables;
import es.dynamic.dynamiccore.data.DataPlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

import static org.bukkit.Bukkit.getPluginManager;

public class MngConf {

    private Plugin plugin = getPluginManager().getPlugin(Variables.pluginName);
    private FileConfiguration config = plugin.getConfig();

    public void load() {

        // Load players playtime
        config.getMapList("database.config").forEach(set -> {
            set.forEach((key, value) -> {
                Variables.configSql.put((String) key, value);
            });
        });

    }


    public void save() {

        // Saves to file
        plugin.saveConfig();

    }

}
