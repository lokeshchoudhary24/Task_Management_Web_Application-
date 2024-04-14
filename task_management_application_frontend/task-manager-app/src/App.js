import React, { createContext, useContext, useState } from 'react';
import { BrowserRouter as Router, Link, Route, Routes, Navigate } from 'react-router-dom';
import TasksList from './TasksList';
import TaskDetails from './TaskDetails';
import TaskForm from './TaskForm';
import LoginForm from './LoginForm';
import ProtectedComponent from './ProtectedComponent';

// Create a context to manage user authentication state
const AuthContext = createContext();

const App = () => {
    const [user, setUser] = useState(null);

    const login = (userData) => {
        // Simulate successful login 
        setUser(userData);
        // Store user data in local storage or session storage for persistence
    };

    const logout = () => {
        // Clear user data from state and local storage
        setUser(null);
    };

    return (
        <AuthContext.Provider value={{ user, login, logout }}>
            <Router>
                <div>
                    <h1>Task Manager</h1>
                    <nav>
                        <ul>
                            <li><Link to="/">Tasks List</Link></li>
                            {user ? (
                                <>
                                    <li><Link to="/add">Add Task</Link></li>
                                    <li><button onClick={logout}>Logout</button></li>
                                </>
                            ) : (
                                <li><Link to="/login">Login</Link></li>
                            )}
                        </ul>
                    </nav>
                    <Routes>
                        <Route path="/" element={<TasksList />} />
                        <Route path="/add" element={user ? <TaskForm /> : <Navigate to="/login" />} />
                        <Route path="/edit/:id" element={user ? <TaskForm /> : <Navigate to="/login" />} />
                        <Route path="/tasks/:id" element={<TaskDetails />} />
                        <Route path="/login" element={<LoginForm />} />
                        <Route path="/protected" element={user ? <ProtectedComponent user={user} /> : <Navigate to="/login" />} />
                    </Routes>
                </div>
            </Router>
        </AuthContext.Provider>
    );
};

// Custom hook to use authentication context
const useAuth = () => useContext(AuthContext);

export { useAuth };
export default App;
