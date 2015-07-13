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
        // TODO Insert logic to be performed when the plugin is enabled
		getLogger().info("onEnable has been invoked!");
		Bukkit.getPluginManager().registerEvents(this, this);
    }
 
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
		getLogger().info("onDisable has been invoked!");
    }
    
    @EventHandler
    public void onpre(AsyncPlayerChatEvent e) {
    	if (e.getMessage().equalsIgnoreCase("WTF")) {
    		String newMsg = e.getMessage().replace("WTF", "Well Thats Fantastic");
    		e.setMessage(newMsg);
    	}
    }
}
