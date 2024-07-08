document.getElementById('diagnosis-form').addEventListener('submit', function (e) {
    e.preventDefault();
    const symptoms = document.getElementById('symptoms').value;
    fetchDiagnosis(symptoms);
});

function fetchDiagnosis(symptoms) {
    fetch('http://localhost:5000/api/diagnose', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ symptoms: symptoms })
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('diagnosis-result').innerText = data.diagnosis;
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('diagnosis-result').innerText = 'An error occurred. Please try again later.';
    });
}

// Add event listeners for login and registration forms
document.getElementById('login-form').addEventListener('submit', function (e) {
    e.preventDefault();
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    loginUser(email, password);
});

function loginUser(email, password) {
    fetch('http://localhost:5000/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email: email, password: password })
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('login-result').innerText = data.message;
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('login-result').innerText = 'An error occurred. Please try again later.';
    });
}

document.getElementById('register-form').addEventListener('submit', function (e) {
    e.preventDefault();
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    registerUser(name, email, password);
});

function registerUser(name, email, password) {
    fetch('http://localhost:5000/api/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ name: name, email: email, password: password })
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('register-result').innerText = data.message;
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('register-result').innerText = 'An error occurred. Please try again later.';
    });
}








