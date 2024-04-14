import React, { useState, useEffect } from 'react';
import axios from 'axios';

const TaskDetails = ({ match }) => {
  const [task, setTask] = useState(null);

  useEffect(() => {
    const fetchTask = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/tasks/${match.params.id}`);
        setTask(response.data);
      } catch (error) {
        console.error('Error fetching task details:', error);
      }
    };

    fetchTask();
  }, [match.params.id]);

  if (!task) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h2>Task Details</h2>
      <p>Title: {task.title}</p>
      <p>Description: {task.description}</p>
      <p>Completed: {task.completed ? 'Yes' : 'No'}</p>
    </div>
  );
};

export default TaskDetails;
