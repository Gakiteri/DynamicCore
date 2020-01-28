package es.dynamic.dynamiccore.data;

import es.dynamic.dynamiccore.functions.MngSql;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

public class DataPlayer {

    private UUID uuid;
    private String username;
    private String role;
    private String status;
    private Boolean pvp;
    private Date lastTime;
    private int timeOnline;
    private int balance;


    private MngSql mngSql;
    public DataPlayer(Player player) throws SQLException, ClassNotFoundException {
        this.mngSql = new MngSql();
        this.uuid = player.getUniqueId();
        this.username = player.getName();

        this.getData();
    }

    /** PVP **/
    public boolean getPvp() {
        return this.pvp;
    }
    public void setPvp(Boolean pvp) {
        this.pvp = pvp;
    }

    /** ROLE **/
    public String getRole() {
        return this.role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    /** BALANCE **/
    public int getBalance() {
        return this.balance;
    }
    public void setBalance(int balance) throws SQLException {
        this.balance = balance;
    }

    /** LAST TIME ONLINE **/ // join AND leave?
    public Date getLastTime() {
        return this.lastTime;
    }
    public void setLastTime(Date date) throws SQLException {
        this.lastTime = date;
    }

    /** TIME ONLINE **/
    public int getTimeOnline() {
        return this.timeOnline;
    }
    public void setTimeOnline() {
        long diff = this.lastTime.getTime() - (new Date()).getTime();
        long seconds = diff / 1000 % 60;
        this.timeOnline = this.timeOnline + (int) seconds;
    }

    /** INTERACTION WITH DB **/
    private void getData() throws SQLException, ClassNotFoundException {
        ResultSet result = mngSql.query("SELECT * FROM players WHERE uuid = " + this.uuid.toString());

        if(result.getFetchSize() == 0) {
            this.status = "online";
            this.pvp = false; //get from game?
            this.role = "default"; //get from luckperms
            this.lastTime = new Date();
            this.timeOnline = 0;
            this.balance = 0;
            String query = "INSERT INTO players (uuid, username, status, pvp, role, lastTime, timeOnline, balance) VALUES (%d, %s, %s, %d, %s, %s, %s, %d)";
            mngSql.update(String.format(query,
                    this.uuid.toString(),
                    this.username,
                    this.status,
                    this.pvp,
                    this.role,
                    this.lastTime.toString(),
                    this.timeOnline,
                    this.balance
            ));
        } else {
            this.username = result.getString("username");
            this.status = result.getString(" status");
            this.pvp = result.getBoolean("pvp");
            this.role = result.getString("role");
            this.lastTime = result.getDate("lastTime");
            this.timeOnline = result.getInt("timeOnline");
            this.balance = result.getInt("balance");
        }
    }
    public void updateData() throws SQLException {
        String query = "UPDATE players SET (status, pvp, role, lastTime, timeOnline, balance) VALUES (%s, %d, %s, %s, %s, %d)";
        mngSql.update(String.format(query,
                this.status,
                this.pvp,
                this.role,
                this.lastTime.toString(),
                this.timeOnline,
                this.balance
        ));
    }

}
