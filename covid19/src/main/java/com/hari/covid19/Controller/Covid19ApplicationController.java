package com.hari.covid19.Controller;

import java.util.List;

import com.hari.covid19.Model.LocationStats;
import com.hari.covid19.Services.DataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@Controller
public class Covid19ApplicationController {
    @Autowired
    DataServiceImpl dataServiceImpl;

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStats> locationStats = dataServiceImpl.getLocationStatsgetlocationStats();
        long totalCases = locationStats.stream().mapToLong(obj->obj.getCurrentDayCases()).sum();
        long changedCases = locationStats.stream().mapToLong(obj->obj.getChangesInCasesAsOfToday()).sum();
        model.addAttribute("locationStats", locationStats);
        model.addAttribute("TotalCases", totalCases);
        model.addAttribute("ChangesInCases", changedCases);
        return "home";
    }
}