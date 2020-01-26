package es.dynamic.dynamiccore.tasks;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.UserDoesNotExistException;
import es.dynamic.dynamiccore.DynamicCore;
import es.dynamic.dynamiccore.Variables;
import es.dynamic.dynamiccore.data.DataPlayer;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;
import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public class UpdateUser extends BukkitRunnable {

    DynamicCore plugin;

    public UpdateUser(DynamicCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {

        if (!getServer().getOnlinePlayers().isEmpty()) {
            getServer().getOnlinePlayers().forEach(player -> {
                // Update Role from LuckPerms Database
                LuckPerms perms = LuckPermsProvider.get();
                String group = Objects.requireNonNull(perms.getUserManager().getUser(player.getUniqueId().toString())).getPrimaryGroup();
                // get money from Essentials Plugin
                int balance = 0;
                try {
                    balance = (int) Economy.getMoneyExact(player.getName()).intValue();
                } catch (UserDoesNotExistException e) {
                    e.printStackTrace();
                }
                // get user and set role,balance and time online in DB
                try {
                    DataPlayer ply = new DataPlayer(player);
                    ply.setRole(group);
                    ply.setTimeOnline();
                    ply.setBalance(balance);
                    ply.updateData();
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }


            });
        }
    }

}
