package es.dynamic.dynamiccore.data;

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

        long timeNow;

        new MngSql().

        // desde la conexion, acctualiza el tiempo "val"

    }
    public long getTime() {

        // consulta a base y devuelve time



        return time;
    }

}
