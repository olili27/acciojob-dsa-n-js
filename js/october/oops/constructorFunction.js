
CreateCustomer.prototype.withDraw = function (amount) {
  this.accountBalance -= amount;
};

console.log(customer1);

console.log(customer2);

customer2.withDraw(200);

console.log(customer2);
