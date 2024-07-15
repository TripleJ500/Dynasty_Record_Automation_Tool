package DataStructures.Objects;

public class Schedule
{
    public int opponentID, gameNumber, gameWeek, season, teamScore, opponentScore;

    public Schedule(int opponentID,
                int gameNumber,
                int gameWeek,
                int season,
                int teamScore,
                int opponentScore)
    {
        this.opponentID    = opponentID;
        this.gameNumber    = gameNumber;
        this.gameWeek      = gameWeek;
        this.season        = season;
        this.teamScore     = teamScore;
        this.opponentScore = opponentScore;
    }
}
