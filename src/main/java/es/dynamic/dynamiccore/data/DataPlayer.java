package es.dynamic.dynamiccore.data;

public class DataPlayer {

    private String name;
    private int time;

    public DataPlayer (int time) {
        this.time = time;
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
        time = time + 1;
    }
    public int getTime() {
        return time;
    }

}
