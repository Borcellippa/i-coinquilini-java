<%@include  file="topTemplateFree.jsp" %>
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
                <img src="images/lock.png" style="height: 100px; margin-top: 31px; margin-left: 11px">
            </div>
            <div id="rightPasswordDiv">
                <form method="POST" action="UserController" role="form" style="margin-left: 20px;">
                    <div class="content">
                        <div>
                            <label class="labelForm">Password</label>
                            <input type="password" name="password" required class="form-control inputForm">
                        </div>
                        <div style="margin-top: 15px;">
                            <label  class="labelForm">Conferma Password</label>
                            <input type="password" name="passwordConf" required class="form-control inputForm">
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