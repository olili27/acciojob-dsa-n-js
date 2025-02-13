// let obj = {
//     name: "student",
//     getKeys() {
//         return Object.keys(obj)
//     }
// }

// console.log(obj.getKeys());


// ===================================================================
let obj = {
  name: "student",
  getKeys() {
    let keys = Object.keys(obj);
    return keys.filter((key) => key !== this.getKeys.name);
  },
};

// console.log(obj.getKeys());
// console.log(Object.getPrototypeOf(obj));

let student = Object.create(obj)
console.log(student);
console.log(Object.getPrototypeOf(student));

