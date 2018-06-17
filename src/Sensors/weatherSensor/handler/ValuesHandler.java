package Sensors.weatherSensor.handler;

public class ValuesHandler {
    public int weatherSetHandler(String newValue){
        return getWeatherId(newValue);
    }

    public int forecastSetHandler(String newValue){
        return getWeatherId(newValue);
    }

    private int getWeatherId(String weatherValue){
        int weatherId = 0;
        switch (weatherValue) {
            case "thunderstorm with light rain": weatherId = 200; break;
            case "thunderstorm with rain": weatherId = 201; break;
            case "thunderstorm with heavy rain": weatherId = 202; break;
            case "light thunderstorm": weatherId = 210; break;
            case "thunderstorm": weatherId = 211; break;
            case "heavy thunderstorm": weatherId = 212; break;
            case "ragged thunderstorm": weatherId = 221; break;
            case "thunderstorm with light drizzle": weatherId = 230; break;
            case "thunderstorm with drizzle": weatherId = 231; break;
            case "thunderstorm with heavy drizzle": weatherId = 232; break;
            case "light intensity drizzle": weatherId = 300; break;
            case "drizzle": weatherId = 301; break;
            case "heavy intensity drizzle": weatherId = 302; break;
            case "light intensity drizzle rain": weatherId = 310; break;
            case "drizzle rain": weatherId = 311; break;
            case "heavy intensity drizzle rain": weatherId = 312; break;
            case "shower rain and drizzle": weatherId = 313; break;
            case "heavy shower rain and drizzle": weatherId = 314; break;
            case "shower drizzle": weatherId = 321; break;
            case "light rain": weatherId = 500; break;
            case "moderate rain": weatherId = 501; break;
            case "heavy intensity rain": weatherId = 502; break;
            case "very heavy rain": weatherId = 503; break;
            case "extreme rain": weatherId = 504; break;
            case "freezing rain": weatherId = 511; break;
            case "light intensity shower rain": weatherId = 520; break;
            case "shower rain": weatherId = 521; break;
            case "heavy intensity shower rain": weatherId = 522; break;
            case "ragged shower rain": weatherId = 531; break;
            case "light snow": weatherId = 600; break;
            case "snow": weatherId = 601; break;
            case "heavy snow": weatherId = 602; break;
            case "sleet": weatherId = 611; break;
            case "shower sleet": weatherId = 612; break;
            case "light rain and snow": weatherId = 615; break;
            case "rain and snow": weatherId = 616; break;
            case "light shower snow": weatherId = 620; break;
            case "shower snow": weatherId = 621; break;
            case "heavy shower snow": weatherId = 622; break;
            case "mist": weatherId = 701; break;
            case "smoke": weatherId = 711; break;
            case "haze": weatherId = 721; break;
            case "sand, dust whirls": weatherId = 731; break;
            case "fog": weatherId = 741; break;
            case "sand": weatherId = 751; break;
            case "dust": weatherId = 761; break;
            case "volcanic ash": weatherId = 762; break;
            case "squalls": weatherId = 771; break;
            case "tornado": weatherId = 781; break;
            case "clear sky": weatherId = 800; break;
            case "few clouds": weatherId = 801; break;
            case "scattered clouds": weatherId = 802; break;
            case "broken clouds": weatherId = 803; break;
            case "overcast clouds": weatherId = 804; break;
        }
        return weatherId;
    }


}
