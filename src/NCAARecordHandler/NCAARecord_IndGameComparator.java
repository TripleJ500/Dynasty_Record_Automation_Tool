package NCAARecordHandler;

import java.util.List;
import java.util.Comparator;
import java.util.Objects;

import Resources.TeamLookup;
import Resources.TeamLookup_Abv;
import DataStructures.Objects.OIGS;
import DataStructures.Objects.DIGS;
import DataStructures.Objects.Player;
import DataStructures.Objects.Schedule;
import DataStructures.HashMap_Schedule;

import static DataStructures.List_OIGS.oIGSList;
import static DataStructures.List_DIGS.dIGSList;
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

public class NCAARecord_IndGameComparator
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
            // Most Passing Yards in a Game
            case 9 ->
            {
                for (OIGS o : oIGSList)
                {
                    int currentValue = o.passingYards;

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

            // Most Rushing Yards in a Game
            case 10 ->
            {
                for (OIGS o : oIGSList)
                {
                    int currentValue = o.rushingYards;

                    if (currentValue >= recordValue || o.playerID.equals(record[5]))
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

            // Most Receiving Yards in a Game
            case 11 ->
            {
                for (OIGS o : oIGSList)
                {
                    int currentValue = o.receivingYards;

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

            // Most Receptions in a Game
            case 12 ->
            {
                for (OIGS o : oIGSList)
                {
                    int currentValue = o.receptions;

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

            // Most Sacks in a Game
            case 13 ->
            {
                for (DIGS d : dIGSList)
                {
                    int currentValue = d.sacks;

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

            // Most Interceptions in a Game
            case 14 ->
            {
                for (DIGS d : dIGSList)
                {
                    int currentValue = d.interceptions;

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
        }

        return record;
    }
}
