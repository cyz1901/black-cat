import scalaVersion from "./scala-version.js";
import { addDynamicIconSelectors } from "@iconify/tailwind";
import daisyui from "daisyui";

export default (api) => {
  const scalajsMode = api.env === "production" ? "opt" : "fastopt";

  return {
    content: [
      `./modules/frontend/target/scala-${scalaVersion}/frontend-${scalajsMode}/*.js`,
      "./index.html",
    ],
    plugins: [addDynamicIconSelectors(), daisyui],
    theme: {
      extend: {
        fontFamily: {
          Roboto: ["Roboto"],
        },
      },
    },
  };
};
