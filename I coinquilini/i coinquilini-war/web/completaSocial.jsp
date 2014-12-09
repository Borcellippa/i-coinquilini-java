<%@include  file="topTemplateFree.jsp" %>
<script src="js/validatePwd.js" type="text/javascript"></script>

<div id="social-wizard">
    <header>
        <h1>Ci siamo quasi...</h1>
    </header>
    <div class="wizard-content">
        <p>
            Hai effettuato con successo la registrazione attraverso il social network.
            Per permetterti un accesso facile e sicuro in futuro ti chiediamo di impostare una password:
        </p>

        <section id="account-password">
            <div id="leftPasswordDiv">
                <img src="images/lock.png" style="height: 100px; margin-top: 45px; margin-left: 11px">
            </div>
            <div id="rightPasswordDiv">
                <form method="POST" action="UserController" role="form" style="margin-left: 20px;" onsubmit="return checkForm(this);">
                    <div class="content">
                        <div>
                            <label class="labelForm">Password</label>
                            <input id="password" type="password" name="password" required class="form-control inputForm" onfocus="removeError()">
                        </div>
                        <div style="margin-top: 15px;">
                            <label  class="labelForm">Conferma Password</label>
                            <input id="passwordConf" type="password" name="passwordConf" required class="form-control inputForm" onfocus="removeError()">
                        </div>
                        <div class="uk-hidden" id="testPwd" style="text-align: center;">
                            <span class="label label-danger"  style="text-align: center;">Le password inserite non coincidono</span>
                        </div>
                    </div>
                    <div class="form-group"  style="margin-top: 15px;text-align: center">
                        <button type="submit" class="btn btn-lg custom-button">Salva</button>
                    </div>
                    <input type="hidden" name="action" value="completaSocial">
                </form>
            </div>
        </section>
    </div>
</div>
<%@include  file="botTemplateSideMenu.jsp" %>
