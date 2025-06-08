package cn.nukkit.scoreboard.scorer;

import cn.nukkit.network.protocol.types.ScoreEntry;
import cn.nukkit.network.protocol.types.ScorerType;
import cn.nukkit.scoreboard.scoreboard.IScoreboard;
import cn.nukkit.scoreboard.scoreboard.IScoreboardLine;

public interface IScorer {

    /**
     * Get the tracking object type
     *
     * @return tracking object type
     */
    ScorerType getScorerType();

    /**
     * Get name
     *
     * @return tracking object type
     */
    String getName();

    /**
     * Internal method <br>
     * Convert to network information
     *
     * @param scoreboard the scoreboard to which it belongs
     * @param line       the line to which it belongs
     * @return network information
     */
    ScoreEntry toNetworkInfo(IScoreboard scoreboard, IScoreboardLine line);
}
