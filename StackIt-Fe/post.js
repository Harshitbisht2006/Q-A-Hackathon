document.querySelector('.back-button').addEventListener('click', () => {
  history.back();
});

document.addEventListener('DOMContentLoaded', () => {
  const errorMessage = document.querySelector('.error-message');
 
  const success = false; 

  if (success) {
    errorMessage.style.display = 'none';
  } else {
    errorMessage.style.display = 'block';
  }
});

document.querySelector('.post-form').addEventListener('submit', (e) => {
  e.preventDefault();

  const title = document.getElementById('title').value.trim();
  const category = document.getElementById('category').value;

  if (!title || !category) {
    alert('Please fill in all required fields.');
    return;
  }

  const content = document.getElementById('content').value.trim();
  const tags = document.getElementById('tags').value.trim();

  const postData = {
    title,
    content,
    category,
    tags
  };

  console.log('Form submitted:', postData);

  alert('Post submitted successfully!');

});