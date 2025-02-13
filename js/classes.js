class parent {
    constructor() {
        this._name = "hello";
    }

    get name() {
        return this._name
    }

}

const x = new parent();
x._name = "just"
console.log(x);
console.log(x.name);
