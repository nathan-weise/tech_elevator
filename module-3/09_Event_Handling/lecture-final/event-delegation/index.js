// @ts-nocheck

const itemList = document.querySelector('ul');
itemList.addEventListener('click', event => {
	event.target.style.backgroundColor = event.target.innerText;
});

function addOrange() {
	const orange = document.createElement('li');
	orange.innerText = 'Orange';
	colors.appendChild(orange);
}

document.addEventListener('DOMContentLoaded', () => {
	const button = document.getElementById('btnAddOrange');
	button.addEventListener('click', addOrange);
});