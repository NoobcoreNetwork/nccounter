package com.noobcore.noobcorecounter.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;


public class StopParty implements CommandExecutor {

    /**
     * TODO convert BukkitTasks from 20 and 50 into static, reference them here.
     * TODO Check if they're running. If yes, cancel them
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (TwentyPartyStart.currentRunnable != null && !TwentyPartyStart.currentRunnable.isCancelled()) {
            sender.sendMessage("Drop Party Manually Stopped");
            TwentyPartyStart.currentRunnable.cancel();

        }
        if (FiftyPartyStart.currentRunnable != null && !FiftyPartyStart.currentRunnable.isCancelled()) {
            sender.sendMessage("Drop Party Manually Stopped");
            FiftyPartyStart.currentRunnable.cancel();

        }


        return true;





    }
}
