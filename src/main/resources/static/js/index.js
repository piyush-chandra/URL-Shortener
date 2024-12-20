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

// Terms of Service Modal
function openTermsModal() {
    document.getElementById('termsModal').style.display = 'block';
}

function closeTermsModal() {
    document.getElementById('termsModal').style.display = 'none';
}

// Privacy Policy Modal
function openPrivacyModal() {
    document.getElementById('privacyModal').style.display = 'block';
}

function closePrivacyModal() {
    document.getElementById('privacyModal').style.display = 'none';
}

// Close modals when clicking outside
window.onclick = function(event) {
    if (event.target == document.getElementById('termsModal')) {
        closeTermsModal();
    }
    if (event.target == document.getElementById('privacyModal')) {
        closePrivacyModal();
    }
}


function shortenUrl() {
    const longUrl = document.getElementById('longUrl').value;
    if (!longUrl) {
        alert('Please enter a URL');
        return;
    }

    // Check if the URL is valid
    // const urlPattern = /^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/;
    // if (!urlPattern.test(longUrl)) {
    //     alert('Please enter a valid URL');
    //     return;
    // }

    fetch('/shortUrl', {
        method: 'POST',
        headers: {
            'Content-Type': 'text/plain',
        },
        body: longUrl
    })
        .then(response => {
            console.log("reponse from backend :: " + response);
            console.log("reponse from backend :: " + response.text);
            return response.text()
        })
        .then(data => {
            console.log('Shortened URL:', data);
            openShortenedUrlModal();
            document.getElementById('shortenedUrlResult').value = data;
            console.log(document.getElementById('shortenedUrlResult'));
        })
    .catch(error => {
        console.error('Error:', error);
        if (error instanceof Response) {
            error.text().then(errorMessage => {
                alert('An error occurred while shortening the URL: ' + errorMessage);
            });
        } else {
            alert('An error occurred while shortening the URL: ' + error.message);
        }
    });
}

function openShortenedUrlModal() {
    document.getElementById('shortenedUrlModal').style.display = 'block';
}

function closeShortenedUrlModal() {
    document.getElementById('shortenedUrlModal').style.display = 'none';
}

function copyToClipboard() {
    var copyText = document.getElementById("shortenedUrlResult");
    copyText.select();
    copyText.setSelectionRange(0, 99999);
    document.execCommand("copy");
}