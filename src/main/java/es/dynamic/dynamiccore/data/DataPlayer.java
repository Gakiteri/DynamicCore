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
        this.status = "online";
        this.pvp = true; //get from game?
        this.role = "default"; //get from luckperms
        this.lastTime = new Date();
        this.timeOnline = 0;
        this.balance = 0;
        this.initPlayer();


    }



    /** NAME **/

    /** TIME **/
    public void updateTime() {

        long timeNow;

        new MngSql().

        // desde la conexion, acctualiza el tiempo "val"

    }
    public long getTime() {

        // consulta a base y devuelve time



        return time;
    }

    public Date getLastTime() throws SQLException, ClassNotFoundException {
        ResultSet result = mngSql.query("SELECT lastTime FROM players WHERE uuid = " + this.uuid);
        return result.getDate("lastTime");
    }
    public int getTimeOnline() throws SQLException, ClassNotFoundException {
        ResultSet result = mngSql.query("SELECT timeOnline FROM players WHERE uuid = " + this.uuid);
        return result.getInt("timeOnline");
    }

    private void initPlayer() throws SQLException, ClassNotFoundException {

        ResultSet result = mngSql.query("SELECT * FROM players WHERE uuid = " + this.uuid);
        //get
        if(result.getFetchSize() == 0) {

            String query = "INSERT INTO players (uuid, username, status, pvp, role, lastTime, timeOnline, balance) VALUES (%d, %s, %s, %d, %s, %s, %s, %d)";
            mngSql.update(String.format(query,
                    this.uuid,
                    this.username,
                    this.status,
                    this.pvp,
                    this.role,
                    this.lastTime.toString(),
                    this.timeOnline,
                    this.balance));
        } else {

        }
        mngSql.getStatement().close();
    }

}
