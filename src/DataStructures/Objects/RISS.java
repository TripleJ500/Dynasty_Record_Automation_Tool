package DataStructures.Objects;

public class RISS
{
    public String playerID, firstName, lastName;
    public int teamID, year, longestPuntReturn, longestKickReturn;

    public RISS(String playerID,
                String firstName,
                String lastName,
                int teamID,
                int year,
                int longestPuntReturn,
                int longestKickReturn)
    {
        this.playerID          = playerID;
        this.firstName         = firstName;
        this.lastName          = lastName;
        this.teamID            = teamID;
        this.year              = year;
        this.longestPuntReturn = longestPuntReturn;
        this.longestKickReturn = longestKickReturn;
    }
}