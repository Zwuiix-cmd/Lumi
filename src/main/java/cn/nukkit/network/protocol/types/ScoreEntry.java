package cn.nukkit.network.protocol.types;

public final class ScoreEntry {

    public long scoreboardId;
    public String objectiveId;
    public int score;
    public ScorerType type;
    public String name;
    public long entityId;

    public ScoreEntry(long scoreboardId, String objectiveId, int score) {
        this.scoreboardId = scoreboardId;
        this.objectiveId = objectiveId;
        this.score = score;
        this.type = ScorerType.INVALID;
        this.name = null;
        this.entityId = -1;
    }

    public ScoreEntry(long scoreboardId, String objectiveId, int score, String name) {
        this.scoreboardId = scoreboardId;
        this.objectiveId = objectiveId;
        this.score = score;
        this.type = ScorerType.FAKE;
        this.name = name;
        this.entityId = -1;
    }

    public ScoreEntry(long scoreboardId, String objectiveId, int score, ScorerType type, long entityId) {
        this.scoreboardId = scoreboardId;
        this.objectiveId = objectiveId;
        this.score = score;
        this.type = type;
        this.entityId = entityId;
        this.name = null;
    }
}
