package it.goodtimes14.video.command;

import it.goodtimes14.video.VideoOnChat;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class AbstractCommand implements CommandExecutor {

    protected VideoOnChat plugin;

    public AbstractCommand(VideoOnChat plugin) {
        this.plugin = plugin;
    }

    public void errorMessage(CommandSender sender,String s) {
        sender.sendMessage("§cError! §7" + s);
    }
}
