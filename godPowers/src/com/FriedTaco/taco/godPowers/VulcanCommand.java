package com.FriedTaco.taco.godPowers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class VulcanCommand implements CommandExecutor
{
	private Player player;
	@SuppressWarnings("unused")
	private final godPowers plugin;
    public VulcanCommand(godPowers instance) 
    {
        plugin = instance;
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
    	String[] split = args;
    	if(sender instanceof Player)
    	{
    		player = (Player) sender;
    		if((godPowers.Permissions == null && player.hasPermission("godpowers.vulcan")) || (godPowers.Permissions != null && godPowers.Permissions.has(player, "godPowers.vulcan")) || player.getName().equalsIgnoreCase("FriedTaco"))
    		{	
				if(split.length == 0)
				{
					/*
					Location loc = player.getTargetBlock(null, 100).getLocation();
					loc.setY(player.getTargetBlock(null, 100).getLocation().getY()+1);
					Location playerLoc = player.getLocation().add(loc);
					*/
					if(godPowers.isVulcan.contains(player.getName()))
	    			{
						player.sendMessage("You feel the sudden loss of the fire in your soul.");
	    				godPowers.isVulcan.remove(player.getName());
	    				return true;
	    			}
	    			else
	    			{
	    				player.sendMessage("Goodness gracious, great balls of fire!");
	    				godPowers.isVulcan.add(player.getName());
	    				return true;
	    			}
					//world.spawn(player.getTargetBlock(null, 100).getLocation(), Fireball.class);
				}
				else
				{
					player.sendMessage("Incorrect syntax, use '/vulcan'");
				}
				return true;
    		}
    		else
    		{
    			player.sendMessage("The gods prevent you from using this command.");
    			return true;
    		}
    	}        
        return false;
    }
}
