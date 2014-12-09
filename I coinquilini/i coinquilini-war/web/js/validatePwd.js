function checkForm(form)
{
    if (form.password.value != form.passwordConf.value) {
        $("#testPwd").removeClass("uk-hidden");
        $("#password").addClass("has-error");
        $("#passwordConf").addClass("has-error");
        form.password.value = "";
        form.passwordConf.value = "";
        return false;
    }
    return true;
}

function removeError() {
    $("#password").removeClass("has-error");
    $("#passwordConf").removeClass("has-error");
    $("#testPwd").addClass("uk-hidden");



}