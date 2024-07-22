package NCAARecordHandler;

import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.Objects;

import Resources.TeamLookup;
import Resources.TeamLookup_Abv;
import DataStructures.Objects.*;
import DataStructures.HashMap_Schedule;

import static DataStructures.List_OIGS.oIGSList;
import static DataStructures.List_DIGS.dIGSList;
import static DataStructures.HashMap_RISS.rSHashMap;
import static DataStructures.HashMap_KISS.kSHashMap;
import static DataStructures.HashMap_Players.pDHashMap;

/*
record[0]  = Previous Record Value           (RCDA) | record[1]  = ??? - May be Unused             (RCDD)
record[2]  = Previous Record Holder          (RCDE) | record[3]  = Current Record Holder           (RCDH)
record[4]  = Record Description              (RCDI) | record[5]  = Current Record Holder Player ID (RCDL)
record[6]  = ??? - May be Unused             (RBDM) | record[7]  = ??? - May be Unused             (RPDM)
record[8]  = Season Week Record Was Broken   (SEWN) | record[9]  = Opponent                        (RCDO)
record[10  = ??? - May be Unused             (RCDP) | record[11] = ??? - May be Unused             (RCDR)
record[12] = User Profile When Record Broken (RCDU) | record[13] = Record Value                    (RCDV)
record[14] = ??? - May be Unused             (RCDY)
*/

public class NCAARecord_IndGame_LongComparator
{
    public static String[] compareGameRecords(String[] record, int recordDescription)
    {
        int previousRecordValue;
        int recordValue = Integer.parseInt(record[13]);
        int weekOfRecord = Integer.parseInt(record[8]);

        String teamAbv;
        String previousRecordHolder;
        String recordHolder = record[3];
        String recordOpponent = record[10];
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
            // Longest Pass Record
            case 1 ->
            {
                for (OIGS o : oIGSList)
                {
                    int currentValue = o.longestPass;

                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(o.playerID));
                        List<Schedule> tempSCHDList = HashMap_Schedule.sDHashMap.get(o.teamID);
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
                        record[8] = String.valueOf(weekOfRecord);
                        record[9] = recordOpponent;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Longest Rush Record
            case 2 ->
            {
                for (OIGS o : oIGSList)
                {
                    int currentValue = o.longestRun;

                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(o.playerID));
                        List<Schedule> tempSCHDList = HashMap_Schedule.sDHashMap.get(o.teamID);
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
                        record[8] = String.valueOf(weekOfRecord);
                        record[9] = recordOpponent;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Longest Punt Record
            case 3 ->
            {
                for (Map.Entry<Integer, KISS> key : kSHashMap.entrySet())
                {
                    KISS k = key.getValue();
                    int currentValue = k.longestPunt;

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

            // Longest Field Goal Record
            case 4 ->
            {
                for (Map.Entry<Integer, KISS> key : kSHashMap.entrySet())
                {
                    KISS k = key.getValue();
                    int currentValue = k.longestFG;

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

            // Longest Punt Return Record
            case 5 ->
            {
                for (Map.Entry<Integer, RISS> key : rSHashMap.entrySet())
                {
                    RISS r = key.getValue();
                    int currentValue = r.longestPuntReturn;

                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(r.playerID));

                        teamAbv = TeamLookup_Abv.getTeamName_Abv(r.teamID);
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

            // Longest Kick Return Record
            case 6 ->
            {
                for (Map.Entry<Integer, RISS> key : rSHashMap.entrySet())
                {
                    RISS r = key.getValue();
                    int currentValue = r.longestKickReturn;

                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(r.playerID));

                        teamAbv = TeamLookup_Abv.getTeamName_Abv(r.teamID);
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

            // Longest Interception Return Record
            case 7 ->
            {
                for (DIGS d : dIGSList)
                {
                    int currentValue = d.longestInterceptionReturn; // Set variable to list of KIGS

                    if (currentValue >= recordValue)
                    {
                        // Get the current iterated player's information from the players' hashmap.
                        Player newHolder = pDHashMap.get(Integer.parseInt(d.playerID));
                        List<Schedule> tempSCHDList = HashMap_Schedule.sDHashMap.get(d.teamID);
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
                        record[8] = String.valueOf(weekOfRecord);
                        record[9] = recordOpponent;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Longest Fumble Return Record
            case 8 ->
            {
                for (Map.Entry<Integer, Player> key : pDHashMap.entrySet())
                {
                    Player p = key.getValue();

                    if (p.playerID.equals(record[5]))
                    {
                        teamAbv = TeamLookup_Abv.getTeamName_Abv(p.teamID);
                        recordHolder = p.firstName + " " + p.lastName + " - " +  teamAbv + " (" + HashMap_Schedule.year + ")";

                        record[3] = recordHolder;
                    }
                }
            }
        }
        return record;
    }
}
