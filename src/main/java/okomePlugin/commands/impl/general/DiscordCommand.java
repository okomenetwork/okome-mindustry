package okomePlugin.commands.impl.general;

import okomePlugin.commands.BaseCommand;
import okomePlugin.commands.CommandContext;
import okomePlugin.commands.enums.CommandSource;
import okomePlugin.config.PluginConfig;

public class DiscordCommand extends BaseCommand {

    private final PluginConfig config;

    public DiscordCommand(PluginConfig config) {
        this.config = config;
    }

    @Override
    public String getName() {
        return "discord";
    }

    @Override
    public String getDescription() {
        return "Получить ссылку на Discord сервер";
    }

    @Override
    public CommandSource getSource() {
        return CommandSource.BOTH;
    }

    @Override
    public void execute(CommandContext ctx) {
        ctx.reply("[accent]Присоединяйтесь к нашему Discord серверу:[] " + config.discordLink);
    }
}