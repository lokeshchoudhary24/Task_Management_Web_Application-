import React, { useState } from 'react';
import { useAuth } from './App';
import axios from 'axios';

const LoginForm = () => {
    const { login } = useAuth();
    const [formData, setFormData] = useState({
        username: '',
        password: ''
    });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/auth/login', formData);
            login(response.data); 
        } catch (error) {
            console.error('Login failed:', error);
        }
    };

    return (
        <form onSubmit={handleLogin}>
            <label>
                Username:
                <input type="text" name="username" value={formData.username} onChange={handleInputChange} required />
            </label>
            <label>
                Password:
                <input type="password" name="password" value={formData.password} onChange={handleInputChange} required />
            </label>
            <button type="submit">Login</button>
        </form>
    );
};

export default LoginForm;
