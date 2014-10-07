package com.caved_in.commons.command.commands;

import com.caved_in.commons.Messages;
import com.caved_in.commons.command.Command;
import com.caved_in.commons.command.FlagArg;
import com.caved_in.commons.command.Flags;
import com.caved_in.commons.player.Players;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class MoreCommand {
	@Command(identifier = "more", permissions = {"commons.command.more"})
	@Flags(identifier = {"a"})
	public void onMoreCommand(Player player, @FlagArg("a") final boolean allItems) {
		if (allItems) {
			PlayerInventory inventory = player.getInventory();
			inventory.forEach(i -> i.setAmount(i.getMaxStackSize()));
			return;
		}

		if (!Players.hasItemInHand(player)) {
			Players.sendMessage(player, Messages.ITEM_IN_HAND_REQUIRED);
			return;
		}

		ItemStack playerHandItem = player.getItemInHand();
		playerHandItem.setAmount(64);
		player.setItemInHand(playerHandItem);
	}
}
