package es.dynamic.dynamiccore;

import es.dynamic.dynamiccore.data.DataPlayer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Variables {

    public static String pluginName;
    public static File dirPlugin;

    public static Map<String, Object> configSql = new HashMap<>();
    public static Map<String, DataPlayer> playerData = new HashMap<>();

}
