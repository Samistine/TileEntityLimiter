/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samistine.TileEntityLimiter.conf;

import org.bukkit.configuration.file.FileConfiguration;

/**
 *
 * @author Samuel
 */
public class ConfGetters {

    private final FileConfiguration conf;
    private final TimedCheck timedCheck;
    private final InteractCheck interactCheck;
    private final EntitySpawnCheck entitySpawnCheck;

    public ConfGetters(FileConfiguration conf) {
        this.conf = conf;
        timedCheck = new TimedCheck();
        interactCheck = new InteractCheck();
        entitySpawnCheck = new EntitySpawnCheck();
    }

    public class InteractCheck extends ConfGetter {

        public InteractCheck() {
            super(conf, ConfLocations.Section_InteractCheck);
        }

    }

    public class EntitySpawnCheck extends ConfGetter {

        public EntitySpawnCheck() {
            super(conf, ConfLocations.Section_EntitySpawnCheck);
        }
    }

    public class TimedCheck extends ConfGetter {

        public TimedCheck() {
            super(conf, ConfLocations.Section_TimedCheck);
        }
    }

    public InteractCheck getInteractCheck() {
        return interactCheck;
    }

    public EntitySpawnCheck getEntitySpawnCheck() {
        return entitySpawnCheck;
    }

    public TimedCheck getTimedCheck() {
        return timedCheck;
    }

}
