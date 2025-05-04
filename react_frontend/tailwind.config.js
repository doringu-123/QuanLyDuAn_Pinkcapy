/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}", // Đảm bảo đường dẫn đúng
  ],
  theme: {
    extend: {
      colors: {
        'shakespeare': {
    '50': '#f1fafe',
    '100': '#e2f4fc',
    '200': '#bfe8f8',
    '300': '#86d6f3',
    '400': '#45c2eb',
    '500': '#28b3e2',
    '600': '#108ab9',
    '700': '#0e6e96',
    '800': '#105c7c',
    '900': '#134d67',
    '950': '#0d3144',
},
        'bright-sun-400': '#FFD700', // Thay bằng mã màu mong muốn
        'mine-900': '#1A1A1A', // Thay bằng mã màu mong muốn
        brightSun: {
          4: "#FFD700", // Thay bằng mã màu mong muốn
        },
 // Custom secondary color
      },
    },
  },
  plugins: [],
}