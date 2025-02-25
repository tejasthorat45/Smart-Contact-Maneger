// tailwind.config.js
module.exports = {
    darkMode: 'class', // Enable dark mode by adding 'dark' class to an element
    content: [
      './src/**/*.{html,js}', // Adjust according to your file structure
    ],
    theme: {
      extend: {},
    },
    variants: {
      extend: {
        backgroundColor: ['hover'],
      },
    },
    plugins: [],
  };
  