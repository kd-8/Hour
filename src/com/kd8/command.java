package com.kd8;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command commande, String label, String[] args) {
		Player p = (Player) sender;
		SimpleDateFormat Hour = new SimpleDateFormat("HH:mm");
		String Hours = Hour.format(new Date());
		
		if(label.equalsIgnoreCase("hour")){
			p.sendMessage("§eIt is currently : §6" + Hours + "§e.");
		}
		
		return true;
	}

}
