import React from 'react';
import { MantineProvider } from '@mantine/core';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import '@mantine/core/styles.css';
import HomePage from './Pages/HomePage';

function App() {
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

export default App;
