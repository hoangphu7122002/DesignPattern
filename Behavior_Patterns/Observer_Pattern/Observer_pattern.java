package Observer_Pattern;

import java.util.ArrayList;

//--------------------------------

interface Subject {
    void registerObserver(Observer obj);

    void removeObserver(Observer obj);

    void notifyObservers();
}

interface Observer {
    void update(float temp, float humidity, float pressure);
}

interface DisplayElement {
    void display();
}

// --------------------------------

class WeatherData implements Subject {
    private ArrayList<Observer> observer;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        System.out.println("Establish WeatherData");
        this.observer = new ArrayList<Observer>();
    }

    public void registerObserver(Observer obj) {
        observer.add(obj);
    }

    public void removeObserver(Observer obj) {
        int index = observer.indexOf(obj);
        if (index >= 0) {
            observer.remove(index);
        }
    }

    public void notifyObservers() {
        for (int i = 0; i < observer.size(); ++i) {
            Observer temp = (Observer) observer.get(i);
            temp.update(this.temperature, this.humidity, this.pressure);
        }
    }

    public void measurementsChanged() {
        this.notifyObservers();
    }

    public void setMeasureMent(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}

// ----------------------------------------------------------------

class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject WeatherData) {
        this.weatherData = WeatherData;
        this.weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current conditions: Temp-" + this.temperature + "  and Humidity-" + this.humidity);
    }
}

class StatisticsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float pressure;
    private Subject weatherData;

    public StatisticsDisplay(Subject WeatherData) {
        this.weatherData = WeatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("StatisticsDisplay: Temperature-" + this.temperature + " and Pressure-" + this.pressure);
    }
}

public class Observer_pattern {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        CurrentConditionDisplay currentconditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasureMent(80.f, 50.f, 32.f);
        weatherData.setMeasureMent(30.f, 20.f, 10.f);

        weatherData.removeObserver(statisticsDisplay);
        weatherData.setMeasureMent(10.f, 7.f, 1.f);
    }
}
