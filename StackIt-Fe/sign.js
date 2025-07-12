document.addEventListener('DOMContentLoaded', () => {
  const form = document.querySelector('.registerForm form');

  form.addEventListener('submit', async (e) => {
    e.preventDefault();

    // Get input values
    const email = form.querySelector('input[placeholder="email"]').value.trim();
    const password = form.querySelector('input[placeholder="password"]').value.trim();
    const username = form.querySelector('input[placeholder="username"]').value.trim();

    // Basic validations
    if (!validateEmail(email)) {
      alert('Please enter a valid email address.');
      return;
    }

    if (password.length < 6) {
      alert('Password must be at least 6 characters.');
      return;
    }

    if (username.length < 3) {
      alert('Username must be at least 3 characters.');
      return;
    }

    // Send POST request to backend
    try {
      const response = await fetch('http://localhost:8080/register', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email, password, username })
      });

      if (response.ok) {
        const data = await response.json();
        alert('Registration successful!');
        // Optionally redirect to login page:
        // window.location.href = 'login.html';
      } else {
        const errorData = await response.json();
        alert('Error: ' + (errorData.message || 'Registration failed.'));
      }
    } catch (error) {
      console.error('Error:', error);
      alert('Failed to connect to the server.');
    }
  });

  // Helper to validate email
  function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
  }
});
