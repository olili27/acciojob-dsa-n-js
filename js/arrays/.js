// function binarySearch(arr, target) {
//   let l = 0;
//   let h = arr.length - 1;

//   while (l <= h) {
//     let mid = parseInt((l + h) / 2);
//     console.log(l, h, mid);
    
//     if (target > arr[mid]) {
//       l = mid + 1;
//     } else if (target < arr[mid]) {
//       h = mid - 1;
//     } else if (target == arr[mid]) {
//       return 1;
//     }
//   }

//   return -1;
// }

function binarySearch(arr, target) {
  let l = 0,
    h = arr.length - 1;

  while (l <= h) {
    let mid = parseInt((l + h) / 2);

    if (target > arr[mid]) {
      l = mid + 1;
    } else if (target < arr[mid]) {
      h = mid - 1;
    } else if (target == arr[mid]) {
      return 1;
    }
  }

  return -1;
}


let l = [1, 2, 3, 4, 6
];

console.log(binarySearch(l, 6));
