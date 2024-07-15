package DataStructures.Objects;

public class KISS
{
    public String playerID, firstName, lastName;
    public int teamID, longestPunt, longestFG, totalFGMade;

    public KISS(String playerID,
                String firstName,
                String lastName,
                int teamID,
                int longestPunt,
                int longestFG,
                int totalFGMade)
    {
        this.playerID    = playerID;
        this.firstName   = firstName;
        this.lastName    = lastName;
        this.teamID      = teamID;
        this.longestPunt = longestPunt;
        this.longestFG   = longestFG;
        this.totalFGMade = totalFGMade;
    }
}
