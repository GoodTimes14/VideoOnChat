package it.goodtimes14.video;

import it.goodtimes14.video.command.impl.PlayVideoCommand;
import it.goodtimes14.video.stream.manager.VideoStreamManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class VideoOnChat extends JavaPlugin {

    private VideoStreamManager streamManager;


    @Override
    public void onEnable() {
        saveDefaultConfig();
        streamManager = new VideoStreamManager(this);
        registerCommands();
    }

    public void registerCommands() {
        getCommand("playvideo").setExecutor(new PlayVideoCommand(this));
    }
}
