package org.testingstuff.spawnprotection;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (isInProtectedArea(e))
            e.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (isInProtectedArea(e))
            e.setCancelled(true);
    }

    public boolean isInProtectedArea(BlockEvent e) {
        int x = e.getBlock().getLocation().getBlockX();
        int z = e.getBlock().getLocation().getBlockZ();
        int xStart = 11;
        int xEnd = 15;
        int zStart = -78;
        int zEnd = -82;
        if (x >= xStart && x <= xEnd)
            return z >= zEnd && z <= zStart;
        return false;
    }
}
