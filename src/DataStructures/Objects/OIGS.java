package DataStructures.Objects;

public class OIGS
{
    public String playerID;
    public int teamID, gameNumber, gameWeek, passingYards, passingTouchdowns, longestPass, rushingYards, rushingTouchdowns,
               longestRun, receivingYards, receivingTouchdowns, receptions, longestReception;

    public OIGS(String playerID,
                int teamID,
                int gN,
                int gW,
                int pssY,
                int pssT,
                int longPss,
                int rshY,
                int rshT,
                int longRsh,
                int recY,
                int recT,
                int rec,
                int longRec)
    {
        if(pssY > 1700) { pssY = pssY - 2048; }
        if(rshY > 1700) { rshY = rshY - 2048; }
        if(recY > 1700) { recY = recY - 2048; }

        this.playerID            = playerID;
        this.teamID              = teamID;
        this.gameNumber          = gN;
        this.gameWeek            = gW;
        this.passingYards        = pssY;
        this.passingTouchdowns   = pssT;
        this.longestPass         = longPss;
        this.rushingYards        = rshY;
        this.rushingTouchdowns   = rshT;
        this.longestRun          = longRsh;
        this.receivingYards      = recY;
        this.receivingTouchdowns = recT;
        this.receptions          = rec;
        this.longestReception    = longRec;
    }
}