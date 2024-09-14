// src/components/AddShowtime.jsx
import React, { useState } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap

function AddShowtime() {
  const [showtime, setShowtime] = useState({
    showDate: '',
    showTime: '',
    movieId: '',
    theaterId: ''
  });

  const handleChange = (e) => {
    setShowtime({ ...showtime, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        `http://localhost:8080/api/showtimes?movieId=${showtime.movieId}&theaterId=${showtime.theaterId}`,
        showtime
      );
      console.log('Showtime added', response.data);
    } catch (error) {
      console.error('Error adding showtime', error);
    }
  };

  return (
    <div className="d-flex justify-content-center align-items-center vh-100">
      <div className="card p-4" style={{ width: '400px' }}>
        <h2 className="text-center">Add Showtime</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label htmlFor="showDate" className="form-label">Show Date</label>
            <input
              type="date"
              className="form-control"
              id="showDate"
              name="showDate"
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="showTime" className="form-label">Show Time</label>
            <input
              type="time"
              className="form-control"
              id="showTime"
              name="showTime"
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="movieId" className="form-label">Movie ID</label>
            <input
              type="number"
              className="form-control"
              id="movieId"
              name="movieId"
              placeholder="Enter Movie ID"
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="theaterId" className="form-label">Theater ID</label>
            <input
              type="number"
              className="form-control"
              id="theaterId"
              name="theaterId"
              placeholder="Enter Theater ID"
              onChange={handleChange}
              required
            />
          </div>

          <div className="text-center">
            <button type="submit" className="btn btn-primary">Add Showtime</button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default AddShowtime;
