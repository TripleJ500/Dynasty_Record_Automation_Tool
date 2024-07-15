package SchoolRecordHandler;

import java.util.*;

import DataStructures.Objects.Player;
import Resources.TeamLookup;
import DataStructures.Objects.Schedule;
import Resources.PositionLookup;
import DataStructures.Objects.DIGS;
import DataStructures.Objects.OIGS;
import DataStructures.HashMap_Schedule;

import static DataStructures.HashMap_Players.pDHashMap;
import static DataStructures.List_OIGS.oigsByTeamHashMap;
import static DataStructures.List_DIGS.digsByTeamHashMap;
public class SchoolRecordGameComparator
{
    public static String[] compareGameRecords(String[] record, int offOrDef) throws RuntimeException
    {
        int previousRecordValue;
        int teamID = Integer.parseInt(record[7]);
        int recordValue = Integer.parseInt(record[14]);
        int weekOfRecord = Integer.parseInt(record[9]);
        int recordDescription = Integer.parseInt(record[4]);

        String recordHolderPlayerID;
        String previousRecordHolder;
        String recordHolder = record[3];
        String recordOpponent = record[10];

        switch (offOrDef)
        {
            case 0 ->
            {
                // Get the list of OIGS based on the team of the current record being evaluated
                List<OIGS> currentTeamOIGS = oigsByTeamHashMap.get(teamID);

                for(OIGS o : currentTeamOIGS)
                {
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
                        List<Schedule> tempSCHDList = HashMap_Schedule.sDHashMap.get(teamID);
                        tempSCHDList = tempSCHDList.stream().sorted(Comparator.comparing((s -> s.gameWeek))).toList();

                        for (Schedule s : tempSCHDList)
                        {
                            if (s.gameNumber == o.gameNumber && s.gameWeek == o.gameWeek)
                            {
                                weekOfRecord = s.gameWeek;
                                recordOpponent = TeamLookup.getTeamName(s.opponentID);
                                break;
                            }
                        }

                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = PositionLookup.getPosition(newHolder.positionID) + " " + newHolder.firstName
                                        + " " + newHolder.lastName + " (" + HashMap_Schedule.year + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = newHolder.playerID;

                        record[ 0] = Integer.toString(previousRecordValue);
                        record[ 2] = previousRecordHolder;
                        record[ 3] = recordHolder;
                        record[ 5] = recordHolderPlayerID;
                        record[ 9] = Integer.toString(weekOfRecord);
                        record[10] = recordOpponent;
                        record[14] = Integer.toString(recordValue);
                    }
                }
            }
            case 1 ->
            {
                // Get the list of OIGS based on the team of the current record being evaluated
                List<DIGS> currentTeamDIGS = digsByTeamHashMap.get(teamID);

                for(DIGS d : currentTeamDIGS)
                {
                    int currentValue = recordDescription == 8 ? d.interceptions : d.sacks;

                    // If the player that's currently being iterated on has a higher or equal stat total
                    // than the current holder, replace the current holder with the current player that's being
                    // iterated.
                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(d.playerID));
                        List<Schedule> tempSCHDList = HashMap_Schedule.sDHashMap.get(teamID);
                        tempSCHDList = tempSCHDList.stream().sorted(Comparator.comparing((s -> s.gameWeek))).toList();

                        for (Schedule s : tempSCHDList)
                        {
                            if (s.gameNumber == d.gameNumber && s.gameWeek == d.gameWeek)
                            {
                                weekOfRecord = s.gameWeek;
                                recordOpponent = TeamLookup.getTeamName(s.opponentID);
                                break;
                            }
                        }

                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;

                        recordHolder = PositionLookup.getPosition(newHolder.positionID) + " " + newHolder.firstName
                                        + " " + newHolder.lastName + " (" + HashMap_Schedule.year + ")";
                        recordValue = currentValue;
                        recordHolderPlayerID = newHolder.playerID;

                        record[ 0] = Integer.toString(previousRecordValue);
                        record[ 2] = previousRecordHolder;
                        record[ 3] = recordHolder;
                        record[ 5] = recordHolderPlayerID;
                        record[ 9] = Integer.toString(weekOfRecord);
                        record[10] = recordOpponent;
                        record[14] = Integer.toString(recordValue);
                    }
                }
            } default -> throw new IllegalStateException("Unexpected value: " + offOrDef);
        } return record;
    }
}