package cz.pvpcraft.pinatakill;

import me.clip.placeholderapi.PlaceholderAPI;
import me.hexedhero.pp.api.PinataDieEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PinataKillListener implements Listener {
    String cmd;

    public PinataKillListener(String cmd) {
        this.cmd = cmd;
    }

    @EventHandler
    public void pinataKill(PinataDieEvent event) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                PlaceholderAPI.setPlaceholders(event.getPinata().getEntity().getKiller(), cmd));
    }
}
