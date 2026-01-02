package okomePlugin.commands.impl.general;

import mindustry.gen.Call;
import okomePlugin.commands.BaseCommand;
import okomePlugin.commands.CommandContext;
import okomePlugin.commands.enums.CommandSource;
import okomePlugin.service.RulesService;

public class RulesCommand extends BaseCommand {

    private final RulesService rulesService;

    public RulesCommand(RulesService rulesService) {
        this.rulesService = rulesService;
    }

    @Override
    public String getName() {
        return "rules";
    }

    @Override
    public String getDescription() {
        return "Прочитать правила сервера";
    }

    @Override
    public String getServerName() {
        return "game_rules";
    }

    @Override
    public String getServerDescription() {
        return "Read server rules";
    }

    @Override
    public CommandSource getSource() {
        return CommandSource.BOTH;
    }

    @Override
    public void execute(CommandContext ctx) {
        String rulesText = rulesService.getRules();

        if (ctx.isPlayer()) {
            String fullMessage = "[orange]=== Правила Сервера ===[]\n\n" + rulesText;
            Call.infoMessage(ctx.getPlayer().con, fullMessage);
        } else {
            ctx.reply("=== Server Rules ===");
            ctx.reply(rulesText);
        }
    }
}