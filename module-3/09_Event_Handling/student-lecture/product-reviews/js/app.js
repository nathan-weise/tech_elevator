// @ts-nocheck

const bookTitle = 'Cigar Parties for Dummies';
let description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
let reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerText = bookTitle;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerText = description;
}

/**
 * I will display all of the reviews in the reviews array
 */
function displayReviews() {
  if ('content' in document.createElement('template')) {
    reviews.forEach((review) => {
      displayReview(review);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

/**
 *
 * @param {Object} review The review to display
 */
function displayReview(review) {
  const main = document.getElementById('main');
  const container = document.getElementById('review-template').content.cloneNode(true);
  container.querySelector('h4').innerText = review.reviewer;
  container.querySelector('h3').innerText = review.title;
  container.querySelector('p').innerText = review.review;
  // there will always be 1 star because it is a part of the template
  for (let i = 0; i < review.rating - 1; ++i) {
    const img = container.querySelector('img').cloneNode(false);
    container.querySelector('.rating').appendChild(img);
  }
  main.appendChild(container);
}

// LECTURE STARTS HERE ---------------------------------------------------------------

document.addEventListener('DOMContentLoaded', e => {
  // set the product reviews page title
  setPageTitle();
  // set the product reviews page description
  setPageDescription();
  // display all of the product reviews on our page
  displayReviews();


  const description = document.querySelector('.description');
  description.addEventListener('click', e => {
    toggleDescriptionEdit(description);
  });

  const descriptionInput = document.getElementById('inputDesc');
  descriptionInput.addEventListener('keyup', e => {
    if (e.key === 'Enter') {
      exitDescriptionEdit(e.target, true);
    }
    if (e.key === 'Escape') {
      exitDescriptionEdit(e.target, false);
    }
  });

  descriptionInput.addEventListener('mouseleave', e => {
    exitDescriptionEdit(e.target, false);
  });

  const showHideButton = document.getElementById('btnToggleForm');
  showHideButton.addEventListener('click', showHideForm);

  const saveButton = document.getElementById('btnSaveReview');
  saveButton.addEventListener('click', e => {
    e.preventDefault();
    saveReview();
  });


});

/**
 * Take an event on the description and swap out the description for a text box.
 *
 * @param {Event} event the event object
 */
function toggleDescriptionEdit(desc) {
  const textBox = desc.nextElementSibling;
  textBox.value = description;
  textBox.classList.remove('d-none');
  desc.classList.add('d-none');
  textBox.focus();
}

/**
 * Take an event on the text box and set the description to the contents
 * of the text box and then hide the text box and show the description.
 *
 * @param {Event} event the event object
 * @param {Boolean} save should we save the description text
 */
function exitDescriptionEdit(textBox, save) {
  let desc = textBox.previousElementSibling;
  if (save) {
    desc.innerText = textBox.value;
    description = textBox.value;
  }
  textBox.classList.add('d-none');
  desc.classList.remove('d-none');
}

/**
 * I will show / hide the add review form
 */
function showHideForm() {
  const form = document.querySelector('form');
  const btn = document.getElementById('btnToggleForm');

  if (form.classList.contains('d-none')) {
    form.classList.remove('d-none');
    btn.innerText = 'Hide Form';
    document.getElementById('name').focus();
  } else {
    resetFormValues();
    form.classList.add('d-none');
    btn.innerText = 'Add Review';
  }
}

/**
 * I will reset all of the values in the form.
 */
function resetFormValues() {
  const form = document.querySelector('form');
  const inputs = form.querySelectorAll('input');
  inputs.forEach((input) => {
    input.value = '';
  });
  document.getElementById('rating').value = 1;
  document.getElementById('review').value = '';
}

/**
 * I will save the review that was added using the add review from
 */
function saveReview() {

  const nameInput = document.getElementById('name');
  const titleInput = document.getElementById('title');
  const reviewInput = document.getElementById('review');
  const ratingInput = document.getElementById('rating');



  const newReview = {
    reviewer: nameInput.value,
    title: titleInput.value,
    review: reviewInput.value,
    rating: ratingInput.value
  }

  reviews.push(newReview);
  displayReview(newReview);

  showHideForm();

}
