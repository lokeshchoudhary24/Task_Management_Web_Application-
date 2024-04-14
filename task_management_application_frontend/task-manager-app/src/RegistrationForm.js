import React, { useState } from 'react';
import axios from 'axios';

const RegistrationForm = () => {
    const [formData, setFormData] = useState({
        username: '',
        password: ''
    });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleRegistration = async (e) => {
        e.preventDefault();
        try {
            await axios.post('http://localhost:8080/auth/register', formData);
            // Redirect to login page or show success message
        } catch (error) {
            console.error('Registration failed:', error);
        }
    };

    return (
        <form onSubmit={handleRegistration}>
            <label>
                Username:
                <input type="text" name="username" value={formData.username} onChange={handleInputChange} required />
            </label>
            <label>
                Password:
                <input type="password" name="password" value={formData.password} onChange={handleInputChange} required />
            </label>
            <button type="submit">Register</button>
        </form>
    );
};

export default RegistrationForm;
