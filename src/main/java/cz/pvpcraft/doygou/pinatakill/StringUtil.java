package cz.pvpcraft.doygou.pinatakill;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

// Utility classes
public class StringUtil {

    // Color util to avoid any Null pointers.
    public static String color(String msg) {
        return msg != null ? ChatColor.translateAlternateColorCodes('&', msg) : null;
    }

    // Send only if the message is not null.
    public static void sendPrefixed(CommandSender sender, String msg) {
        msg = color(msg);
        if (msg != null)
            sender.sendMessage(color("&aPinataKill &8| ") + msg);
    }
}