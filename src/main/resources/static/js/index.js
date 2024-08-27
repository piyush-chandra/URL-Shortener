// scripts.js

//const slider = document.querySelector('.testimonial-slider');
//let isDown = false;
//let startX;
//let scrollLeft;
//
//// Mouse down event - Start dragging
//slider.addEventListener('mousedown', (e) => {
//    isDown = true;
//    slider.classList.add('active');
//    startX = e.pageX || e.touches[0].pageX;  // Handle touch events as well
//    scrollLeft = slider.scrollLeft;
//});
//
//// Mouse leave event - Stop dragging when leaving the slider area
//slider.addEventListener('mouseleave', () => {
//    isDown = false;
//    slider.classList.remove('active');
//});
//
//// Mouse up event - Stop dragging
//slider.addEventListener('mouseup', () => {
//    isDown = false;
//    slider.classList.remove('active');
//});
//
//// Mouse move event - Handle the dragging movement
//slider.addEventListener('mousemove', (e) => {
//    if (!isDown) return;
//    e.preventDefault();
//    const x = e.pageX || e.touches[0].pageX; // Handle touch events as well
//    const walk = (x - startX) * 3; // Adjust scrolling speed
//    slider.scrollLeft = scrollLeft - walk;
//});
//
//// Optional: Support for touch events (for mobile devices)
//slider.addEventListener('touchstart', (e) => {
//    isDown = true;
//    startX = e.touches[0].pageX;
//    scrollLeft = slider.scrollLeft;
//});
//
//slider.addEventListener('touchend', () => {
//    isDown = false;
//});
//
//slider.addEventListener('touchmove', (e) => {
//    if (!isDown) return;
//    const x = e.touches[0].pageX;
//    const walk = (x - startX) * 3;
//    slider.scrollLeft = scrollLeft - walk;
//});



// scripts.js

// Get elements
const authModal = document.getElementById('authModal');
const loginToggle = document.getElementById('login-toggle');
const signupToggle = document.getElementById('signup-toggle');
const loginForm = document.getElementById('login-form');
const signupForm = document.getElementById('signup-form');
const switchToSignup = document.getElementById('switch-to-signup');
const switchToLogin = document.getElementById('switch-to-login');
const closeModal = document.querySelector('.close-btn');

// Function to open the modal
function openModal() {
    authModal.style.display = 'flex';
}

// Function to close the modal
function closeModalFunc() {
    authModal.style.display = 'none';
}

// Toggle forms
loginToggle.addEventListener('click', () => {
    loginForm.style.display = 'block';
    signupForm.style.display = 'none';
    loginToggle.classList.add('active');
    signupToggle.classList.remove('active');
});

signupToggle.addEventListener('click', () => {
    loginForm.style.display = 'none';
    signupForm.style.display = 'block';
    signupToggle.classList.add('active');
    loginToggle.classList.remove('active');
});

switchToSignup.addEventListener('click', (e) => {
    e.preventDefault();
    signupToggle.click();
});

switchToLogin.addEventListener('click', (e) => {
    e.preventDefault();
    loginToggle.click();
});

// Close modal on close button click
closeModal.addEventListener('click', closeModalFunc);

// Close modal when clicking outside of the modal content
window.addEventListener('click', (e) => {
    if (e.target === authModal) {
        closeModalFunc();
    }
});


