import { resolve } from "path";
import { defineConfig } from "vite";
import { createHtmlPlugin } from "vite-plugin-html";

import scalaVersion from "./scala-version";
import requireTransform from "vite-plugin-require-transform";

export default ({ mode }) => {
  const mainJS = `modules/frontend/target/scala-${scalaVersion}/frontend-${
    mode === "production" ? "opt" : "fastopt"
  }/main.js`;
  const script = `<script type="module" src="/${mainJS}"></script>`;

  return defineConfig({
    resolve: {
      alias: {
        styles: resolve(__dirname, "./modules/frontend/styles"),
        svg: resolve(__dirname, "./modules/frontend/static/svg"),
        imgs: resolve(__dirname, "./modules/frontend/static/imgs"),
        webapp: resolve(__dirname, "./modules/frontend/src/main/webapp"),
        mxml: resolve(__dirname, "./modules/frontend/static/mxml"),
        js: resolve(__dirname, "./modules/frontend/js"),
        "@": resolve(__dirname, "./node_modules"),
      },
    },
    plugins: [
      createHtmlPlugin({
        minify: mode === "production",
        viteNext: true,
        inject: {
          data: {
            script,
          },
        },
      }),
      requireTransform({
        fileRegex: /.js$/,
      }),
    ],
  });
};
