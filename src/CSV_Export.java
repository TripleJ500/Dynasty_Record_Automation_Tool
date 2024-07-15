import DataStructures.*;
import NCAARecordHandler.NCAARecordsHandler;
import SchoolRecordHandler.SchoolRecordsHandler;

import java.io.File;
import java.util.Set;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class CSV_Export
{
    protected final static Set<Integer> excludedValues = Set.of(0, 160, 161, 162, 163, 164);
    protected static void CSVExporter(String oigsCSV,
                                      String digsCSV,
                                      String oissCSV,
                                      String dissCSV,
                                      String kissCSV,
                                      String rissCSV,
                                      String tgsCSV,
                                      String ccsCSV,
                                      String sdCSV,
                                      String schoolRecordsCSV,
                                      String ncaaRecordsCSV,
                                      String playersCSV) throws IOException
    {
        File schoolRecordsCSVFile = new File(schoolRecordsCSV);
        File ncaaRecordsCSVFile   = new File(ncaaRecordsCSV);

        HashMap_Players.createPlayerHashMap(playersCSV);
        HashMap_Schedule.createScheduleHashMap(sdCSV, excludedValues);
        List_OIGS.createOIGSList(oigsCSV);
        List_DIGS.createDIGSList(digsCSV);
        HashMap_OISS_OICS.createOISSHashMap(oissCSV);
        HashMap_DISS_DICS.createDISSHashMap(dissCSV);
        HashMap_KISS.createKISSHashMap(kissCSV);
        HashMap_RISS.createRISSHashMap(rissCSV);
        List_CCS.createCCSList(ccsCSV);
        HashMap_TGS.createTGSHashMap(tgsCSV, excludedValues);

        try (ExecutorService executor = Executors.newFixedThreadPool(2))
        {
            Future<?> schoolRecordsFuture = executor.submit(new SchoolRecordsHandler(schoolRecordsCSVFile));
            Future<?> ncaaRecordsFuture = executor.submit(new NCAARecordsHandler(ncaaRecordsCSVFile));

            while(!schoolRecordsFuture.isDone())
                Thread.sleep(100);
            while(!ncaaRecordsFuture.isDone())
            {
                Thread.sleep(100);
            }
            executor.shutdown();
        }
        catch (InterruptedException e) { throw new RuntimeException(e); }
    }
}
