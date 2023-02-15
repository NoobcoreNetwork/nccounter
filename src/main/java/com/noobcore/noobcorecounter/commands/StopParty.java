package com.noobcore.noobcorecounter.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;


public class StopParty implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (TwentyPartyStart.isTaskRunning()) {
            sender.sendMessage("Drop Party Manually Stopped");
            TwentyPartyStart.cancelTimer();

        }
        if (FiftyPartyStart.isTaskRunning()) {
            sender.sendMessage("Drop Party Manually Stopped");
            FiftyPartyStart.cancelTimer();

        }


        return true;





    }
}
