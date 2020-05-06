package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Responce;
import model.Weather;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.Map;

public class WeatherStepDefs {
    private String cityName;
    private String country;
    private Responce responce;

    @Given("show test name")
    public void show_test_name() {
        System.out.println("Hello, cucumber!");
    }

    @Given("city {string}")
    public void set_city(String cityName) {
        this.cityName = cityName;
    }

    @Given("country {string}")
    public void set_country(String country) {
        this.country = country;
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        responce = requester.requestWeather(cityName, country);
        // System.out.println(response.getCoord().getLat());
        // System.out.println(requester.requestWeather(cityName,country));
    }

    @Then("lon is {float}")
    public void check_lon(float lon) {
        Assertions.assertEquals(lon, responce.getCoord().getLon(), "Wrong lon");
    }

    @Then("lat is {float}")
    public void check_lat(float lat) {
        Assertions.assertEquals(lat, responce.getCoord().getLat(), "Wrong lat");
    }
    @Then("weather is:")
    public void check_weather(Map<String,String> params) {
        Weather weather = responce.getWeathers().get(0);

        Assertions.assertEquals(Long.parseLong(params.get("id")), weather.getId(), "Wrong id");
        Assertions.assertEquals(params.get("main"), weather.getMain(), "Wrong main");
        Assertions.assertEquals(params.get("description"), weather.getDescription(), "Wrong description");
        Assertions.assertEquals(params.get("icon"), weather.getIcon(), "Wrong icon");
    }

    @Then("base is: {string}")
    public void check_base(String base) {
        Assertions.assertEquals(base, responce.getBase(), "Wrong base");
    }

    @Then("main is:")
    public void check_main(Map<String,Float> params) {

        Assertions.assertEquals(params.get("temp"),responce.getMain().getTemp(), "Wrong temp");
        Assertions.assertEquals(params.get("pressure"),responce.getMain().getPressure(), "Wrong pressure");
        Assertions.assertEquals(params.get("humidity"),responce.getMain().getHumidity(), "Wrong humidity");
        Assertions.assertEquals(params.get("temp_min"),responce.getMain().getTemp_min(), "Wrong temp min");
        Assertions.assertEquals(params.get("temp_max"),responce.getMain().getTemp_max(), "Wrong temp max");
    }

    @Then("visibility is {float}")
    public void check_visibility(Float visibility) {
        Assertions.assertEquals(visibility, responce.getVisibility(), "Wrong visibility");
    }

    @Then("wind is:")
    public void check_wind(Map<String,Float> params) {

        Assertions.assertEquals(params.get("speed"),responce.getWind().getSpeed(), "Wrong speed");
        Assertions.assertEquals(params.get("deg"),responce.getWind().getDeg(), "Wrong deg");
    }

    @Then("clouds is:")
    public void check_clouds(Map<String,Float> params) {
        Assertions.assertEquals(params.get("all"),responce.getClouds().getAll(), "Wrong all");
    }

    @Then("dt is {float}")
    public void check_dt(Float dt) {
        Assertions.assertEquals(dt, responce.getDt(), "Wrong dt");
    }

    @Then("sys is:")
    public void check_sys(Map<String,String> params) {

        Assertions.assertEquals(Float.parseFloat(params.get("type")),responce.getSys().getType(), "Wrong type");
        Assertions.assertEquals(Float.parseFloat(params.get("id")),responce.getSys().getId(), "Wrong id");
        Assertions.assertEquals(Float.parseFloat(params.get("message")),responce.getSys().getMessage(), "Wrong message");
        Assertions.assertEquals(params.get("country"),responce.getSys().getCountry(), "Wrong country");
        Assertions.assertEquals(Float.parseFloat(params.get("sunrise")),responce.getSys().getSunrise(), "Wrong sunrise");
        Assertions.assertEquals(Float.parseFloat(params.get("sunset")),responce.getSys().getSunset(), "Wrong sunset");
    }

    @Then("id is {long}")
    public void check_id(long id) {
        Assertions.assertEquals(id, responce.getId(), "Wrong id");
    }

    @Then("name is {string}")
    public void check_name(String name) {
        Assertions.assertEquals(name, responce.getName(), "Wrong name");
    }

    @Then("cod is {long}")
    public void check_cod(long cod) {
        Assertions.assertEquals(cod, responce.getCod(), "Wrong cod");
    }

}
