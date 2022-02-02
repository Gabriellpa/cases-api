package br.com.grabriellpa.casesapi.v1.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "globalCovidData", url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series")
public interface CoronaVirusGitHubCSSEGIClient {

    @GetMapping("/time_series_covid19_confirmed_global.csv")
    String getConfirmed();

    @GetMapping("/time_series_covid19_deaths_global.csv")
    String getDeaths();

    @GetMapping("/time_series_covid19_recovered_global.csv")
    String getRecovered();

    @GetMapping("/{type}")
    String getDataByType(@PathVariable("type") String type);

}
