package com.noobcore.noobcorecounter.commands;

import com.noobcore.noobcorecounter.tasks.TwentyPartyTimer;
import com.noobcore.noobcorecounter.Noobcorecounter;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitTask;
import org.checkerframework.checker.nullness.qual.NonNull;

public class TwentyPartyStart implements CommandExecutor {

    public static BukkitTask currentRunnable = null;

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, String[] args) {

        // Check if the task is already running and stop further logic if it is
        if (currentRunnable != null && !currentRunnable.isCancelled()) {
            sender.sendMessage("Timer already in progress!");
            return true;
        }

        //Desired Location -177.500, 53, 232.500 World name 'newlobby'
        World world = Bukkit.getWorld("newlobby");
        ArmorStand armorstand = (ArmorStand) world.spawnEntity(new Location((world), -177.500, 53, 232.500), EntityType.ARMOR_STAND);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "discord broadcast #585953624530616320 :information_source:`A gem party of 20 is starting in 5 minutes! Hop online and type /party to join!`");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "infiniteannouncements send * dropparty");
        //set stand attributes
        armorstand.setGravity(false);
        armorstand.setInvulnerable(true);
        armorstand.setCustomNameVisible(true);
        armorstand.setVisible(false);
        armorstand.customName(Component.text("5:00"));

        currentRunnable = new TwentyPartyTimer(armorstand, 300).runTaskTimer(Noobcorecounter.instance, 0, 20);



        return true;
    }

}
