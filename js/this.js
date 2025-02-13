var obj = {name: "tim"}
    
function sayHello() {
    return "Hello " + this.name;
}

console.log(sayHello());
