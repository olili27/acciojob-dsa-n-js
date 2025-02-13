function correctMistake(line, charToBeReplaced, what) {
  // write code here
  // return the output , do not use console.log here
  return line.replaceAll(charToBeReplaced, what);
}

console.log(correctMistake("Hi World world","world","of coding"));