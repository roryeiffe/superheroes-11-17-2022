let first = ['a','b','c','d'];
let second = ['e','f','g','h']

// combine these into one array to make [a,b,c,d,e,f,g,h]: 
let third = [];
for(let i = 0; i < first.length; i ++) {
    third.push(first[i]);
}

for(let i = 0; i < second.length; i ++) {
    third.push(second[i]);
}

console.log(third);

// this won't work, because it will give us 2 arrays within the outer array:
console.log([first, second]);

// the spread operator takes the elements and spreads them out, eliminating the nested array situation we got previously:
console.log("Using spread:")
console.log([...first, ...second]);
console.log([...first, second]);

// adding new elements:
third = [...first, ...second, 'i','j','k','l'];
console.log(third);

// Objects:

let person = {
    name: 'Michael',
    position: 'manager'
}

// add a new attribute to this object:
person.movie = 'threat level midnight';
console.log(person);

let extra_attributes = {
    employees: ["Jim", "Pam", "Dwight"]

}

// we can use spread operator to keep existing elements:
person = {
    // keeping.copying the attributes already stored in the object (using spread):
    ...person,
    // adding new ones as well
    age: 40,
    ...extra_attributes
}

console.log(person);


// rest operator, can only use the REST operator on the last parameter:
function sumNumbers(first, ...numbers) {
    let sum = 0;
    console.log("First: " + first);
    // because of the rest operator, it treats the arguments as an array:
    for(let i = 0; i < numbers.length; i ++) {
        sum += numbers[i];
    }
    return sum;
}

// instead of passing in an array, we want to pass n number of arguments
console.log(sumNumbers(1,2,3,4,5,6,7,8,9,10))