// src/components/AddMovie.jsx
import React, { useState } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap

function AddMovie() {
  const [movie, setMovie] = useState({
    title: '',
    description: '',
    genre: '',
    duration: '',
    rating: ''
  });

  const handleChange = (e) => {
    setMovie({ ...movie, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/api/movies', movie);
      console.log('Movie added', response.data);
    } catch (error) {
      console.error('Error adding movie', error);
    }
  };

  return (
    <div className="d-flex justify-content-center align-items-center vh-100">
      <div className="card p-4" style={{ width: '400px' }}>
        <h2 className="text-center">Add Movie</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label htmlFor="title" className="form-label">Title</label>
            <input
              type="text"
              className="form-control"
              id="title"
              name="title"
              placeholder="Enter movie title"
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="description" className="form-label">Description</label>
            <input
              type="text"
              className="form-control"
              id="description"
              name="description"
              placeholder="Enter description"
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="genre" className="form-label">Genre</label>
            <input
              type="text"
              className="form-control"
              id="genre"
              name="genre"
              placeholder="Enter genre"
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="duration" className="form-label">Duration (minutes)</label>
            <input
              type="number"
              className="form-control"
              id="duration"
              name="duration"
              placeholder="Enter duration"
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="rating" className="form-label">Rating</label>
            <input
              type="number"
              className="form-control"
              id="rating"
              name="rating"
              placeholder="Enter rating (out of 10)"
              step="0.1"
              onChange={handleChange}
              required
            />
          </div>

          <div className="text-center">
            <button type="submit" className="btn btn-primary">Add Movie</button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default AddMovie;
