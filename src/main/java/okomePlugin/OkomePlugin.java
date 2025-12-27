package okomePlugin;

import arc.util.*;
import mindustry.gen.*;
import mindustry.mod.*;

public class OkomePlugin extends Plugin{
    @Override
    public void init(){
        Log.info("Our example plugin is initializated!");
    }

    @Override
    public void registerServerCommands(CommandHandler handler){
        handler.register("ping", "Pong back to console.", args -> {
            Log.info("Pong!");
        });
    }

    @Override
    public void registerClientCommands(CommandHandler handler){
        handler.<Player>register("ping", "", "Pong back to player.", (args, player) -> {
            player.sendMessage("Pong!");
        });
    }
}
