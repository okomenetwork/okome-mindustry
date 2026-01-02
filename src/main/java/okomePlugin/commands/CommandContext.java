package okomePlugin.commands;

import mindustry.gen.Player;
import arc.util.Log;

public class CommandContext {
    private final Player player;
    private final String[] args;

    public CommandContext(Player player, String[] args) {
        this.player = player;
        this.args = args;
    }

    public Player getPlayer() {
        return player;
    }

    public String[] getArgs() {
        return args;
    }

    public boolean isPlayer() {
        return player != null;
    }

    public void reply(String message) {
        if (isPlayer()) {
            player.sendMessage(message);
        } else {
            Log.info(message);
        }
    }
}