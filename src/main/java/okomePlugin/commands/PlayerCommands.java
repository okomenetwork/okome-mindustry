package okomePlugin.commands;

import arc.Core;
import arc.util.*;
import mindustry.gen.*;

public class PlayerCommands {
    public static void register(CommandHandler handler) {
        handler.<Player>register("ping", "Ping the server.", (args, player) -> {
            player.sendMessage("Pong! x3");
        });

        handler.<Player>register("discord", "Get discord link.", (args, player) -> {
            player.sendMessage("[blue]Discord link: [yellow]https://discord.gg/dBZNY5U36v");
        });

        handler.<Player>register("rules", "Show rules.", (args, player) -> {
            String rules = Core.settings.getString("server_rules", "Загрузка правил...");
            Call.infoMessage(player.con, "[red]Server Rules[]\n\n" + rules);
        });
    }
}