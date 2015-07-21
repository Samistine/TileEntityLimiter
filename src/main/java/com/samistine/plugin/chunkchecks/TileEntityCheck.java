package com.samistine.plugin.chunkchecks;


/**
 * Optimized for use when player places item
 * 
 * TODO: Kill newest tiles first
 */
public class TileEntityCheck {
    
        private List<Banner> banners; 
        private List<Beacon> beacons;
        private List<BrewingStand> brewingstands;
        private List<Chest> chests;
        private List<CommandBlock> commandblocks;
        private List<CreatureSpawner> spawners;
        private List<Dispenser> dispensers;
        private List<Dropper> droppers;
        private List<Furnace> furnaces;
        private List<Hopper> hoppers;
        private List<Jukebox> jukeboxs;
        private List<NoteBlock> noteblocks;
        private List<Sign> signs;
        private List<Skull> skulls;
        private List<? extends BlockState> others;
        private List<? extends BlockState> all;
        //Banner, Beacon, BrewingStand, Chest, CommandBlock, CreatureSpawner, Dispenser, Dropper, Furnace, Hopper, Jukebox, NoteBlock, Sign, Skull


    
    public TileEntityCheck(Chunk chunk) {
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
    
    
    public String
    
    
    @Override
    public String message(String fromConfig) {
        fromConfig = fromConfig.replace("tiles_types", blocks);
        fromConfig = fromConfig.replace("tiles_total", total);
        fromConfig = fromConfig.replace("tiles_abovemax", aboveMax);
        return fromConfig;
    }
    
    private class Limits {
        
        private int banner = 50;
        private int beacon = 10;
        private int brewingstand = 50;
        private int chest = 50;
        private int commandblock = 5;
        private int spawner
        private int dispenser = 50;
        private int dropper = 50;
        private int furnace = 50;
        private int hopper = 50;
        private int jukebox = 50;
        private int noteblock = 50;
        private int sign = 300;
        private int skull = 300;
        private int total = 1000;
    }
    
}