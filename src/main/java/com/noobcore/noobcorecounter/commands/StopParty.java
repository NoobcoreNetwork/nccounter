package com.noobcore.noobcorecounter.commands;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;


public class StopParty implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (TwentyPartyStart.isTaskRunning()) {
            sender.sendRichMessage("<white>\uE46E <red>Drop Party Manually Stopped");
            TwentyPartyStart.cancelTimer();

        }
        if (FiftyPartyStart.isTaskRunning()) {
            sender.sendRichMessage("<white>\uE46E <red>Drop Party Manually Stopped");
            FiftyPartyStart.cancelTimer();

        }


        return true;





    }
}
