package okomePlugin;

import arc.util.CommandHandler;
import arc.util.Log;
import mindustry.mod.Plugin;
import okomePlugin.commands.CommandManager;
import okomePlugin.config.PluginConfig;
import okomePlugin.service.RulesService;

// Импорты команд
import okomePlugin.commands.impl.general.PingCommand;
import okomePlugin.commands.impl.general.DiscordCommand;
import okomePlugin.commands.impl.general.RulesCommand;
import okomePlugin.commands.impl.system.ReloadRulesCommand;

public class OkomePlugin extends Plugin {

    private final CommandManager commandManager;
    private final RulesService rulesService;
    private final PluginConfig config;

    public OkomePlugin() {
        this.config = new PluginConfig();
        this.rulesService = new RulesService(config);

        this.commandManager = new CommandManager();

        commandManager.register(new PingCommand());
        commandManager.register(new DiscordCommand(config));
        commandManager.register(new RulesCommand(rulesService));
        commandManager.register(new ReloadRulesCommand(rulesService));
    }

    @Override
    public void init() {
        Log.info("+++ OKOME NETWORK +++");
    }

    @Override
    public void registerClientCommands(CommandHandler handler) {
        commandManager.registerClientCommands(handler);
    }

    @Override
    public void registerServerCommands(CommandHandler handler) {
        commandManager.registerServerCommands(handler);
    }
}