package it.goodtimes14.video.command.impl;

import it.goodtimes14.video.VideoOnChat;
import it.goodtimes14.video.command.AbstractCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.io.File;

public class PlayVideoCommand extends AbstractCommand {

    public PlayVideoCommand(VideoOnChat plugin) {
        super(plugin);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(args.length != 0) {
            String fileName = args[0];
            File file = new File(plugin.getDataFolder(),"/videos/" + fileName + ".mp4");
            if(!file.exists()) {
                errorMessage(sender,"File not found");
            }
            plugin.getStreamManager().createTask(file);
            sender.sendMessage("§7Starting video... joe mama so fat");
        }
        return false;
    }
}
