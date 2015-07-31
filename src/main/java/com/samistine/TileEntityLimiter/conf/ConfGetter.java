/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samistine.TileEntityLimiter.conf;

import com.samistine.TileEntityLimiter.Main;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.bukkit.configuration.file.FileConfiguration;

/**
 *
 * @author Samuel
 */
public abstract class ConfGetter {

    private final String confSection;
    private final FileConfiguration conf;

    public ConfGetter(FileConfiguration conf, String confSection) {
        this.conf = conf;
        this.confSection = confSection;
    }

    public String getSection() {
        return confSection;
    }

    public boolean isEnabled() {
        return conf.getBoolean(getSection() + ".Enabled");
    }

    public Map<String, Object> getLimits() {
        try {
            return conf.getConfigurationSection(".limits").getValues(false);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error with config, the issue pertains to the Limits List under " + confSection);
        }
        Main.DisablePlugin();
        return null;
    }
}
