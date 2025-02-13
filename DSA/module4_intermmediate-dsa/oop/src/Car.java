public class Car {
    String type;
    String color;
    String engineType;

    public Car(String type, String color, String engineType) {
        this.type = type;
        this.color = color;
        this.engineType = engineType;
    }

    public void startCar() {
        System.out.println("normal car: enter key");
        System.out.println("turn key");
        System.out.println("change gear");
    }
}


class Jeep extends Car {
    String type;
    Jeep(String type, String color, String engineType) {
        super(type, color, engineType);
        this.type = type;
    }

    public  void startCar() {
        System.out.println(" normal jeep: enter key");
        System.out.println("press button");
    }
//    public void startCar(String model) {
//        System.out.println("press button");
//    }
}

class Wrangler extends Jeep {
    String model;

    Wrangler(String type, String color, String engineType, String model) {
        super(type, color, engineType);
        this.model = model;
    }

    public void startCar() {
        System.out.println(" wrangler: press button");
    }
}