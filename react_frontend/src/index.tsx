import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";

const rootElement = document.getElementById("root");
if (rootElement) {
  const root = ReactDOM.createRoot(rootElement);
  // Đúng cách để cập nhật giao diện
  root.render(
    <React.StrictMode>
      <App />
    </React.StrictMode>
  );
}
