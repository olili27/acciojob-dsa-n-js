public class Main {
    public static void main(String[] args) {

        Car bmw = new Car("bmw", "red", "v8");
        Car benz = new Car("benz", "blue", "v12");
        Car jeep = new Car("jeep", "black", "v15");

        Jeep normalJeep = new Jeep("jeep", "black", "v16");
        Car wrangler = new Wrangler("jeep", "black", "v16", "wrangler");

        jeep.startCar();
        normalJeep.startCar();
//        System.out.println("normal jeep: " + normalJeep.type);
        wrangler.startCar();
//        System.out.println("wrangler: " + wrangler.type);
    }
}