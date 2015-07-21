package com.samistine.plugin;

public class Util {
    
    public GetLoadedChunks() {
        ArrayList<Chunk> chunks = new ArrayList<>(100);
        
        for (World world : Bukkit.getWorlds()) {
            chunks.add(world.getLoadedChunks());
        }
    }
}