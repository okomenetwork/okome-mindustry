package okomePlugin.service;

import arc.util.Http;
import arc.util.Log;
import okomePlugin.config.PluginConfig;

public class RulesService {

    private final PluginConfig config;
    private String cachedRules = "Загрузка правил...";

    public RulesService(PluginConfig config) {
        this.config = config;
        fetchRules();
    }

    public void fetchRules() {
        if (config.rulesUrl.isEmpty()) {
            this.cachedRules = "[RulesService] rules URL not found.";
            return;
        }

        Log.info("[RulesService] Getting rules from GitHub Gist...");

        Http.get(config.rulesUrl, result -> {
            this.cachedRules = result.getResultAsString();
            Log.info("[RulesService] Rules updated.");
        }, error -> {
            Log.err("[RulesService] Failed to fetch rules.", error);
            this.cachedRules = "[RulesService] Failed to fetch rules.";
        });
    }

    public String getRules() {
        return cachedRules;
    }
}