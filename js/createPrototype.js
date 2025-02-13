// Object.create and constructors

// const personPrototype = {
//   greet() {
//     console.log("hello!");
//   },
// };

// const carl = Object.create(personPrototype);
// carl.greet(); // hello!
// console.log((Object.getPrototypeOf(carl)));


// constructor
const personPrototype = {
  greet() {
    console.log(`hello, my name is ${this.name}!`);
  },
};

function Person(name) {
  this.name = name;
}

Object.assign(Person.prototype, personPrototype);
// or
// Person.prototype.greet = personPrototype.greet;


// add to prototype
// object.__proto__.attribute = value