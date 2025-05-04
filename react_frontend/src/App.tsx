import React from 'react';
import ReactDOM from 'react-dom/client';
import { MantineProvider } from '@mantine/core';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import '@mantine/core/styles.css';
import HomePage from './Pages/HomePage';
import './index.css';
import FindJobs from './Pages/FindJobs';
import Header from './Header/Header';
import Footer from './Footer/Footer';

function MainApp() {
  const theme = {
    // Define your Mantine theme here if needed
  };

  return (
    <MantineProvider theme={theme}>
      <BrowserRouter>
      <Header/>
        <Routes>
          <Route path="/find-jobs" element={<FindJobs />} />
          <Route path="*" element={<HomePage />} />
        </Routes>
        <Footer/>
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
