// src/components/AddTheater.jsx
import React, { useState } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap

function AddTheater() {
  const [theater, setTheater] = useState({
    name: '',
    location: '',
    capacity: ''
  });

  const handleChange = (e) => {
    setTheater({ ...theater, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/api/theaters', theater);
      console.log('Theater added', response.data);
    } catch (error) {
      console.error('Error adding theater', error);
    }
  };

  return (
    <div className="d-flex justify-content-center align-items-center vh-100">
      <div className="card p-4" style={{ width: '400px' }}>
        <h2 className="text-center">Add Theater</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label htmlFor="name" className="form-label">Name</label>
            <input
              type="text"
              className="form-control"
              id="name"
              name="name"
              placeholder="Enter theater name"
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="location" className="form-label">Location</label>
            <input
              type="text"
              className="form-control"
              id="location"
              name="location"
              placeholder="Enter location"
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="capacity" className="form-label">Capacity</label>
            <input
              type="number"
              className="form-control"
              id="capacity"
              name="capacity"
              placeholder="Enter seating capacity"
              onChange={handleChange}
              required
            />
          </div>

          <div className="text-center">
            <button type="submit" className="btn btn-primary">Add Theater</button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default AddTheater;
