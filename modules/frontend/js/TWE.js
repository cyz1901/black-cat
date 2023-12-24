import { Chart, initTE, Sidenav } from "tw-elements";

class TWE {
  init() {
    console.log("init");
    initTE({ Chart, Sidenav });
  }
}

export { TWE };
