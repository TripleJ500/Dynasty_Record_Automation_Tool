package SchoolRecordHandler;

import java.util.HashMap;
import java.util.Map;

import DataStructures.Objects.Player;
import DataStructures.Objects.OISS;
import DataStructures.Objects.DISS;
import Resources.PositionLookup;

import static DataStructures.HashMap_Players.pDHashMap;
import static DataStructures.HashMap_OISS_OICS.offCareerByTeamHashMap;
import static DataStructures.HashMap_DISS_DICS.defCareerByTeamHashMap;

public class SchoolRecordCareerComparator
{
    public static String[] compareCareerRecords(String[] record, int offOrDef) throws IllegalStateException
    {
        int firstYear, lastYear;
        int previousRecordValue;
        int teamID = Integer.parseInt(record[7]);
        int recordValue = Integer.parseInt(record[14]);
        int recordDescription = Integer.parseInt(record[4]);

        String recordHolderPlayerID;
        String previousRecordHolder;
        String recordHolder = record[3];

        switch (offOrDef)
        {
            case 0 ->
            {
                HashMap<Integer, OISS> tempOICS = offCareerByTeamHashMap.get(teamID);

                for (Map.Entry<Integer, OISS> key : tempOICS.entrySet())
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

                        lastYear = offCareerByTeamHashMap.get(o.teamID)
                                                         .get(Integer.parseInt(o.playerID)).year
                                                         .get(0);
                        firstYear = offCareerByTeamHashMap.get(o.teamID)
                                                          .get(Integer.parseInt(o.playerID)).year
                                                                .get(offCareerByTeamHashMap
                                                                .get(o.teamID)
                                                                .get(Integer.parseInt(o.playerID)).year.size() - 1);

                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;

                        recordHolder = PositionLookup.getPosition(newHolder.positionID) + " " + newHolder.firstName
                                        + " " + newHolder.lastName + " (" + firstYear + "-" +
                                        String.valueOf(lastYear).substring(2) + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = o.playerID;

                        record[0] = Integer.toString(previousRecordValue);
                        record[2] = previousRecordHolder;
                        record[3] = recordHolder;
                        record[5] = recordHolderPlayerID;
                        record[14] = Integer.toString(recordValue);
                        break;
                    }
                }
            }
            case 1 ->
            {
                HashMap<Integer, DISS> tempDICS = defCareerByTeamHashMap.get(teamID);

                // Loop over temporary array and compare each players rush yards stat against the current record
                // holder.
                for (Map.Entry<Integer, DISS> key : tempDICS.entrySet())
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

                        lastYear = offCareerByTeamHashMap.get(d.teamID)
                                                         .get(Integer.parseInt(d.playerID)).year
                                                         .get(0);
                        firstYear = offCareerByTeamHashMap.get(d.teamID)
                                                          .get(Integer.parseInt(d.playerID)).year
                                                                .get(offCareerByTeamHashMap
                                                                .get(d.teamID)
                                                                .get(Integer.parseInt(d.playerID)).year.size() - 1);

                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;

                        recordHolder = PositionLookup.getPosition(newHolder.positionID) + " " + newHolder.firstName
                                        + " " + newHolder.lastName + " (" + firstYear + "-" +
                                        String.valueOf(lastYear).substring(2) + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = d.playerID;

                        record[0] = Integer.toString(previousRecordValue);
                        record[2] = previousRecordHolder;
                        record[3] = recordHolder;
                        record[5] = recordHolderPlayerID;
                        record[14] = Integer.toString(recordValue);
                        break;
                    }
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + offOrDef);
        }
        return record;
    }
}
