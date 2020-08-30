package cz.pvpcraft.pinatakill;

import org.bukkit.plugin.java.JavaPlugin;

public final class PinataKill extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        String cmd = getConfig().getString("onPinataKill");
        getServer().getPluginManager().registerEvents(new PinataKillListener(cmd), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
