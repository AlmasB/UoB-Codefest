package year2018.nov;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public final class WeatherData {

    public enum WeatherStatus {
        SUNNY, RAIN, CLOUDY
    }

    public enum WindDirection {
        SOUTH, EAST, WEST, NORTH
    }

    public enum PollutionLevel {
        LOW, MEDIUM, HIGH
    }

    private String cityName;
    private String countryName;
    private String weatherStationName;

    // Celsius
    private double temperature;

    // m/s
    private double windSpeed;

    private WindDirection windDirection;

    // [0-100] %
    private double humidity;

    // [0-100] %
    private double chanceOfRain;

    private WeatherStatus status;

    // kPa
    private double atmosphericPressure;

    private PollutionLevel pollutionLevel;

    // [0-23]
    private int hours;

    // [0-59]
    private int minutes;

    public WeatherData(String cityName,
                       String countryName,
                       String weatherStationName,
                       double temperature,
                       double windSpeed,
                       WindDirection windDirection,
                       double humidity,
                       double chanceOfRain,
                       WeatherStatus status,
                       double atmosphericPressure,
                       PollutionLevel pollutionLevel,
                       int hours,
                       int minutes) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.weatherStationName = weatherStationName;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.humidity = humidity;
        this.chanceOfRain = chanceOfRain;
        this.status = status;
        this.atmosphericPressure = atmosphericPressure;
        this.pollutionLevel = pollutionLevel;
        this.hours = hours;
        this.minutes = minutes;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getWeatherStationName() {
        return weatherStationName;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public WindDirection getWindDirection() {
        return windDirection;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getChanceOfRain() {
        return chanceOfRain;
    }

    public WeatherStatus getStatus() {
        return status;
    }

    public double getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public PollutionLevel getPollutionLevel() {
        return pollutionLevel;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}
