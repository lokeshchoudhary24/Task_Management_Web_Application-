import React, { useState } from 'react';
import axios from 'axios';
import './TaskForm.css';


const TaskForm = ({ onSubmit, initialValues = {} }) => {
  const [formData, setFormData] = useState(initialValues);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await onSubmit(formData);
    } catch (error) {
      console.error('Error submitting task:', error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Title:
        <input
          type="text"
          name="title"
          value={formData.title || ''}
          onChange={handleInputChange}
          required
        />
      </label>
      <label>
        Description:
        <input
          type="text"
          name="description"
          value={formData.description || ''}
          onChange={handleInputChange}
          required
        />
      </label>
      <button type="submit">Submit</button>
    </form>
  );
};

export default TaskForm;
