package okomePlugin;

import arc.util.*;
import mindustry.mod.*;
import mindustry.gen.*;
import okomePlugin.commands.*;

public class OkomePlugin extends Plugin {

    @Override
    public void init() {
        Log.info("===      OKOME NETWORK      ===");
        Log.info("=== Welcome to Okome Plugin ===");
    }

    @Override
    public void registerClientCommands(CommandHandler handler) {
        PlayerCommands.register(handler);
    }

    @Override
    public void registerServerCommands(CommandHandler handler) {
        ServerCommands.register(handler);
        AdminCommands.register(handler);
    }
}