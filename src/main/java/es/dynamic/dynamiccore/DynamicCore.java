package es.dynamic.dynamiccore;

import es.dynamic.dynamiccore.events.*;
import es.dynamic.dynamiccore.functions.*;
import es.dynamic.dynamiccore.tasks.*;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.sql.SQLException;

public final class DynamicCore extends JavaPlugin {

    @Override
    public void onEnable() {

        Server server = getServer();
        PluginManager pluginManager = server.getPluginManager();
        Variables.pluginName = this.getName();

        /** COMMAND REGISTRATION **/
//        this.getCommand("get").setExecutor(new CmdGet());


        /** EVENT REGISTRATION **/
        pluginManager.registerEvents(new OnJoin(), this);

        /** TASK REGISTRATION **/
        BukkitTask UpdatePlaytime = new UpdatePlaytime(this).runTaskTimer(this, 0L, 20L);


        /** GET PLUGIN DIRECTORY **/
        Variables.dirPlugin = MngFile.path(getDataFolder());

        /** GET CONFIG **/
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        new MngConf().load();

        try {
            MngSql sql = new MngSql();
            sql.initDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Plugin startup logic
        getLogger().info("DynamicCore plugin initialised");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
