package Tasks;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;

public class TwentyPartyTimer extends BukkitRunnable {
    private final ArmorStand armorStand;
    private int seconds;

    public TwentyPartyTimer(ArmorStand armorStand, int seconds) {
        this.armorStand = armorStand;
        this.seconds = seconds;
    }

    @Override
    public void run() {
        if (seconds == 0) {
            armorStand.remove();
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mm mobs spawn party20 1 newlobby,-173.500,57,232.500");
            cancel();
            return;
        }

        armorStand.customName(MiniMessage.miniMessage().deserialize("<white>\uE433 Time Until DropParty: <green>"+getTimeFromSeconds(seconds)+"<white> \uE433"));
        seconds--;

    }

    private String getTimeFromSeconds(int seconds) {
        int minutes = seconds / 60;
        int secondsLeft = seconds % 60;
        return String.format("%02d:%02d", minutes, secondsLeft);
    }
}
