/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samistine.TileEntityLimiter.conf;

import java.util.Map;
import java.util.TreeMap;
import org.bukkit.block.Beacon;
import org.bukkit.block.BlockState;
import org.bukkit.block.BrewingStand;
import org.bukkit.block.Chest;
import org.bukkit.block.CommandBlock;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.Dispenser;
import org.bukkit.block.Dropper;
import org.bukkit.block.Furnace;
import org.bukkit.block.Hopper;
import org.bukkit.block.Jukebox;
import org.bukkit.block.NoteBlock;
import org.bukkit.block.Sign;
import org.bukkit.block.Skull;
import org.bukkit.configuration.ConfigurationSection;

/**
 *
 * @author Samuel
 */
public class Limits {

    private final Map<TileLimit, Integer> mylimits;
    private final ConfigurationSection section;

    public Limits(int limit_BEACON, int limit_BREWINGSTAND, int limit_CHEST, int limit_COMMANDBLOCK, int limit_DISPENSER, int limit_DROPPER, int limit_FURNACE, int limit_HOPPER, int limit_JUKEBOX, int limit_NOTEBLOCK, int limit_SIGN, int limit_SKULL, int limit_SPAWNER, int limit_OTHER, int limit_ALL, ConfigurationSection section) {
        mylimits = new TreeMap<>();
        mylimits.put(TileLimit.BEACON, limit_BEACON);
        mylimits.put(TileLimit.BREWINGSTAND, limit_BREWINGSTAND);
        mylimits.put(TileLimit.CHEST, limit_CHEST);
        mylimits.put(TileLimit.COMMANDBLOCK, limit_COMMANDBLOCK);
        mylimits.put(TileLimit.DISPENSER, limit_DISPENSER);
        mylimits.put(TileLimit.DROPPER, limit_DROPPER);
        mylimits.put(TileLimit.FURNACE, limit_FURNACE);
        mylimits.put(TileLimit.HOPPER, limit_HOPPER);
        mylimits.put(TileLimit.JUKEBOX, limit_JUKEBOX);
        mylimits.put(TileLimit.NOTEBLOCK, limit_NOTEBLOCK);
        mylimits.put(TileLimit.SIGN, limit_SIGN);
        mylimits.put(TileLimit.SKULL, limit_SKULL);
        mylimits.put(TileLimit.SPAWNER, limit_SPAWNER);
        mylimits.put(TileLimit.OTHER, limit_OTHER);
        mylimits.put(TileLimit.ALL, limit_ALL);
        this.section = section;
    }

    /**
     * Get the current limit for the specified tile type
     *
     * @param limit
     * @return
     */
    public int getLimit(TileLimit limit) {
        return mylimits.get(limit);
    }

    /**
     *
     * Make sure to save the FileConfiguration after calling this using
     *
     * @param limit
     * @param newLimit
     */
    public void setLimit(TileLimit limit, int newLimit) {
        mylimits.put(limit, newLimit);
    }

    /**
     * Set the @ConfigurationSection with values from Limits<br>
     * You most likely want to call plugin.saveConfig() after this
     */
    public void save() {
        for (TileLimit tileLimitEnum : TileLimit.values()) {
            section.set(tileLimitEnum.name(), getLimit(tileLimitEnum));
        }
    }

    /**
     * Used to verify config
     *
     * @param conf The configuration section containing the limit data
     * @return
     */
    public static Limits fixIfBrokenConfig(ConfigurationSection conf) {
        Limits limits = new Limits(
                conf.getInt(TileLimit.BEACON.name(), -1),
                conf.getInt(TileLimit.BREWINGSTAND.name(), -1),
                conf.getInt(TileLimit.CHEST.name(), -1),
                conf.getInt(TileLimit.COMMANDBLOCK.name(), -1),
                conf.getInt(TileLimit.DISPENSER.name(), -1),
                conf.getInt(TileLimit.DROPPER.name(), -1),
                conf.getInt(TileLimit.FURNACE.name(), -1),
                conf.getInt(TileLimit.HOPPER.name(), -1),
                conf.getInt(TileLimit.JUKEBOX.name(), -1),
                conf.getInt(TileLimit.NOTEBLOCK.name(), -1),
                conf.getInt(TileLimit.SIGN.name(), -1),
                conf.getInt(TileLimit.SKULL.name(), -1),
                conf.getInt(TileLimit.SPAWNER.name(), -1),
                conf.getInt(TileLimit.OTHER.name(), -1),
                conf.getInt(TileLimit.ALL.name(), -1),
                conf
        );
        if (limits.fixValues()) {
            limits.save();
        }
        return limits;
    }

    private boolean fixValues() {
        boolean wasFixed = false;
        for (TileLimit tileLimitEnum : TileLimit.values()) {
            int tileLimit = getLimit(tileLimitEnum);
            if (tileLimit == -1) {
                wasFixed = true;
                setLimit(tileLimitEnum, tileLimitEnum.getDefaultLimit());
            }
        }
        return wasFixed;
    }

    public static Map<String, Integer> getDefaults() {
        Map<String, Integer> map = new TreeMap<>();
        for (TileLimit tileLimit : TileLimit.values()) {
            map.put(tileLimit.name(), tileLimit.getDefaultLimit());
        }
        return map;
    }

    public enum TileLimit {

        BEACON("Beacon", Beacon.class, 10),
        BREWINGSTAND("BREWINGSTAND", BrewingStand.class, 30),
        CHEST("CHEST", Chest.class, 50),
        COMMANDBLOCK("COMMANDBLOCK", CommandBlock.class, 10),
        DISPENSER("DISPENSER", Dispenser.class, 50),
        DROPPER("DROPPER", Dropper.class, 10),
        FURNACE("FURNACE", Furnace.class, 30),
        HOPPER("HOPPER", Hopper.class, 20),
        JUKEBOX("JUKEBOX", Jukebox.class, 10),
        NOTEBLOCK("NOTEBLOCK", NoteBlock.class, 20),
        SIGN("SIGN", Sign.class, 50),
        SKULL("SKULL", Skull.class, 10),
        SPAWNER("SPAWNER", CreatureSpawner.class, 10),
        OTHER("OTHER", BlockState.class, 0),
        ALL("ALL", BlockState.class, 100);

        private final String friendly_name;

        private final Class<? extends BlockState> blockstate;
        private final int defaultLimit;

        private TileLimit(String friendly_name, Class<? extends BlockState> blockstate, int defaultLimit) {
            this.friendly_name = friendly_name;
            this.blockstate = blockstate;
            this.defaultLimit = defaultLimit;
        }

        public Class<? extends BlockState> getExtendingClass() {
            return blockstate;
        }

        public int getDefaultLimit() {
            return defaultLimit;
        }

        @Override
        public String toString() {
            return friendly_name;
        }

    }
}
