package es.dynamic.dynamiccore.data;

import es.dynamic.dynamiccore.Variables;
import es.dynamic.dynamiccore.functions.MngSql;

import java.util.Date;
import java.util.UUID;

public class DataPlayer {

    private UUID uuid;
    private String name;
    private long time;

    public DataPlayer(UUID uuid) {

        this.uuid = uuid;

        new MngSql(). // check for record -> send uuid

    }

    /** SET ALL **/
    public void setAll(DataPlayer val) {
        name = val.getName();
        time = val.getTime();
    }


    /** NAME **/
    public void setName(String val) {
        name = val;
    }
    public String getName() {
        return name;
    }

    /** TIME **/
    public void updateTime() {

        long timeNow = new Date().getTime();
        long timePlayer = getTime();

        int totalPlaytime = timePlayer + ((timeNow - new MngSql(). )//timeFromSaved; ) % 1000

        new Date().getTime();

        new MngSql(). // save totalPlaytime

    }
    public long getTime() {

        // consulta a base y devuelve tiempo jugado del jugador que juega en el servidor de jugar al juego


        return time;
    }

}
