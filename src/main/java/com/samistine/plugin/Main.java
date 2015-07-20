package com.samistine.plugin;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
    @Override
    public void onEnable() {
	Bukkit.getPluginManager().registerEvents(this, this);
    }
    
    @EventHandler
    public void onChunkLoad(AsyncPlayerChatEvent e) {
    	if (e.getMessage().equalsIgnoreCase("WTF")) {
    		String newMsg = e.getMessage().replace("WTF", "Well Thats Fantastic");
    		e.setMessage(newMsg);
    	}
    }
   
}
