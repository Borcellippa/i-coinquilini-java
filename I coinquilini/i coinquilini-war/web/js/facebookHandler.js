var userData;

function sendFacebookRequest(path, method, action, userData) {
    method = method || "post"; // Set method to post by default if not specified.

    // The rest of this code assumes you are not using a library.
    // It can be made less wordy if you use one.
    var form = document.createElement("form");
    form.setAttribute("method", method);
    form.setAttribute("action", path);


    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "action");
    hiddenField.setAttribute("value", action);

    form.appendChild(hiddenField);

    var hiddenField2 = document.createElement("input");
    hiddenField2.setAttribute("type", "hidden");
    hiddenField2.setAttribute("name", "userData");
    hiddenField2.setAttribute("value", userData);

    form.appendChild(hiddenField2);

    document.body.appendChild(form);
    form.submit();
}


// This is called with the results from from FB.getLoginStatus().
function statusChangeCallback(response) {
    accessToken = response.authResponse.accessToken;
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === "connected") {
        FB.api('/me/picture', function(pictureResponse) {
            FB.api('/me', function(response) {
                userData = response;
                userData['accessToken'] = accessToken;
                userData['urlImmagine'] = pictureResponse.data.url;
                sendFacebookRequest("UserController", "post", "loginFacebook", JSON.stringify(userData));
            });
        });
    }
}

// Funzione chiamata quando si fa il sign-up con facebook
function checkLoginState() {
    FB.getLoginStatus(function(response) {
        statusChangeCallback(response);
    });
}

// CARICO API FACEBOOK
window.fbAsyncInit = function() {
    FB.init({
        appId: '1524946494416253',
        cookie: true, // enable cookies to allow the server to access 
        // the session
        xfbml: true, // parse social plugins on this page
        version: 'v2.2' // use version 2.2
    });

    FB.getLoginStatus(function(response) {
        if (response.status === 'connected') {
            console.log(response.authResponse.accessToken);
            //$().redirect('/UserController');
        }
    });
};

// Load the SDK asynchronously
(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id))
        return;
    js = d.createElement(s);
    js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

function fb_login() {
    FB.login(function() {
        checkLoginState();
    }, {scope: 'email,public_profile'});
}