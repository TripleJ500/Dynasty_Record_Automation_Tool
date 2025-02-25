package Resources;

import java.util.Map;
import java.util.HashMap;

public class TeamLookup
{
    private final static Map<Integer, String> teamMap;

    static
    {
        teamMap = new HashMap<>();
        teamMap.put(1,   "Air Force");
        teamMap.put(2,   "Akron");
        teamMap.put(3,   "Alabama");
        teamMap.put(4,   "Arizona");
        teamMap.put(5,   "Arizona State");
        teamMap.put(6,   "Arkansas");
        teamMap.put(7,   "Arkansas State");
        teamMap.put(8,   "Army");
        teamMap.put(9,   "Auburn");
        teamMap.put(10,  "Ball State");
        teamMap.put(11,  "Baylor");
        teamMap.put(12,  "Boise State");
        teamMap.put(13,  "Boston College");
        teamMap.put(14,  "Bowling Green");
        teamMap.put(15,  "Buffalo");
        teamMap.put(16,  "BYU");
        teamMap.put(17,  "California");
        teamMap.put(18,  "UCF");
        teamMap.put(19,  "Central Michigan");
        teamMap.put(20,  "Cincinnati");
        teamMap.put(21,  "Clemson");
        teamMap.put(22,  "Colorado");
        teamMap.put(23,  "Colorado State");
        teamMap.put(24,  "Duke");
        teamMap.put(25,  "East Carolina");
        teamMap.put(26,  "Eastern Michigan");
        teamMap.put(27,  "Florida");
        teamMap.put(28,  "Florida State");
        teamMap.put(29,  "Fresno State");
        teamMap.put(30,  "Georgia");
        teamMap.put(31,  "Georgia Tech");
        teamMap.put(32,  "Hawai'i");
        teamMap.put(33,  "Houston");
        teamMap.put(34,  "Appalachian State");
        teamMap.put(35,  "Illinois");
        teamMap.put(36,  "Indiana");
        teamMap.put(37,  "Iowa");
        teamMap.put(38,  "Iowa State");
        teamMap.put(39,  "Kansas");
        teamMap.put(40,  "Kansas State");
        teamMap.put(41,  "Kent State");
        teamMap.put(42,  "Kentucky");
        teamMap.put(43,  "Louisiana Tech");
        teamMap.put(44,  "Louisville");
        teamMap.put(45,  "LSU");
        teamMap.put(46,  "Marshall");
        teamMap.put(47,  "Maryland");
        teamMap.put(48,  "Memphis");
        teamMap.put(49,  "Miami");
        teamMap.put(50,  "Miami (OH)");
        teamMap.put(51,  "Michigan");
        teamMap.put(52,  "Michigan State");
        teamMap.put(53,  "Mid Tenn State");
        teamMap.put(54,  "Minnesota");
        teamMap.put(55,  "Mississippi State");
        teamMap.put(56,  "Missouri");
        teamMap.put(57,  "Navy");
        teamMap.put(58,  "Nebraska");
        teamMap.put(59,  "Nevada");
        teamMap.put(60,  "New Mexico");
        teamMap.put(61,  "Coastal Carolina");
        teamMap.put(62,  "North Carolina");
        teamMap.put(63,  "NC State");
        teamMap.put(64,  "North Texas");
        teamMap.put(65,  "ULM");
        teamMap.put(66,  "Northern Illinois");
        teamMap.put(67,  "Northwestern");
        teamMap.put(68,  "Notre Dame");
        teamMap.put(69,  "Ohio");
        teamMap.put(70,  "Ohio State");
        teamMap.put(71,  "Oklahoma");
        teamMap.put(72,  "Oklahoma State");
        teamMap.put(73,  "Ole Miss");
        teamMap.put(74,  "Oregon");
        teamMap.put(75,  "Oregon State");
        teamMap.put(76,  "Penn State");
        teamMap.put(77,  "Pittsburgh");
        teamMap.put(78,  "Purdue");
        teamMap.put(79,  "Rice");
        teamMap.put(80,  "Rutgers");
        teamMap.put(81,  "San Diego State");
        teamMap.put(82,  "San Jose State");
        teamMap.put(83,  "SMU");
        teamMap.put(84,  "South Carolina");
        teamMap.put(85,  "Southern Miss");
        teamMap.put(86,  "Louisiana");
        teamMap.put(87,  "Stanford");
        teamMap.put(88,  "Syracuse");
        teamMap.put(89,  "TCU");
        teamMap.put(90,  "Temple");
        teamMap.put(91,  "Tennessee");
        teamMap.put(92,  "Texas");
        teamMap.put(93,  "Texas A&M");
        teamMap.put(94,  "Texas Tech");
        teamMap.put(95,  "Toledo");
        teamMap.put(96,  "Tulane");
        teamMap.put(97,  "Tulsa");
        teamMap.put(98,  "UAB");
        teamMap.put(99,  "UCLA");
        teamMap.put(100, "Charlotte");
        teamMap.put(101, "UNLV");
        teamMap.put(102, "USC");
        teamMap.put(103, "Utah");
        teamMap.put(104, "Utah State");
        teamMap.put(105, "UTEP");
        teamMap.put(106, "Vanderbilt");
        teamMap.put(107, "Virginia");
        teamMap.put(108, "Virginia Tech");
        teamMap.put(109, "Wake Forest");
        teamMap.put(110, "Washington");
        teamMap.put(111, "Washington State");
        teamMap.put(112, "West Virginia");
        teamMap.put(113, "Western Michigan");
        teamMap.put(114, "Wisconsin");
        teamMap.put(115, "Wyoming");
        teamMap.put(143, "Troy");
        teamMap.put(144, "USF");
        teamMap.put(181, "Georgia Southern");
        teamMap.put(211, "Western Kentucky");
        teamMap.put(218, "Texas State");
        teamMap.put(229, "Florida Atlantic");
        teamMap.put(230, "James Madison");
        teamMap.put(232, "UTSA");
        teamMap.put(233, "Georgia State");
        teamMap.put(234, "Old Dominion");
        teamMap.put(235, "South Alabama");
    }

    public static String getTeamName(int teamID)
    {
        return TeamLookup.teamMap.get(teamID);
    }
}