package coolclk.bedexplosion;

import org.bukkit.Material;
import org.bukkit.event.*;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BedExplosion extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new Listener(), this);
        this.getLogger().info("Thanks for your using! Welcome to visit my github profile https://github.com/CoolCLK/");
        this.getLogger().info("Disabled the bed explosion of NETHER / THE_END environment successfully!");
    }

    public static class Listener implements org.bukkit.event.Listener {
        @EventHandler
        public void onPlayerInteract(PlayerInteractEvent event) {
            try {
                switch (event.getPlayer().getWorld().getEnvironment()) {
                    case NETHER:
                    case THE_END: {
                        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.BED_BLOCK) {
                            event.setUseInteractedBlock(Event.Result.DENY);
                            event.setUseItemInHand(Event.Result.ALLOW);
                        }
                        break;
                    }
                }
            } catch (Exception ignored) {  }
        }
    }
}
