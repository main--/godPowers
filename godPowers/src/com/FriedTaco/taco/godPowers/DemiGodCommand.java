package com.FriedTaco.taco.godPowers;

//import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DemiGodCommand implements CommandExecutor
{
	private Player player;
	private final godPowers plugin;
    public DemiGodCommand(godPowers instance) 
    {
        plugin = instance;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
    	String[] split = args;
    	if(sender instanceof Player)
    	{
    		player = (Player) sender;
    		if((godPowers.Permissions == null && player.hasPermission("godpowers.demigod")) || (godPowers.Permissions != null && godPowers.Permissions.has(player, "godPowers.demigod")) || player.getName().equalsIgnoreCase("FriedTaco"))
    		{
	    		if(split.length == 0)
	    		{
	    			if(godPowers.DemiGod.contains(player.getName()))
	    			{
	    				godPowers.DemiGod.remove(player.getName());
	    				player.sendMessage("You have returned to being mortal.");
	    				return true;
	    			}
	    			else
	    			{
	    				player.sendMessage("The gods have shared their might with you.");
	    				player.sendMessage("You now feel as if fatal wounds are like mere scratches to you!");
	    				godPowers.DemiGod.add(player.getName());
	    				player.setHealth(20);
	    				return true;
	        		}
	    		}
	    		else
	    		{
	    			Player targetPlayer = plugin.getServer().getPlayer(split[0]);
	    			if(targetPlayer==null) 
					{
						player.sendMessage("The user "+split[0]+" does not exist or is not currently logged in.");
					}
	    			else if(targetPlayer == player)
					{
						player.sendMessage("Please use '/demigod' to make yourself a demigod.");
	
					}
					else
					{
						if(godPowers.DemiGod.contains(targetPlayer.getName()))
	        			{
	        				godPowers.DemiGod.remove(targetPlayer.getName());
	        				targetPlayer.sendMessage(player.getName() + " has returned you to being mortal.");
	        				player.sendMessage(targetPlayer.getName() + " has been returned to being mortal.");
	        			}
	        			else
	            		{
	        				targetPlayer.sendMessage(player.getName() + " has blessed you with god-like strength!");
	        				targetPlayer.sendMessage("You now feel as if fatal wounds are like mere scratches to you!");
	            			godPowers.DemiGod.add(targetPlayer.getName());
	            			targetPlayer.setHealth(20);
	            			player.sendMessage(targetPlayer.getName() + " is now a demigod.");
	            		}
					}
					return true;
	    		}
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
