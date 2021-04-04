
/**
 * Stores data extracted from the JWT
 *
 * @param data JWT to be parsed
 */
 function storeJWT(data) {
    //var token = result.accessToken;
    console.log(data["accessToken"]);

    //Save these fields as cookies
    Cookies.set('accessToken', data["accessToken"], {expires: 1, path: '/', sameSite: 'lax'});
    Cookies.set('username', data["username"], {expires: 1, path: '/', sameSite: 'lax'});

    var token = data["accessToken"];
    var tokenType = data["tokenType"];
    var userEmail = data["email"];
    let username = data["username"];

    //Save these fields as local storage
    localStorage.setItem('token', token);
    localStorage.setItem('AuthorizationHeader', tokenType + " " + token);
    localStorage.setItem('username', username);
    localStorage.setItem('userEmail', userEmail);
}


function displayError(text) {

    // remove old error if exists
    var preexisting = document.getElementById("errorMessage");
    // use existing or create new if false truthiness
    var errorMessageNode = preexisting ? preexisting : document.createElement("div");
    // clear just in case
    errorMessageNode.innerHTML = "";
    // and setup w/ provided error text
    errorMessageNode.id = "errorMessage";
    errorMessageNode.style.backgroundColor = "#f8f8f8";
    errorMessageNode.style.opacity = 0.75;
    var errorTextNode = document.createElement("h3");
    errorTextNode.innerText = text;
    errorTextNode.style.color = "red";
    errorMessageNode.appendChild(errorTextNode);

    // place after signin button
    var placementReference = document.querySelector('#signInButton');
    placementReference.after(errorMessageNode);
}


function checkAlreadyLoggedIn() {
    var authHeaderValue = localStorage.getItem('AuthorizationHeader');
    
    // if there isn't even a possible auth value, then skip the check
    if (!authHeaderValue) {
        return;
    }

    // check if valid auth value
    $.ajax({
        url: "/api/auth/current/username",
        type: "GET",
        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', authHeaderValue);
        },
        success: function (result) {
            console.log("Already valid auth header, skipping login");
            location.href = "/dashboard";
        },
        error: function (xhr, resp, text) {
            console.log(xhr, resp, text);
        }
    })
}
checkAlreadyLoggedIn();

// define signin handler
function performSignIn() {
    var signInPayload = {
        "username": document.getElementById('signInInputUsername').value,
        "password": document.getElementById('signInInputPassword').value
    };

    $.ajax({
        url: '/api/auth/signin',
        type: "POST",
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(signInPayload),
        success: function (result) {
            console.log("Successfully performed login!");
            console.log(result);
            storeJWT(result);
            location.href = "/dashboard";
        },
        error: function (xhr, resp, text) {
            console.log(xhr, resp, text);
            displayError("Unable to login -- check username/password!");
        }
    })
}

// register on-click handler
var signInButton = document.getElementById('signInButton');
signInButton.onclick = performSignIn


