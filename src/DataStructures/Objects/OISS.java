package DataStructures.Objects;

import java.util.List;

public class OISS
{
    public String playerID;
    public int teamID, passingYards, passingTouchdowns, rushingYards, rushingTouchdowns, receivingYards,
               receivingTouchdowns, receptions;
    public List<Integer> year;

    public OISS(String playerID,
                int teamID,
                List<Integer> year,
                int pssY,
                int pssTD,
                int rshY,
                int rshT,
                int recY,
                int recT,
                int rec)
    {
        this.playerID = playerID;
        this.teamID = teamID;
        this.year = year;
        this.passingYards = pssY;
        this.passingTouchdowns = pssTD;
        this.rushingYards = rshY;
        this.rushingTouchdowns = rshT;
        this.receivingYards = recY;
        this.receivingTouchdowns = recT;
        this.receptions = rec;
    }
}
