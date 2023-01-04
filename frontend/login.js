function login() {
    var settings = {
        "url": 'http://localhost:8081/api/users/login-check/',
        "method": "POST",
        "timeout": 0,
        "headers": {
          "Content-Type": "application/json"
        },
        "data": JSON.stringify({
          "username": document.getElementById('username').value,
          "password": document.getElementById('password').value
        }),
      };
      
      $.ajax(settings).done(function (response) {
        if(response) {
            window.location.replace('react/data.html');
        }
      });
}

document.getElementsByClassName('login-btn')[0]
    .addEventListener("click", login);

//"http://localhost:8081/api/users/login-check/"