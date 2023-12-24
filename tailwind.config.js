import scalaVersion from "./scala-version.js";
import { addDynamicIconSelectors } from "@iconify/tailwind";

export default (api) => {
  const scalajsMode = api.env === "production" ? "opt" : "fastopt";
  return {
    content: [
      `./modules/frontend/target/scala-${scalaVersion}/frontend-${scalajsMode}/*.js`,
      "./index.html",
      "./node_modules/preline/dist/*.js",
    ],
    plugins: [addDynamicIconSelectors(), import("preline/plugin.js")],
    theme: {
      extend: {
        fontFamily: {
          Roboto: ["Roboto"],
        },
      },
    },
  };
};
