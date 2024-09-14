// src/components/AddBooking.jsx
import React, { useState } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap

function AddBooking() {
  const [booking, setBooking] = useState({
    bookingDate: '',
    numberOfTickets: '',
    totalPrice: '',
    userId: '',
    showtimeId: ''
  });

  const handleChange = (e) => {
    setBooking({ ...booking, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        `http://localhost:8080/api/bookings?userId=${booking.userId}&showtimeId=${booking.showtimeId}`,
        booking
      );
      console.log('Booking added', response.data);
    } catch (error) {
      console.error('Error adding booking', error);
    }
  };

  return (
    <div className="d-flex justify-content-center align-items-center vh-100">
      <div className="card p-4" style={{ width: '400px' }}>
        <h2 className="text-center">Add Booking</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label htmlFor="bookingDate" className="form-label">Booking Date</label>
            <input
              type="date"
              className="form-control"
              id="bookingDate"
              name="bookingDate"
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="numberOfTickets" className="form-label">Number of Tickets</label>
            <input
              type="number"
              className="form-control"
              id="numberOfTickets"
              name="numberOfTickets"
              placeholder="Enter Number of Tickets"
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="totalPrice" className="form-label">Total Price</label>
            <input
              type="number"
              className="form-control"
              id="totalPrice"
              name="totalPrice"
              placeholder="Enter Total Price"
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="userId" className="form-label">User ID</label>
            <input
              type="number"
              className="form-control"
              id="userId"
              name="userId"
              placeholder="Enter User ID"
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="showtimeId" className="form-label">Showtime ID</label>
            <input
              type="number"
              className="form-control"
              id="showtimeId"
              name="showtimeId"
              placeholder="Enter Showtime ID"
              onChange={handleChange}
              required
            />
          </div>

          <div className="text-center">
            <button type="submit" className="btn btn-primary">Add Booking</button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default AddBooking;
