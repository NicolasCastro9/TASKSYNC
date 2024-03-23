const socket = io('http://localhost:3000'); // Adjust the URL accordingly

// Function to fetch tasks from the backend
function fetchTasks() {
  fetch('http://localhost:8080/tasks') // Adjust the URL accordingly
    .then(response => response.json())
    .then(tasks => {
      tasks.forEach(task => {
        displayTask(task);
      });
    })
    .catch(error => console.error('Error fetching tasks:', error));
}

// Function to display a task on the whiteboard
function displayTask(task) {
  const whiteboard = document.getElementById('whiteboard');
  const note = document.createElement('div');
  note.className = 'note';
  note.innerHTML = `<strong>${task.name}</strong><br>Created by: ${task.creator}<br>Status: ${task.status}<br>Created at: ${task.created_at}`;
  whiteboard.appendChild(note);
}

// Event listener for when a task is clicked
document.addEventListener('click', function(event) {
  if (event.target.classList.contains('note')) {
    const taskId = event.target.getAttribute('data-id');
    // Fetch task details or open a modal to show details
    alert(`Task ${taskId} clicked!`);
  }
});

// WebSocket event listener for real-time updates
socket.on('taskUpdated', function(task) {
  // Update the UI to reflect changes
  const existingNote = document.querySelector(`.note[data-id="${task._id}"]`);
  if (existingNote) {
    existingNote.innerHTML = `<strong>${task.name}</strong><br>Created by: ${task.creator}<br>Status: ${task.status}<br>Created at: ${task.created_at}`;
  } else {
    displayTask(task);
  }
});

// Fetch tasks when the page loads
window.onload = fetchTasks;
