package okomePlugin.commands;

import arc.util.CommandHandler;
import mindustry.gen.Player;
import okomePlugin.commands.enums.CommandSource;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private final List<BaseCommand> commands = new ArrayList<>();

    public CommandManager() {}

    public void register(BaseCommand command) {
        commands.add(command);
    }

    public void registerClientCommands(CommandHandler handler) {
        for (BaseCommand cmd : commands) {
            if (cmd.getSource() == CommandSource.PLAYER || cmd.getSource() == CommandSource.BOTH) {
                handler.<Player>register(cmd.getName(), "", cmd.getDescription(), (args, player) -> {
                    CommandContext ctx = new CommandContext(player, args);
                    cmd.execute(ctx);
                });
            }
        }
    }

    public void registerServerCommands(CommandHandler handler) {
        for (BaseCommand cmd : commands) {
            if (cmd.getSource() == CommandSource.CONSOLE || cmd.getSource() == CommandSource.BOTH) {
                handler.register(cmd.getServerName(), "", cmd.getServerDescription(), args -> {
                    CommandContext ctx = new CommandContext(null, args);
                    cmd.execute(ctx);
                });
            }
        }
    }
}