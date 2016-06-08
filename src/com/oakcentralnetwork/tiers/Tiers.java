package com.oakcentralnetwork.tiers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Tiers extends JavaPlugin implements Listener  {
	
	private ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if(!(sender instanceof Player)) {
			return true;
		} else {
			Player player = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("tiers")) {
				openGUI(player);
			} else if(cmd.getName().equalsIgnoreCase("tier")) {
				openGUI(player);
			}
		}
		return true;
	}
	
	public void openGUI(Player player) {
		Inventory inv = Bukkit.createInventory(null, 28, ChatColor.BLUE + "Tiers");
		
		ItemStack tier1 = new ItemStack(Material.WOOD_SWORD);
		ItemMeta tier1Meta = tier1.getItemMeta();
		ItemStack tier2 = new ItemStack(Material.STONE_SWORD);
		ItemMeta tier2Meta = tier1.getItemMeta();
		ItemStack tier3 = new ItemStack(Material.GOLD_SWORD);
		ItemMeta tier3Meta = tier3.getItemMeta();
		ItemStack tier4 = new ItemStack(Material.IRON_SWORD);
		ItemMeta tier4Meta = tier4.getItemMeta();
		ItemStack tier5 = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta tier5Meta = tier5.getItemMeta();
		
		tier1Meta.setDisplayName(ChatColor.BLUE + "Tier 1");
		tier1.setItemMeta(tier1Meta);
		tier2Meta.setDisplayName(ChatColor.BLUE + "Tier 2");
		tier2.setItemMeta(tier1Meta);
		tier3Meta.setDisplayName(ChatColor.BLUE + "Tier 3");
		tier3.setItemMeta(tier1Meta);
		tier4Meta.setDisplayName(ChatColor.BLUE + "Tier 4");
		tier4.setItemMeta(tier1Meta);
		tier5Meta.setDisplayName(ChatColor.BLUE + "Tier 5");
		tier5.setItemMeta(tier1Meta);
		
		inv.setItem(11, tier1);
		inv.setItem(12, tier2);
		inv.setItem(13, tier3);
		inv.setItem(14, tier4);
		inv.setItem(15, tier5);
		
		player.openInventory(inv);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Tiers")) {
			return;
		}
		
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || 
				!event.getCurrentItem().hasItemMeta()) {
			player.closeInventory();
			return;
		}
		
		switch(event.getCurrentItem().getType()) {
		case WOOD_SWORD:
			String[] commands = getConfig().getString("Tier1.Commands").split(",");
			for(String command : commands) {
				if(command != null) {
					Bukkit.dispatchCommand(console, command);
				}
			}
			player.closeInventory();
			break;
		case STONE_SWORD:
			String[] commands2 = getConfig().getString("Tier2.Commands").split(",");
			for(String command : commands2) {
				if(command != null) {
					Bukkit.dispatchCommand(console, command);
				}
			}
			player.closeInventory();
			break;
		case GOLD_SWORD:
			String[] commands3 = getConfig().getString("Tier3.Commands").split(",");
			for(String command : commands3) {
				if(command != null) {
					Bukkit.dispatchCommand(console, command);
				}
			}
			player.closeInventory();
			break;
		case IRON_SWORD:
			String[] commands4 = getConfig().getString("Tier4.Commands").split(",");
			for(String command : commands4) {
				if(command != null) {
					Bukkit.dispatchCommand(console, command);
				}
			}
			player.closeInventory();
			break;
		case DIAMOND_SWORD:
			String[] commands5 = getConfig().getString("Tier5.Commands").split(",");
			for(String command : commands5) {
				if(command != null) {
					Bukkit.dispatchCommand(console, command);
				}
			}
			player.closeInventory();
			break;
		default:
			player.closeInventory();
			break;
		}
	}
	
	/**
	 * This commented out code is just in case it's requested.
	 */
	
//	@EventHandler
//	public void onPlayerJoin(PlayerJoinEvent event) {
//		event.getPlayer().getInventory().addItem(new ItemStack(Material.COMPASS));
//	}
//	
//	@EventHandler
//	public void onPlayerInteract(PlayerInteractEvent event) {
//		Action a = event.getAction();
//		ItemStack is = event.getItem();
//		
//		if(a == Action.PHYSICAL || is == null || is.getType() == Material.AIR) {
//			return;
//		}
//		
//		if(is.getType() == Material.COMPASS) {
//			openGUI(event.getPlayer());
//		}
//	}
}