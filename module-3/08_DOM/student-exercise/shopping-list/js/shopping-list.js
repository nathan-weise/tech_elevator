//@ts-nocheck

// add pageTitle
const pageTitle = 'My Shopping List';

// add groceries
const groceries = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10']

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {

  const targetSpan = document.getElementById('title');

  targetSpan.innerText = pageTitle;

}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {

  const groceryList = document.getElementById('groceries');

  groceries.forEach(item => {
    
    const container = document.createElement('li');

    container.innterText = item;

    groceryList.appendChild(container);

  })

}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {

  const allItems = document.querySelectorAll('li');

  for (let items of allItems) {
    items.classList.add('completed');
  }

}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
