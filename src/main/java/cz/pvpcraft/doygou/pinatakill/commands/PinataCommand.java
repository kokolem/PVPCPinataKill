package cz.pvpcraft.doygou.pinatakill.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import cz.pvpcraft.doygou.pinatakill.PinataKillPlugin;
import cz.pvpcraft.doygou.pinatakill.StringUtil;

public class PinataCommand implements CommandExecutor {

    // Keep a plugin instance with dependency injection (passing it through a constructor) to keep static references as low as possible.
    private final PinataKillPlugin plugin;

    public PinataCommand(PinataKillPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        // Try to make the commands as bullet-proof as possible to account even for the stupidest of people.
        if (args.length == 0) {
            StringUtil.sendPrefixed(sender, "&cNot enough arguments.");
            return true;
        }

        if (!args[0].equalsIgnoreCase("reload")) {
            StringUtil.sendPrefixed(sender, "&cInvalid command. &7/" + label + " reload");
            return true;
        }

        // Finally reload.
        plugin.reload(sender);
        return false;
    }
}