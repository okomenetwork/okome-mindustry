package okomePlugin.commands.impl.general;

import arc.util.Log;
import okomePlugin.commands.BaseCommand;
import okomePlugin.commands.CommandContext;
import okomePlugin.commands.enums.CommandSource;

public class PingCommand extends BaseCommand {

    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public String getDescription() {
        return "Pong command";
    }

    @Override
    public CommandSource getSource() {
        return CommandSource.BOTH;
    }

    @Override
    public void execute(CommandContext ctx) {
        if (ctx.isPlayer()) {
            ctx.reply("Pong! x3");
        } else {
            Log.info("Pong!");
        }
    }
}