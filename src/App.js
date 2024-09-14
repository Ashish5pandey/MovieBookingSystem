// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
// src/index.js or src/App.js
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from './components/Navbar';
import RegisterUser from './components/RegisterUser';
import LoginUser from './components/LoginUser';
import AddMovie from './components/AddMovie';
import AddTheater from './components/AddTheater';
import AddShowtime from './components/AddShowtime';
import AddBooking from './components/AddBooking';

function App() {
  return (
    <Router>
      <div>
        <Navbar />
        <Routes>
          <Route path="/" element={<h1>Welcome to Movie Booking System</h1>} />
          <Route path="/register" element={<RegisterUser />} />
          <Route path="/login" element={<LoginUser />} />
          <Route path="/add-movie" element={<AddMovie />} />
          <Route path="/add-theater" element={<AddTheater />} />
          <Route path="/add-showtime" element={<AddShowtime />} />
          <Route path="/add-booking" element={<AddBooking />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
