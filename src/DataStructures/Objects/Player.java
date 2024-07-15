package DataStructures.Objects;

public class Player
{
    public String playerID, firstName, lastName, originalPlayerID;
    public int teamID, positionID;

    public Player(String playerID,
                  String firstName,
                  String lastName,
                  int teamID,
                  int positionID,
                  String originalPlayerID)
    {
        this.playerID         = playerID;
        this.firstName        = firstName;
        this.lastName         = lastName;
        this.teamID           = teamID;
        this.positionID       = positionID;
        this.originalPlayerID = originalPlayerID;
    }
}