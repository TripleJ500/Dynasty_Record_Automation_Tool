package DataStructures.Objects;

public class DIGS
{
    public String playerID;
    public int teamID, gameNumber, gameWeek, tackles, tacklesForLoss, sacks, interceptions, longestInterceptionReturn,
               totalInterceptionYards, forcedFumbles, fumbleRecoveryYards;

    public DIGS(String pID,
                int teamID,
                int gN,
                int gW,
                int tkl,
                int tfl,
                int sack,
                int interception,
                int longINT,
                int totalINTYds,
                int forcedFumbles,
                int fumbleRecYds)
    {
        if(totalINTYds > 400)  { totalINTYds = totalINTYds - 512; }
        if(fumbleRecYds > 400) { fumbleRecYds = fumbleRecYds - 512; }

        this.playerID = pID;
        this.teamID = teamID;
        this.gameNumber = gN;
        this.gameWeek = gW;
        this.tackles = tkl;
        this.tacklesForLoss = tfl;
        this.sacks = sack;
        this.interceptions = interception;
        this.longestInterceptionReturn = longINT;
        this.totalInterceptionYards = totalINTYds;
        this.forcedFumbles = forcedFumbles;
        this.fumbleRecoveryYards = fumbleRecYds;
    }
}
