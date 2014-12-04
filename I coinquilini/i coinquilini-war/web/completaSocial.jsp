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
                <img src="images/lock.png">
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
                            <input type="passwordConf" name="passwordConf" required class="form-control inputForm">
                        </div>
                    </div>
                    <div class="form-group"  style="margin-top: 15px;">
                        <button type="submit" class="btn btn-default">Salva</button>
                    </div>
                    <input type="hidden" name="action" value="completeSocial">
                </form>
            </div>
        </section>
    </div>
</div>
<%@include  file="botTemplateSideMenu.jsp" %>