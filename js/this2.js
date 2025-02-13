const obj = {
    name: "abc",
    getName() {
        console.log(this);
        // console.log(this.name);
        
    }
}

const obj2 = {
    name:"xyz",
}

const askName = obj.getName.bind("fucked")
askName()