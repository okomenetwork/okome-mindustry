package okomePlugin.commands;

import okomePlugin.commands.enums.AccessLevel;
import okomePlugin.commands.enums.CommandSource;

public abstract class BaseCommand {

    public abstract String getName();

    public abstract String getDescription();

    public abstract void execute(CommandContext ctx);

    public String getServerName() {
        return getName();
    }

    public String getServerDescription() {
        return getDescription();
    }

    public AccessLevel getAccessLevel() {
        return AccessLevel.USER;
    }

    public CommandSource getSource() {
        return CommandSource.BOTH;
    }
}