document.addEventListener('DOMContentLoaded', function () {
  const form = document.querySelector('.searchbar');

  form.addEventListener('submit', function (e) {
    e.preventDefault();

    const email = form.querySelector('input[type="text"]').value.trim();
    const password = form.querySelector('input[type="password"]').value.trim();

    // Basic email validation
    if (!validateEmail(email)) {
      alert('Please enter a valid email address.');
      return;
    }

    // Basic password check
    if (password.length < 6) {
      alert('Password must be at least 6 characters long.');
      return;
    }

    // Simulated login success
    alert('Login successful! (Demo only)');
    
    // You can redirect or handle real login here
    // window.location.href = "dashboard.html";
  });

  function validateEmail(email) {
    // Simple email regex
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
  }
});
