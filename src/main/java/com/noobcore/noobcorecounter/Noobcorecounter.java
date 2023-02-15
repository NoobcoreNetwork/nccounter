package com.noobcore.noobcorecounter;

import com.noobcore.noobcorecounter.commands.StopParty;
import com.noobcore.noobcorecounter.commands.TwentyPartyStart;
import com.noobcore.noobcorecounter.commands.FiftyPartyStart;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Noobcorecounter extends JavaPlugin {
public static Noobcorecounter instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        Bukkit.getLogger().info("Noobcore Counter Initialized Successfully");
        getCommand( "party20").setExecutor(new TwentyPartyStart());
        getCommand( "party50").setExecutor(new FiftyPartyStart());
        getCommand( "partystop").setExecutor(new StopParty());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Noobcore Counter Shutdown Successfully");

    }
}

// Add a way to stop the countdown and cancel the process
// add crash detection to remove the hologram
// add ding ding ding to the last 10 seconds of the countdown
// find a way to add the custom gem emotes to the discord message
// add chat announcement NEXT
// integrate existing /party20 and /party50 commands DONE/TEST
