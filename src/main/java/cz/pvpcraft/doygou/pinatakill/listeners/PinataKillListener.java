package cz.pvpcraft.doygou.pinatakill.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import me.hexedhero.pp.api.PinataDieEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import cz.pvpcraft.doygou.pinatakill.PinataKillPlugin;

import java.util.ArrayList;
import java.util.List;

public class PinataKillListener implements Listener {

    // Always try to keep the modifiers as tight as possible, so no one can interfere with your application.
    // Name your variables better, cmd is understandable, but command(s) truly says it all and there's no need to shorten it.
    private final List<String> commands;

    public PinataKillListener(PinataKillPlugin plugin) {
        // Make sure it's not null. ?: structure, replaces if - else, it's called a ternary.
        this.commands = plugin.getConfig().isList("onPinataKill") ? plugin.getConfig().getStringList("onPinataKill") : new ArrayList<>();
    }

    @EventHandler
    public void onPinataKill(PinataDieEvent event) {

        Player player = event.getPinata().getEntity().getKiller();

        // #getKiller() is noted Nullable, keep that in mind to prevent any possible errors.
        if (player == null) return;

        // Make sure we're not changing the contents of our commands variable, because there are placeholders to parse.
        for (String command : new ArrayList<>(commands)) {
            // Sometimes it's better to write code in multiple lines to keep it nice, clean and readable.
            command = PlaceholderAPI.setPlaceholders(player, command);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        }
    }
}