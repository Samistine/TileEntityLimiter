/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samistine.TileEntityLimiter.conf;

import com.samistine.TileEntityLimiter.Main;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Samuel
 */
public class ConfDefaults {

    private static Map<String, Integer> getLimits() {
        EnumSet.allOf(Limits.TileLimit.class);
        return new TreeMap<String, Integer>() {
            {
                put("BEACON", 10);
                put("BREWINGSTAND", 30);
                put("CHEST", 50);
                put("COMMANDBLOCK", 10);
                put("SPAWNER", 10);
                put("DISPENSER", 50);
                put("DROPPER", 10);
                put("FURNACE", 30);
                put("HOPPER", 20);
                put("JUKEBOX", 10);
                put("NOTEBLOCK", 20);
                put("SIGN", 50);
                put("SKULL", 10);
                put("OTHER", 0);
                put("ALL", 100);
            }
        };
    }

    Map<String, Object> interactcheck = new LinkedHashMap<String, Object>() {
        {
            put("Enabled", true);
            put("FireCheckWithAir", false);
            put("Limits", Limits.getDefaults());
        }
    };

    Map<String, Object> entityspawncheck = new LinkedHashMap<String, Object>() {
        {
            put("Enabled", true);
            put("Limits", Limits.getDefaults());
        }
    };

    Map<String, Object> timedcheck = new LinkedHashMap<String, Object>() {
        {
            put("Enabled", false);
            put("TimedCheckIntervalInTicks", 10);
            put("Limits", Limits.getDefaults());
        }
    };

    public static String getHeader() {
        StringBuilder sb = new StringBuilder(300);

        return sb.toString();
    }

    public void addDefaults(FileConfiguration conf) {
        try {
            conf.options().header(getHeader());
            conf.addDefault(ConfLocations.Section_InteractCheck, interactcheck);
            conf.addDefault(ConfLocations.Section_EntitySpawnCheck, entityspawncheck);
            conf.addDefault(ConfLocations.Section_TimedCheck, timedcheck);
            bukkitAPIIssueFix(conf);
            Limits.fixIfBrokenConfig(conf.getConfigurationSection(ConfLocations.Section_InteractCheck + ".Limits"));
            Limits.fixIfBrokenConfig(conf.getConfigurationSection(ConfLocations.Section_EntitySpawnCheck + ".Limits"));
            Limits.fixIfBrokenConfig(conf.getConfigurationSection(ConfLocations.Section_TimedCheck + ".Limits"));
        } catch (NullPointerException ex) {
            Main.getPlugin(Main.class).getLogger().log(Level.SEVERE, "Something went wrong with the config,"
                    + " you might want to try renaming it and letting a new one regenerate");
            Main.appendExceptionToFile(ex);
        }
    }

    /**
     * For some reason, even though we have defaults set,
     * .getConfigurationSection returns null if it hasn't been saved yet
     *
     * @param conf
     */
    public void bukkitAPIIssueFix(FileConfiguration conf) {
        if (!conf.isConfigurationSection(ConfLocations.Section_InteractCheck + ".Limits")) {
            conf.createSection(ConfLocations.Section_InteractCheck + ".Limits");
        }
        if (!conf.isConfigurationSection(ConfLocations.Section_EntitySpawnCheck + ".Limits")) {
            conf.createSection(ConfLocations.Section_EntitySpawnCheck + ".Limits");
        }
        if (!conf.isConfigurationSection(ConfLocations.Section_TimedCheck + ".Limits")) {
            conf.createSection(ConfLocations.Section_TimedCheck + ".Limits");
        }
    }

}
