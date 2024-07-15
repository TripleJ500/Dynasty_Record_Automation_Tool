package DataStructures;

import DataStructures.Objects.Player;

import java.util.List;
import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
public class HashMap_Players
{
    public static HashMap<Integer, Player> pDHashMap = new HashMap<>();
    public static HashMap<Integer, List<Player>> playerByTeamHashMap = new HashMap<>();

    // Creates a hashmap of all player records in the PLAY file.
    public static void createPlayerHashMap(String playersCSV) throws IOException
    {
        String line;

        try(BufferedReader reader = new BufferedReader(new FileReader(playersCSV)))
        {
            reader.readLine();
            while ((line = reader.readLine()) != null)
            {
                String[] values = line.split(",");
                pDHashMap.put(Integer.parseInt(values[34]), new Player(values[34],
                                                                       values[15],
                                                                       values[16],
                                                                       Integer.parseInt(values[35]),
                                                                       Integer.parseInt(values[114]),
                                                                       values[36]));
                createPlayerHashMapByTeam(values[34], Integer.parseInt(values[35]));
            }
        }
    }

    // Creates a hashmap holding lists as its values holding player objects and the team ID as the key
    public static void createPlayerHashMapByTeam(String playerID, int teamID)
    {
        List<Player> tempArr;

        tempArr = playerByTeamHashMap.get(teamID) == null ? new ArrayList<>() : playerByTeamHashMap.get(teamID);
        tempArr.add(pDHashMap.get(Integer.parseInt(playerID)));
        playerByTeamHashMap.put(teamID, tempArr);
    }
}
