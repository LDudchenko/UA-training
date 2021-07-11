
public final class Region {
    private final String name;
    private final City mainCity;
    private final double area;

    public Region(String name, City mainCity, double area) {
        this.name = name;
        this.mainCity = mainCity.clone();
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public City getMainCity() {
        return mainCity.clone();
    }

    public double getArea() {
        return area;
    }

    public Region setName(String name) {
        return new Region(name, this.mainCity, this.area);
    }


    public Region setMainCity(City mainCity) {
        return new Region(this.name, mainCity, this.area);
    }


    public Region setArea(double area) {
        return new Region(this.name, this.mainCity, area);
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", mainCity=" + mainCity +
                ", area=" + area +
                '}';
    }
}

class City implements Cloneable {
    private String name;
    private int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public City clone() {
        try {
            return (City) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Невозможно клонировать");
        }
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}

class Start {
    public static void main(String[] args) {
        City lviv = new City("Lviv", 721_301);
        Region region = new Region("Lvivskiy", lviv, 21_831);

        System.out.println(region);

        lviv.setPopulation(821_301);
        System.out.println(region);

        region.setName("Zapadniy");
        System.out.println(region);

        City city = region.getMainCity();
        city.setName("Lemberg");
        System.out.println(region);
    }
}