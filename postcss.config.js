import tailwindConfig from "./tailwind.config.js";

export default (api) => {
  const tailwindcss = tailwindConfig(api);
  const plugins = {
    "tailwindcss/nesting": {},
    "postcss-import": {},
    tailwindcss,
    autoprefixer: {},
  };
  if (api.mode === "production") {
    plugins.cssnano = {};
  }
  return {
    plugins,
  };
};
