package cn.nukkit.command.defaults;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.lang.TranslationContainer;
import cn.nukkit.utils.TextFormat;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class StopCommand extends VanillaCommand {

    public StopCommand(String name) {
        super(name, "%nukkit.command.stop.description", "%commands.stop.usage");
        this.setPermission("nukkit.command.stop");
        this.commandParameters.clear();
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }

        if (sender instanceof Player && !(Server.getInstance().getSettings().getPlayer().isStopInGame())) {
            sender.sendMessage(TextFormat.RED + "Can't use this command in game");
            return true;
        }

        broadcastCommandMessage(sender, new TranslationContainer("commands.stop.start"));

        Server.getInstance().shutdown();
        return true;
    }
}
