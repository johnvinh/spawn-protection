package org.testingstuff.spawnprotection;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SPItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        ItemStack is = new ItemStack(Material.WOODEN_HOE);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName("Set Spawn Protect");
        is.setItemMeta(meta);
        ((Player) sender).getInventory().addItem(is);
        return true;
    }
}
