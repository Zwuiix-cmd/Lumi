package cn.nukkit.settings.transformer;

import cn.nukkit.settings.GeneralSettings.ServerAuthoritativeMovement;
import eu.okaeri.configs.schema.GenericsPair;
import eu.okaeri.configs.serdes.BidirectionalTransformer;
import eu.okaeri.configs.serdes.SerdesContext;
import org.jetbrains.annotations.NotNull;

public class ServerAuthoritativeMovementTransformer extends BidirectionalTransformer<String, ServerAuthoritativeMovement> {

    @Override
    public GenericsPair<String, ServerAuthoritativeMovement> getPair() {
        return this.genericsPair(String.class, ServerAuthoritativeMovement.class);
    }

    @Override
    public ServerAuthoritativeMovement leftToRight(@NotNull String data, @NotNull SerdesContext serdesContext) {
        return switch (data.toLowerCase()) {
            case "client-auth" -> ServerAuthoritativeMovement.CLIENT_AUTH;
            case "server-auth-with-rewind" -> ServerAuthoritativeMovement.SERVER_AUTH_WITH_REWIND;
            default -> ServerAuthoritativeMovement.SERVER_AUTH;
        };
    }

    @Override
    public String rightToLeft(@NotNull ServerAuthoritativeMovement data, @NotNull SerdesContext serdesContext) {
        return switch (data) {
            case CLIENT_AUTH -> "client-auth";
            case SERVER_AUTH_WITH_REWIND -> "server-auth-with-rewind";
            default -> "server-auth";
        };
    }
}
