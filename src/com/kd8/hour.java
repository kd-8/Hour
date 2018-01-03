package com.kd8;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class hour extends JavaPlugin{
	
	public void onEnable(){
		
		CommandExecutor oe = new command();
		getCommand("hour").setExecutor(oe);
		
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
			public void run() {
				
				for(World w : Bukkit.getServer().getWorlds()){
					w.setGameRuleValue("doDaylightCycle", "false");
					
					SimpleDateFormat Hours = new SimpleDateFormat("HH");
					SimpleDateFormat Minutes = new SimpleDateFormat("mm");
					SimpleDateFormat Days = new SimpleDateFormat("dd");
					
					String Hour = Hours.format(new Date());
					String Minute = Minutes.format(new Date());
					String Day = Days.format(new Date());
					
					int hours = Integer.parseInt(Hour);
					int minutes = Integer.parseInt(Minute);
					int days = Integer.parseInt(Day);
					
					hours = (hours*1000)+18000;
					if(hours >= 24000){hours-=24000;}
					days = (days*24000)+hours;
					minutes*=16;
					int Time = days + minutes;
					w.setFullTime(Time);
					
				}
				
			}
			
			
			
		},0,20*30);
		
	}
	
	public void onDisable(){
		
	}

}
