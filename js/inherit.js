class car{
    constructor(color, weight, fuel) {
        this.color = color;
        this.weight = weight;
        this.fuel = fuel;
    }
}

class Mahindra{
    constructor(model, isSunRoof, mfd) {
        // super(arg1...)
        this.mfd = mfd;
        this.isSunRoof = isSunRoof;
        this.model = model;
        this.brand = "Mahindra";
    }
}

let car1 = Mahindra("sports", "mahindra")