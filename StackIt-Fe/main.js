document.getElementById('questionForm').addEventListener('submit', function (e) {
  e.preventDefault();
  const input = document.getElementById('questionInput').value.trim();
  if (input) {
    showAnswer(input);
  }
});


function showAnswer(question) {
  const answerBox = document.getElementById('answerBox');
  let answer = '';

  const q = question.toLowerCase();

  if (q.includes('center a div')) {
    answer = 'Use `margin: 0 auto;` or Flexbox: `display: flex; justify-content: center; align-items: center;` for full centering.';
  } else if (q.includes('flexbox')) {
    answer = 'Flexbox is a layout module that arranges elements using `display: flex`, supporting alignment, distribution, and spacing.';
  } else if (q.includes('var let const')) {
    answer = '`var` is function-scoped, `let` and `const` are block-scoped. Prefer `const` unless reassignment is needed.';
  } else {
    answer = 'Great question! A team member will review and answer soon.';
  }

  answerBox.textContent = answer;
  answerBox.style.display = 'block';
}

document.querySelectorAll('#sampleList li').forEach(item => {
  item.addEventListener('click', () => {
    const question = item.getAttribute('data-question');
    showAnswer(question);
  });
});