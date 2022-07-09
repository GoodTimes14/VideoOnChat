package it.goodtimes14.video.stream.task;

import it.goodtimes14.video.stream.CurrentStream;
import it.goodtimes14.video.stream.manager.VideoStreamManager;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.Transform;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

@RequiredArgsConstructor
public class VideoTask extends BukkitRunnable {

    private final VideoStreamManager manager;
    private final CurrentStream stream;


    @Override
    public void run() {
        BufferedImage picture = stream.nextFrame();
        StringBuilder builder = new StringBuilder();
        if (picture == null) {
            manager.setCurrentTask(null);
            Bukkit.broadcastMessage("§7Reached last frame");
            cancel();
            return;
        }
        for (int y = 0; y < picture.getHeight(); y++) {
            for (int x = 0; x < picture.getWidth(); x++) {
                int pixel = picture.getRGB(x, y);
                Color c = new Color(pixel);
                String hex = String.format("#%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
                builder.append(net.md_5.bungee.api.ChatColor.of(hex) + "█");
            }
            builder.append("\n");
        }
        Bukkit.broadcastMessage(builder.toString());
    }

}
