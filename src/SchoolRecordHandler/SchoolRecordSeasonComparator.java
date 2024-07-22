package SchoolRecordHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import Resources.PositionLookup;
import DataStructures.Objects.DISS;
import DataStructures.Objects.OISS;
import DataStructures.Objects.Player;
import DataStructures.HashMap_Schedule;

import static DataStructures.HashMap_Players.pDHashMap;
import static DataStructures.HashMap_OISS_OICS.offSeaasonByTeamHashMap;
import static DataStructures.HashMap_DISS_DICS.defSeaasonByTeamHashMap;

public class SchoolRecordSeasonComparator
{
    public static String[] compareSeasonRecords(String[] record, int offOrDef) throws IllegalStateException
    {
        int previousRecordValue;
        int teamID = Integer.parseInt(record[7]);
        int recordValue = Integer.parseInt(record[14]);
        int recordDescription = Integer.parseInt(record[4]);

        String previousRecordHolder;
        String recordHolder = record[3];
        String recordHolderPlayerID = record[5];

        // Sometimes the game won't save a player's game records, so this is to update a record that was
        // not saved.
        if(!Objects.equals(recordHolderPlayerID, String.valueOf(-1)) && pDHashMap.containsKey(Integer.parseInt(recordHolderPlayerID)))
        {
            Player newHolder = pDHashMap.get(Integer.parseInt(recordHolderPlayerID));

            recordHolder = PositionLookup.getPosition(newHolder.positionID) + " " + newHolder.firstName
                    + " " + newHolder.lastName + " (" + HashMap_Schedule.year + ")";
            record[3] = recordHolder;
        }

        switch(offOrDef)
        {
            case 0 ->
            {
                HashMap<Integer, OISS> tempOISS = offSeaasonByTeamHashMap.get(teamID);

                // Loop over temporary array and compare each players rush yards stat against the current record
                // holder.
                for (Map.Entry<Integer, OISS> key : tempOISS.entrySet())
                {
                    OISS o = key.getValue();
                    int currentValue;

                    switch(recordDescription)
                    {
                        default -> currentValue = o.rushingYards;
                        case 1  -> currentValue = o.rushingTouchdowns;
                        case 2  -> currentValue = o.passingYards;
                        case 3  -> currentValue = o.passingTouchdowns;
                        case 4  -> currentValue = o.receptions;
                        case 5  -> currentValue = o.receivingYards;
                        case 6  -> currentValue = o.receivingTouchdowns;
                    }

                    // If the player that's currently being iterated on has a higher or equal stat total
                    // than the current holder, replace the current holder with the current player that's being
                    // iterated.
                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(o.playerID));

                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;

                        recordHolder = PositionLookup.getPosition(newHolder.positionID) + " " + newHolder.firstName
                                        + " " + newHolder.lastName + " (" + HashMap_Schedule.year + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = o.playerID;

                        record[0] = Integer.toString(previousRecordValue);
                        record[2] = previousRecordHolder;
                        record[3] = recordHolder;
                        record[5] = recordHolderPlayerID;
                        record[14] = Integer.toString(recordValue);
                    }
                }
            }
            case 1 ->
            {
                HashMap<Integer, DISS> tempDISS = defSeaasonByTeamHashMap.get(teamID);

                // Loop over temporary array and compare each players rush yards stat against the current record
                // holder.
                for (Map.Entry<Integer, DISS> key : tempDISS.entrySet())
                {
                    DISS d = key.getValue();

                    int currentValue = recordDescription == 8 ? d.interceptions : d.sacks;

                    // If the player that's currently being iterated on has a higher or equal stat total
                    // than the current holder, replace the current holder with the current player that's being
                    // iterated.
                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(d.playerID));

                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;

                        recordHolder = PositionLookup.getPosition(newHolder.positionID) + " " + newHolder.firstName
                                        + " " + newHolder.lastName + " (" + HashMap_Schedule.year + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = d.playerID;

                        record[0] = Integer.toString(previousRecordValue);
                        record[2] = previousRecordHolder;
                        record[3] = recordHolder;
                        record[5] = recordHolderPlayerID;
                        record[14] = Integer.toString(recordValue);
                    }
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + offOrDef);
        }
        return record;
    }
}
