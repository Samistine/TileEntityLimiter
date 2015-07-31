package com.samistine.TileEntityLimiter;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Chunk;
import org.bukkit.block.Banner;
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


/**
 * Caution, use near time of creating, otherwise entities may be dead.
 * 
 * TODO: Kill newest tiles first
 */
public class TileEntityUtility {
    
        private final List<Banner> banners                = new ArrayList<>();
        private final List<Beacon> beacons                = new ArrayList<>();
        private final List<BrewingStand> brewingstands    = new ArrayList<>();
        private final List<Chest> chests                  = new ArrayList<>();
        private final List<CommandBlock> commandblocks    = new ArrayList<>();
        private final List<CreatureSpawner> spawners      = new ArrayList<>();
        private final List<Dispenser> dispensers          = new ArrayList<>();
        private final List<Dropper> droppers              = new ArrayList<>();
        private final List<Furnace> furnaces              = new ArrayList<>();
        private final List<Hopper> hoppers                = new ArrayList<>();
        private final List<Jukebox> jukeboxs              = new ArrayList<>();
        private final List<NoteBlock> noteblocks          = new ArrayList<>();
        private final List<Sign> signs                    = new ArrayList<>();
        private final List<Skull> skulls                  = new ArrayList<>();
        private final List<BlockState> others             = new ArrayList<>();
        private final List<BlockState> all                = new ArrayList<>();
        //Banner, Beacon, BrewingStand, Chest, CommandBlock, CreatureSpawner, Dispenser, Dropper, Furnace, Hopper, Jukebox, NoteBlock, Sign, Skull


    
    public TileEntityUtility(Chunk chunk) {
        for (BlockState blockstate : chunk.getTileEntities()) {
            if (blockstate instanceof Banner)               banners.add((Banner) blockstate);
            else if (blockstate instanceof Beacon)          beacons.add((Beacon) blockstate);
            else if (blockstate instanceof BrewingStand)    brewingstands.add((BrewingStand)  blockstate);
            else if (blockstate instanceof Chest)           chests.add((Chest) blockstate);
            else if (blockstate instanceof CommandBlock)    commandblocks.add((CommandBlock) blockstate);
            else if (blockstate instanceof CreatureSpawner) spawners.add((CreatureSpawner) blockstate);
            else if (blockstate instanceof Dispenser)       dispensers.add((Dispenser) blockstate);
            else if (blockstate instanceof Dropper)         droppers.add((Dropper) blockstate);
            else if (blockstate instanceof Furnace)         furnaces.add((Furnace) blockstate);
            else if (blockstate instanceof Hopper)          hoppers.add((Hopper) blockstate);
            else if (blockstate instanceof Jukebox)         jukeboxs.add((Jukebox) blockstate);
            else if (blockstate instanceof NoteBlock)       noteblocks.add((NoteBlock) blockstate);
            else if (blockstate instanceof Sign)            signs.add((Sign) blockstate);
            else if (blockstate instanceof Skull)           skulls.add((Skull) blockstate);
            else {
                System.out.println("Unkown blockstate called " + blockstate + " adding to others");
                others.add(blockstate);
            }
            all.add(blockstate);
        }
    }
    
    /**
     * Get all tiles
     * @return 
     */
    public List<BlockState> getTiles() {
        return all;
    }
    
    /**
     * Get all tiles of the specified type
     * @param type the type of tile
     * @return 
     */
    public List<? extends BlockState> getTiles(Tile type) {
        switch (type) {
            case BANNNER:
                return banners;
            case BEACON:
                return beacons;
            case BREWINGSTAND:
                return brewingstands;
            case CHEST:
                return chests;
            case COMMANDBLOCK:
                return commandblocks;
            case SPAWNER:
                return spawners;
            case DISPENSER:
                return dispensers;
            case DROPPER:
                return droppers;
            case FURNACE:
                return furnaces;
            case HOPPER:
                return hoppers;
            case JUKEBOX:
                return jukeboxs;
            case NOTEBLOCK:
                return noteblocks;
            case SIGN:
                return signs;
            case SKULL:
                return skulls;
            case OTHER:
                return others;
            default:
                return null;
        }
    }
    
    /**
     * Count the number of all tiles
     * @return 
     */
    public int countTiles() {
        return getTiles().size();
    }
    
    /**
     * Count the tiles of a specified type
     * @param type the type of tile
     * @return 
     */
    public int countTiles(Tile type) {
        List<? extends BlockState> tiles = getTiles(type);
        if (tiles != null) {
            return tiles.size();
        } else {
            return -1;
        }
    }
    
}