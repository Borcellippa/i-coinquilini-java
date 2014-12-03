function sendHTMLRequest(path, method, action, param1, param2) {
    method = method || "post"; // Set method to post by default if not specified.

    // The rest of this code assumes you are not using a library.
    // It can be made less wordy if you use one.
    var form = document.createElement("form");
    form.setAttribute("method", method);
    form.setAttribute("action", path);


    var hiddenField1 = document.createElement("input");
    hiddenField1.setAttribute("type", "hidden");
    hiddenField1.setAttribute("name", "action");
    hiddenField1.setAttribute("value", action);

    var hiddenField2 = document.createElement("input");
    hiddenField2.setAttribute("type", "hidden");
    hiddenField2.setAttribute("name", "param1");
    hiddenField2.setAttribute("value", param1);


    form.appendChild(hiddenField1);
    form.appendChild(hiddenField2);

    document.body.appendChild(form);
    form.submit();
}

var gButtonClicked = false;

function gButtonClick() {
    gButtonClicked = true;
}

(function() {
    var po = document.createElement('script');
    po.type = 'text/javascript';
    po.async = true;
    po.src = 'https://apis.google.com/js/client:plusone.js';
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(po, s);
})();

function signinCallback(authResult) {
    if (gButtonClicked) {
        if (authResult['access_token']) {
            // Autorizzazione riuscita
            sendHTMLRequest("UserController", "post", "gLogin", authResult['access_token']);

        } else if (authResult['error']) {
            // Si è verificato un errore.
            // Possibili codici di errore:
            //   "access_denied" - L'utente ha negato l'accesso alla tua app
            //   "immediate_failed" - Impossibile eseguire l'accesso automatico dell'utente
            console.log('There was an error: ' + authResult['error']);
        }
    }
}