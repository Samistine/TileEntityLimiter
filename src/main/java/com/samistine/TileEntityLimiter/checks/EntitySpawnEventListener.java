/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samistine.TileEntityLimiter.checks;

import com.samistine.TileEntityLimiter.TileEntityUtility;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

/**
 *
 * @author Samuel
 */
public class EntitySpawnEventListener implements Listener {
    
    @EventHandler (ignoreCancelled = true, priority = EventPriority.LOW)
    public void onEntitySpawn(EntitySpawnEvent event) {
        TileEntityUtility util = new TileEntityUtility(event.getLocation().getChunk());
        
    }
}
