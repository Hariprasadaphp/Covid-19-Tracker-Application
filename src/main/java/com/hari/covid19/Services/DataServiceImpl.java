package com.hari.covid19.Services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

import com.hari.covid19.Model.LocationStats;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl {
    private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private ArrayList<LocationStats> locationStats = new ArrayList<LocationStats>();
    public ArrayList<LocationStats> getLocationStatsgetlocationStats()
     {
          return locationStats;
     }
    @PostConstruct
    public void fetchVirusData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                             .uri(URI.create(VIRUS_DATA_URL))
                             .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        StringReader virusData = new StringReader(response.body());
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(virusData);
        ArrayList<LocationStats> todaystats = new ArrayList<LocationStats>();
        for (CSVRecord record : records) {
            LocationStats currentstats = new LocationStats();
            String state = record.get("Province/State");
            String country = record.get("Country/Region");
            long previousDayCount = Long.parseLong(record.get(record.size()-2));
            long todaysCount = Long.parseLong(record.get((record.size())-1));
            currentstats.setState(state);
            currentstats.setCountry(country);
            currentstats.setPreviousDayCases(previousDayCount);
            currentstats.setCurrentDayCases((todaysCount));
            currentstats.setChangesInCasesAsOfToday(todaysCount-previousDayCount);
            todaystats.add(currentstats);
        }
        this.locationStats = todaystats;
    }
}