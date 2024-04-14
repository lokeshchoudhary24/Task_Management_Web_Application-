import React from 'react';

const ProtectedComponent = ({ user }) => {
    return (
        <div>
            <h2>Welcome, {user.username}!</h2>
            <p>This is a protected component.</p>
        </div>
    );
};

export default ProtectedComponent;
