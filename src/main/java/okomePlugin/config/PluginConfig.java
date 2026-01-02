package okomePlugin.config;

import arc.util.Log;

public class PluginConfig {

    public final String discordLink;
    public final String rulesUrl;

    public PluginConfig() {
        String envDiscord = System.getenv("DISCORD_URL");
        String envRules = System.getenv("RULES_URL");

        if (envDiscord == null) {
            Log.warn("Discord URL not found.");
            this.discordLink = "Link not found.";
        } else {
            this.discordLink = envDiscord;
        }

        if (envRules == null) {
            Log.warn("Rules URL not found.");
            this.rulesUrl = "";
        } else {
            this.rulesUrl = envRules;
        }
    }
}