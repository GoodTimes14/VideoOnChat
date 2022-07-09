package it.goodtimes14.video.stream.manager;

import it.goodtimes14.video.VideoOnChat;
import it.goodtimes14.video.stream.CurrentStream;
import it.goodtimes14.video.stream.task.VideoTask;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;

@Getter
@Setter
public class VideoStreamManager  {

    private final VideoOnChat plugin;
    private BukkitTask currentTask;

    public VideoStreamManager(VideoOnChat plugin) {
        this.plugin = plugin;
        currentTask = null;
    }


    public void createTask(File file) {
        currentTask = new VideoTask(this,new CurrentStream(file)).runTaskTimerAsynchronously(plugin,20,1);
    }
}
