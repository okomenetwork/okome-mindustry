package okomePlugin.commands;

import arc.Core;
import arc.util.*;
import mindustry.gen.*;

import java.nio.charset.StandardCharsets;

public class ServerCommands {
    public static void register(CommandHandler handler) {
        handler.register("ping", "Ping the server.", args -> {
            Log.info("Pong!");
        });

        handler.register("reloadrules", "Reload rules from ENV", args -> {
            String url = System.getenv("RULES_URL");

            if (url == null || url.isEmpty()) {
                Log.err("[reloadrules] ERROR: RULES_URL env missing");
                return;
            }

            Http.get(url.trim(), response -> {
                if (response.getStatus() != Http.HttpStatus.OK) {
                    Log.err("[reloadrules] ERROR: HTTP Error: " + response.getStatus());
                    return;
                }

                String text = new String(response.getResult(), StandardCharsets.UTF_8);

                Core.settings.put("server_rules", text);
                Core.settings.forceSave();

                String saved = Core.settings.getString("server_rules", "");

                if (saved.equals(text)) {
                    Log.info("[reloadrules] SUCCESS: Rules saved successfully. Length: " + text.length());
                } else {
                    Log.err("[reloadrules] ERROR: Save verification failed!");
                }
            }, err -> {
                Log.err("[reloadrules] ERROR: Download failed", err);
            });
        });
    }
}