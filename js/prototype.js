const myDate = new Date();

let obj = myDate;

let i = 0;

do {
    obj = Object.getPrototypeOf(obj);
    console.log(obj);
    console.log(++i);
    
} while(obj);