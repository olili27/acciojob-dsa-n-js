// shotgun
// machine

// throttleFn -> it's a technique to limit the execution
// of an event when this event triggers continuesly 
// due to user's actions

let machineCount = 0;
let shotgunCount = 0;

let normalCountDisplay = document.getElementById("normal-count");
let throttleCountDisplay = document.getElementById("throttle-count");

const trigger = document.getElementById("trigger");

function shotgunFireHandle() {
  shotgunCount++;
  throttleCountDisplay.innerText = shotgunCount;
}

const throttleFn = (callBackFn, coolDownTime) => {
  let lastExeFnTime = 0;
  return function (...args) {
    let currentTime = new Date().getTime(); // currentTime in milli seconds
    if (currentTime - lastExeFnTime < coolDownTime) {
      // don't do anything
      return;
    } else {
      callBackFn(...args);
      lastExeFnTime = currentTime;
    }
  };
};
const actualShotGun = throttleFn(shotgunFireHandle,400);

trigger.addEventListener("click", () => {
  machineCount++;
  normalCountDisplay.innerText = machineCount;
  actualShotGun();
});



    // console.log(new Date().getTime());
    // for(let i=0;i<1000;i++){
    //     console.log('g');
    // }
    // console.log(new Date().getTime());


    function test(){
        return;
    }


    console.log(test());