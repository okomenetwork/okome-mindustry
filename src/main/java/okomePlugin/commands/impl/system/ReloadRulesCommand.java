package okomePlugin.commands.impl.system;

import okomePlugin.commands.BaseCommand;
import okomePlugin.commands.CommandContext;
import okomePlugin.commands.enums.CommandSource;
import okomePlugin.service.RulesService;

public class ReloadRulesCommand extends BaseCommand {

    private final RulesService rulesService;

    public ReloadRulesCommand(RulesService rulesService) {
        this.rulesService = rulesService;
    }

    @Override
    public String getName() {
        return "reloadrules";
    }

    @Override
    public String getDescription() {
        return "Reload rules from GitHub";
    }

    @Override
    public CommandSource getSource() {
        return CommandSource.CONSOLE;
    }

    @Override
    public void execute(CommandContext ctx) {
        // Ответ на английском
        ctx.reply("Reloading rules...");
        rulesService.fetchRules();
    }
}