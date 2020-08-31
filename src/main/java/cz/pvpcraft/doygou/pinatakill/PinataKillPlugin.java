package cz.pvpcraft.doygou.pinatakill;

import cz.pvpcraft.doygou.pinatakill.commands.PinataCommand;
import cz.pvpcraft.doygou.pinatakill.listeners.PinataKillListener;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class PinataKillPlugin extends JavaPlugin {

    // Nicely coded, does what's required, you understood basically everything you needed to in short time, good to know that.

    // When you're asked to create something, show some creativity, try to load it with as many features as possible.
    // At least that's the nice way to do stuff, and how I look at everything I do, you don't have to share that philosophy.

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PinataKillListener(this), this);

        getCommand("pinatakill").setExecutor(new PinataCommand(this));
    }

    // Provide a reload for the configuration, restarting or force-reloading for a simple change is inconvenient.
    // Add some style, time it, send the executor some info.
    public void reload(CommandSender sender) {
        long start = System.currentTimeMillis();

        reloadConfig();

        StringUtil.sendPrefixed(sender, "&7Done, reload took &f" + (System.currentTimeMillis() - start) + "&7ms.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}