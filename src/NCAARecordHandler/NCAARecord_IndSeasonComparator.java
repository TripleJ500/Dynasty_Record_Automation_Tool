package NCAARecordHandler;

import java.util.Map;
import java.util.Objects;

import Resources.TeamLookup_Abv;
import DataStructures.Objects.DISS;
import DataStructures.Objects.OISS;
import DataStructures.Objects.KISS;
import DataStructures.HashMap_Schedule;
import DataStructures.Objects.Player;

import static DataStructures.HashMap_KISS.kSHashMap;
import static DataStructures.HashMap_Players.pDHashMap;
import static DataStructures.HashMap_OISS_OICS.oSHashMap;
import static DataStructures.HashMap_DISS_DICS.dSHashMap;

public class NCAARecord_IndSeasonComparator
{
    public static String[] compareSeasonRecords(String[] record, int recordDescription)
    {
        int previousRecordValue;
        int recordValue = Integer.parseInt(record[13]);

        String teamAbv;
        String previousRecordHolder;
        String recordHolder = record[3];
        String recordHolderPlayerID = record[5];

        switch (recordDescription)
        {
            // Most Rush Yards in a Season
            case 21 ->
            {
                // Sometimes the game won't save a player's game records, so this is to update a record that was
                // not saved.
                if(!Objects.equals(recordHolderPlayerID, String.valueOf(-1)) && pDHashMap.containsKey(Integer.parseInt(recordHolderPlayerID)))
                {
                    teamAbv = TeamLookup_Abv.getTeamName_Abv(pDHashMap.get(Integer.parseInt(recordHolderPlayerID)).teamID);
                    Player newHolder = pDHashMap.get(Integer.parseInt(recordHolderPlayerID));

                    recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                            " (" + HashMap_Schedule.year + ")";
                    record[3] = recordHolder;
                }

                for (Map.Entry<Integer, OISS> key : oSHashMap.entrySet())
                {
                    OISS o = key.getValue();
                    int currentValue = o.rushingYards;

                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(o.playerID));

                        teamAbv = TeamLookup_Abv.getTeamName_Abv(o.teamID);
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                                " (" + HashMap_Schedule.year + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = newHolder.playerID;

                        record[0] = Integer.toString(previousRecordValue);
                        record[2] = previousRecordHolder;
                        record[3] = recordHolder;
                        record[5] = recordHolderPlayerID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Most Rush TDs in a Season
            case 22 ->
            {
                if(!Objects.equals(recordHolderPlayerID, String.valueOf(-1)) && pDHashMap.containsKey(Integer.parseInt(recordHolderPlayerID)))
                {
                    teamAbv = TeamLookup_Abv.getTeamName_Abv(pDHashMap.get(Integer.parseInt(recordHolderPlayerID)).teamID);
                    Player newHolder = pDHashMap.get(Integer.parseInt(recordHolderPlayerID));

                    recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                            " (" + HashMap_Schedule.year + ")";
                    record[3] = recordHolder;
                }

                for (Map.Entry<Integer, OISS> key : oSHashMap.entrySet())
                {
                    OISS o = key.getValue();
                    int currentValue = o.rushingTouchdowns;

                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(o.playerID));

                        teamAbv = TeamLookup_Abv.getTeamName_Abv(o.teamID);
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                                " (" + HashMap_Schedule.year + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = newHolder.playerID;

                        record[0] = Integer.toString(previousRecordValue);
                        record[2] = previousRecordHolder;
                        record[3] = recordHolder;
                        record[5] = recordHolderPlayerID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Most Pass TDs in a Season
            case 23 ->
            {
                if(!Objects.equals(recordHolderPlayerID, String.valueOf(-1)) && pDHashMap.containsKey(Integer.parseInt(recordHolderPlayerID)))
                {
                    teamAbv = TeamLookup_Abv.getTeamName_Abv(pDHashMap.get(Integer.parseInt(recordHolderPlayerID)).teamID);
                    Player newHolder = pDHashMap.get(Integer.parseInt(recordHolderPlayerID));

                    recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                            " (" + HashMap_Schedule.year + ")";
                    record[3] = recordHolder;
                }

                for (Map.Entry<Integer, OISS> key : oSHashMap.entrySet())
                {
                    OISS o = key.getValue();
                    int currentValue = o.passingYards;

                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(o.playerID));

                        teamAbv = TeamLookup_Abv.getTeamName_Abv(o.teamID);
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                                " (" + HashMap_Schedule.year + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = newHolder.playerID;

                        record[0] = Integer.toString(previousRecordValue);
                        record[2] = previousRecordHolder;
                        record[3] = recordHolder;
                        record[5] = recordHolderPlayerID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Most Pass TDs in a Season
            case 24 ->
            {
                if(!Objects.equals(recordHolderPlayerID, String.valueOf(-1)) && pDHashMap.containsKey(Integer.parseInt(recordHolderPlayerID)))
                {
                    teamAbv = TeamLookup_Abv.getTeamName_Abv(pDHashMap.get(Integer.parseInt(recordHolderPlayerID)).teamID);
                    Player newHolder = pDHashMap.get(Integer.parseInt(recordHolderPlayerID));

                    recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                            " (" + HashMap_Schedule.year + ")";
                    record[3] = recordHolder;
                }

                for (Map.Entry<Integer, OISS> key : oSHashMap.entrySet())
                {
                    OISS o = key.getValue();
                    int currentValue = o.passingTouchdowns;

                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(o.playerID));

                        teamAbv = TeamLookup_Abv.getTeamName_Abv(o.teamID);
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                                " (" + HashMap_Schedule.year + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = newHolder.playerID;

                        record[0] = Integer.toString(previousRecordValue);
                        record[2] = previousRecordHolder;
                        record[3] = recordHolder;
                        record[5] = recordHolderPlayerID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Season QB Rating Record
            case 25 ->
            {
                // I'm not sure where the QB Rating stat is stored, so I only will update the formatting of the current
                // record holder
                if(!Objects.equals(recordHolderPlayerID, String.valueOf(-1)) && pDHashMap.containsKey(Integer.parseInt(recordHolderPlayerID)))
                {
                    teamAbv = TeamLookup_Abv.getTeamName_Abv(pDHashMap.get(Integer.parseInt(recordHolderPlayerID)).teamID);
                    Player newHolder = pDHashMap.get(Integer.parseInt(recordHolderPlayerID));

                    recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                            " (" + HashMap_Schedule.year + ")";
                    record[3] = recordHolder;
                }
            }

            // Most Receptions in a Season
            case 26 ->
            {
                if(!Objects.equals(recordHolderPlayerID, String.valueOf(-1)) && pDHashMap.containsKey(Integer.parseInt(recordHolderPlayerID)))
                {
                    teamAbv = TeamLookup_Abv.getTeamName_Abv(pDHashMap.get(Integer.parseInt(recordHolderPlayerID)).teamID);
                    Player newHolder = pDHashMap.get(Integer.parseInt(recordHolderPlayerID));

                    recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                            " (" + HashMap_Schedule.year + ")";
                    record[3] = recordHolder;
                }

                for (Map.Entry<Integer, OISS> key : oSHashMap.entrySet())
                {
                    OISS o = key.getValue();
                    int currentValue = o.receptions;

                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(o.playerID));

                        teamAbv = TeamLookup_Abv.getTeamName_Abv(o.teamID);
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                                " (" + HashMap_Schedule.year + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = newHolder.playerID;

                        record[0] = Integer.toString(previousRecordValue);
                        record[2] = previousRecordHolder;
                        record[3] = recordHolder;
                        record[5] = recordHolderPlayerID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Most Receiving Yards in a Season
            case 27 ->
            {
                if(!Objects.equals(recordHolderPlayerID, String.valueOf(-1)) && pDHashMap.containsKey(Integer.parseInt(recordHolderPlayerID)))
                {
                    teamAbv = TeamLookup_Abv.getTeamName_Abv(pDHashMap.get(Integer.parseInt(recordHolderPlayerID)).teamID);
                    Player newHolder = pDHashMap.get(Integer.parseInt(recordHolderPlayerID));

                    recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                            " (" + HashMap_Schedule.year + ")";
                    record[3] = recordHolder;
                }

                for (Map.Entry<Integer, OISS> key : oSHashMap.entrySet())
                {
                    OISS o = key.getValue();
                    int currentValue = o.receivingYards;

                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(o.playerID));

                        teamAbv = TeamLookup_Abv.getTeamName_Abv(o.teamID);
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                                " (" + HashMap_Schedule.year + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = newHolder.playerID;

                        record[0] = Integer.toString(previousRecordValue);
                        record[2] = previousRecordHolder;
                        record[3] = recordHolder;
                        record[5] = recordHolderPlayerID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Most Receiving TDs in a Season
            case 28 ->
            {
                if(!Objects.equals(recordHolderPlayerID, String.valueOf(-1)) && pDHashMap.containsKey(Integer.parseInt(recordHolderPlayerID)))
                {
                    teamAbv = TeamLookup_Abv.getTeamName_Abv(pDHashMap.get(Integer.parseInt(recordHolderPlayerID)).teamID);
                    Player newHolder = pDHashMap.get(Integer.parseInt(recordHolderPlayerID));

                    recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                            " (" + HashMap_Schedule.year + ")";
                    record[3] = recordHolder;
                }

                for (Map.Entry<Integer, OISS> key : oSHashMap.entrySet())
                {
                    OISS o = key.getValue();
                    int currentValue = o.receivingTouchdowns;

                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(o.playerID));

                        teamAbv = TeamLookup_Abv.getTeamName_Abv(o.teamID);
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                                " (" + HashMap_Schedule.year + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = newHolder.playerID;

                        record[0] = Integer.toString(previousRecordValue);
                        record[2] = previousRecordHolder;
                        record[3] = recordHolder;
                        record[5] = recordHolderPlayerID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Most Sacks in a Season
            case 29 ->
            {
                if(!Objects.equals(recordHolderPlayerID, String.valueOf(-1)) && pDHashMap.containsKey(Integer.parseInt(recordHolderPlayerID)))
                {
                    teamAbv = TeamLookup_Abv.getTeamName_Abv(pDHashMap.get(Integer.parseInt(recordHolderPlayerID)).teamID);
                    Player newHolder = pDHashMap.get(Integer.parseInt(recordHolderPlayerID));

                    recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                            " (" + HashMap_Schedule.year + ")";
                    record[3] = recordHolder;
                }

                for (Map.Entry<Integer, DISS> key : dSHashMap.entrySet())
                {
                    DISS d = key.getValue();
                    int currentValue = d.sacks;

                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(d.playerID));

                        teamAbv = TeamLookup_Abv.getTeamName_Abv(d.teamID);
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                                " (" + HashMap_Schedule.year + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = newHolder.playerID;

                        record[0] = Integer.toString(previousRecordValue);
                        record[2] = previousRecordHolder;
                        record[3] = recordHolder;
                        record[5] = recordHolderPlayerID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Most Interceptions in a Season
            case 30 ->
            {
                if(!Objects.equals(recordHolderPlayerID, String.valueOf(-1)) && pDHashMap.containsKey(Integer.parseInt(recordHolderPlayerID)))
                {
                    teamAbv = TeamLookup_Abv.getTeamName_Abv(pDHashMap.get(Integer.parseInt(recordHolderPlayerID)).teamID);
                    Player newHolder = pDHashMap.get(Integer.parseInt(recordHolderPlayerID));

                    recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                            " (" + HashMap_Schedule.year + ")";
                    record[3] = recordHolder;
                }

                for (Map.Entry<Integer, DISS> key : dSHashMap.entrySet())
                {
                    DISS d = key.getValue();
                    int currentValue = d.interceptions;

                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(d.playerID));

                        teamAbv = TeamLookup_Abv.getTeamName_Abv(d.teamID);
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                                " (" + HashMap_Schedule.year + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = newHolder.playerID;

                        record[0] = Integer.toString(previousRecordValue);
                        record[2] = previousRecordHolder;
                        record[3] = recordHolder;
                        record[5] = recordHolderPlayerID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Most Field Goals in a Season
            case 31 ->
            {
                if(!Objects.equals(recordHolderPlayerID, String.valueOf(-1)) && pDHashMap.containsKey(Integer.parseInt(recordHolderPlayerID)))
                {
                    teamAbv = TeamLookup_Abv.getTeamName_Abv(pDHashMap.get(Integer.parseInt(recordHolderPlayerID)).teamID);
                    Player newHolder = pDHashMap.get(Integer.parseInt(recordHolderPlayerID));

                    recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                            " (" + HashMap_Schedule.year + ")";
                    record[3] = recordHolder;
                }

                for (Map.Entry<Integer, KISS> key : kSHashMap.entrySet())
                {
                    KISS k = key.getValue();
                    int currentValue = k.totalFGMade;

                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(k.playerID));

                        teamAbv = TeamLookup_Abv.getTeamName_Abv(k.teamID);
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = newHolder.firstName + " " + newHolder.lastName + " - " +  teamAbv +
                                " (" + HashMap_Schedule.year + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = newHolder.playerID;

                        record[0] = Integer.toString(previousRecordValue);
                        record[2] = previousRecordHolder;
                        record[3] = recordHolder;
                        record[5] = recordHolderPlayerID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }
        }

        return record;
    }
}
