package com.samistine.TileEntityLimiter;

import com.samistine.TileEntityLimiter.conf.ConfDefaults;
import com.samistine.TileEntityLimiter.conf.ConfGetters;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    ConfGetters confs;
    private static Logger logger;

    @Override
    public void onEnable() {
        logger = getLogger();
        new ConfDefaults().addDefaults(getConfig());
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public List<Chunk> GetLoadedChunks() {
        ArrayList<Chunk> chunks = new ArrayList<>(500);
        for (World world : Bukkit.getWorlds()) {
            chunks.addAll(Arrays.asList(world.getLoadedChunks()));
        }
        return chunks;
    }

    public static Logger getPluginLogger() {
        return logger;
    }

    /**
     * TODO: Confirm this works, test out with broken config
     */
    public static void DisablePlugin() {
        Bukkit.getServer().getPluginManager().disablePlugin(getPlugin(Main.class));
    }

    public static void appendExceptionToFile(Exception e) {
        File file = new File(getPlugin(Main.class).getDataFolder(), "Errors");
        file.mkdirs();
        File efile = new File(file, "Exceptions.txt");
        try {
            try (FileWriter fstream = new FileWriter(efile, true)) {
                BufferedWriter out = new BufferedWriter(fstream);
                PrintWriter pWriter = new PrintWriter(out, true);
                e.printStackTrace(pWriter);
            }
        } catch (IOException ex) {
            getPluginLogger().log(Level.WARNING, "Was not able to get access error file, expect further issues about not being able to save stacktrace to file");
        }
    }

}
