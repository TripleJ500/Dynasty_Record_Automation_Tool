package DataStructures.Objects;

import java.util.List;

public class DISS
{
    public String playerID;
    public int teamID, sacks, interceptions;
    public List<Integer> year;


    public DISS(String playerID,
                int teamID,
                List<Integer> year,
                int sacks,
                int interceptions)
    {
        this.playerID      = playerID;
        this.teamID        = teamID;
        this.year          = year;
        this.sacks         = sacks;
        this.interceptions = interceptions;
    }
}