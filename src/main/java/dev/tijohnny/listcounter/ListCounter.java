package dev.tijohnny.listcounter;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.stream.Collectors;

public final class ListCounter extends PlaceholderExpansion {


    @Override
    public @NotNull String getIdentifier() {
        return "listcounter";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Tijohnny";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.1";
    }

    @Override
    public boolean register() {
        return super.register();
    }

    @Override
    public @Nullable String onRequest(OfflinePlayer player, @NotNull String params) {

        return getPlayersList(params.toLowerCase());
    }

    public static String getPlayersList(String type) {
        switch (type) {
            case "whitelist": {
                Set<OfflinePlayer> whitelist = Bukkit.getWhitelistedPlayers();
                return whitelist.stream()
                        .map(OfflinePlayer::getName)
                        .collect(Collectors.joining(", "));
            }
            case "ops": {
                Set<OfflinePlayer> operators = Bukkit.getOperators();
                return operators.stream()
                        .map(OfflinePlayer::getName)
                        .collect(Collectors.joining(", "));
            }
            case "banned_players": {
                Set<OfflinePlayer> bannedPlayers = Bukkit.getBannedPlayers();
                return bannedPlayers.stream()
                        .map(OfflinePlayer::getName)
                        .collect(Collectors.joining(", "));
            }
            case "banned_ips": {
                Set<String> bannedIPs = Bukkit.getIPBans();
                return String.join(", ", bannedIPs);
            }
            default:
                return null;
        }
    }

}
