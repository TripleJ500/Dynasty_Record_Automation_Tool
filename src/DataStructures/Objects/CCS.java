package DataStructures.Objects;

public class CCS
{
    public String coachID, coachFirstName, coachLastName;
    public int bowlAppearances, bowlVictories, careerVictories, gamesCoached, nationalChampionships, yearsWithTeam,
               yearsCoaching;

    public CCS(String coachID,
               String coachFirstName,
               String coachLastName,
               int bowlAppearances,
               int bowlVictories,
               int careerVictories,
               int gamesCoached,
               int yearsWithTeam,
               int yearsCoaching,
               int nationalChampionships)
    {
        this.coachID               = coachID;
        this.coachFirstName        = coachFirstName;
        this.coachLastName         = coachLastName;
        this.bowlAppearances       = bowlAppearances;
        this.bowlVictories         = bowlVictories;
        this.careerVictories       = careerVictories;
        this.gamesCoached          = gamesCoached;
        this.yearsWithTeam         = yearsWithTeam;
        this.yearsCoaching         = yearsCoaching;
        this.nationalChampionships = nationalChampionships;
    }
}