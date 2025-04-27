import React from 'react';
import ReactDOM from 'react-dom/client';
import { MantineProvider } from '@mantine/core';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import '@mantine/core/styles.css';
import HomePage from './Pages/HomePage';
import './index.css';

function MainApp() {
  const theme = {
    // Define your Mantine theme here if needed
  };

  return (
    <MantineProvider theme={theme}>
      <BrowserRouter>
        <Routes>
          <Route path="*" element={<HomePage />} />
        </Routes>
      </BrowserRouter>
    </MantineProvider>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root') as HTMLElement);
root.render(
  <React.StrictMode>
    <MainApp />
  </React.StrictMode>
);

export default MainApp;
