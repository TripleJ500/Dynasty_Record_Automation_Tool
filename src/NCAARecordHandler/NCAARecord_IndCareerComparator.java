package NCAARecordHandler;

import java.util.Map;
import java.util.Objects;

import Resources.TeamLookup_Abv;
import DataStructures.Objects.DISS;
import DataStructures.Objects.OISS;
import DataStructures.Objects.Player;
import DataStructures.HashMap_Schedule;

import static DataStructures.HashMap_Players.pDHashMap;
import static DataStructures.HashMap_OISS_OICS.oCHashMap;
import static DataStructures.HashMap_DISS_DICS.dCHashMap;

public class NCAARecord_IndCareerComparator
{
    public static String[] compareCareerRecords(String[] record, int recordDescription)
    {
        int previousRecordValue;
        int recordValue = Integer.parseInt(record[13]);

        String teamAbv;
        String previousRecordHolder;
        String recordHolder = record[3];
        String recordHolderPlayerID = record[5];


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

        switch (recordDescription)
        {
            // Most Rush Yards in a Career
            case 32 ->
            {
                for (Map.Entry<Integer, OISS> key : oCHashMap.entrySet())
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

            // Most Rush TDs in a Career
            case 33 ->
            {
                for (Map.Entry<Integer, OISS> key : oCHashMap.entrySet())
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

            // Most Pass Yards in a Career
            case 34 ->
            {
                for (Map.Entry<Integer, OISS> key : oCHashMap.entrySet())
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

            // Most Pass TDs in a Career
            case 35 ->
            {
                for (Map.Entry<Integer, OISS> key : oCHashMap.entrySet())
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

            // Most Receptions in a Career
            case 36 ->
            {
                for (Map.Entry<Integer, OISS> key : oCHashMap.entrySet())
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

            // Most Receiving Yards in a Career
            case 37 ->
            {
                 for (Map.Entry<Integer, OISS> key : oCHashMap.entrySet())
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

            // Most Receiving Touchdowns in a Career
            case 38 ->
            {
                for (Map.Entry<Integer, OISS> key : oCHashMap.entrySet())
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

            // Most Sacks in a Career
            case 39 ->
            {
                for (Map.Entry<Integer, DISS> key : dCHashMap.entrySet())
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

            // Most Interceptions in a Career
            case 40 ->
            {
                for (Map.Entry<Integer, DISS> key : dCHashMap.entrySet())
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
        }

        return record;
    }
}
