 const editBtn = document.querySelector('.edit-btn');
  const details = document.querySelectorAll('.customer-details .detail');
  let isEditing = false;

  editBtn.addEventListener('click', () => {
    if (!isEditing) {
      
      details.forEach(detail => {
        const span = detail.querySelector('span');
        const value = span.textContent.trim();
        const input = document.createElement('input');
        input.type = 'text';
        input.value = value;
        input.className = 'edit-input';
        detail.replaceChild(input, span);
      });
      editBtn.textContent = 'Save Details';
      isEditing = true;
    } else {
    
      details.forEach(detail => {
        const input = detail.querySelector('input');
        const value = input.value.trim();
        const span = document.createElement('span');
        span.textContent = value;
        detail.replaceChild(span, input);
      });
      editBtn.textContent = 'Edit Details';
      isEditing = false;
      alert('Details saved (mock save).'); 
    }
  });
