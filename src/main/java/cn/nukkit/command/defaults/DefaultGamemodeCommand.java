package cn.nukkit.command.defaults;

import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandEnum;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.command.tree.ParamList;
import cn.nukkit.command.utils.CommandLogger;

import java.util.Map;

/**
 * @author xtypr
 * @since 2015/11/12
 */
public class DefaultGamemodeCommand extends VanillaCommand {

    public DefaultGamemodeCommand(String name) {
        super(name, "commands.defaultgamemode.description");
        this.setPermission("nukkit.command.defaultgamemode");
        this.commandParameters.clear();
        this.commandParameters.put("default", new CommandParameter[]{
                CommandParameter.newType("gameMode", CommandParamType.INT)
        });
        this.commandParameters.put("byString", new CommandParameter[]{
                CommandParameter.newEnum("gameMode", CommandEnum.ENUM_GAMEMODE)
        });
        this.enableParamTree();
    }

    @Override
    public int execute(CommandSender sender, String commandLabel, Map.Entry<String, ParamList> result, CommandLogger log) {
        var list = result.getValue();
        int gamemode;
        switch (result.getKey()) {
            case "default" -> gamemode = list.getResult(0);
            case "byString" -> {
                String mode = list.getResult(0);
                gamemode = Server.getGamemodeFromString(mode);
            }
            default -> {
                return 0;
            }
        }

        boolean valid = gamemode >= 0 && gamemode <= 3;
        if (valid) {
            sender.getServer().getSettings().getPlayer().setDefaultGamemode(gamemode);
            log.addSuccess("commands.defaultgamemode.success", Server.getGamemodeString(gamemode)).output();
            return 1;
        } else {
            log.addError("commands.gamemode.fail.invalid", String.valueOf(gamemode)).output();
            return 0;
        }
    }
}