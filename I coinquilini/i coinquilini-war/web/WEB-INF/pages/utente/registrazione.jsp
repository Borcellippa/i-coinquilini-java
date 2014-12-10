<%@include  file="../templates/topTemplateFree.jsp" %>
<script src="js/validatePwd.js" type="text/javascript"></script>

<div id="social-wizard">
    <header>
        <h1>Registrazione</h1>
    </header>
    <div class="wizard-content" id="formRegistrazione"> 
        <form method="POST" action="UserController" role="form" onsubmit="return checkForm(this);">
            <div class="form-group">
                <label>Nome</label>
                <input type="text" name="nome" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="cognome">Cognome</label>
                <input type="text" name="cognome" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" name="email" class="form-control" required>
            </div>
            <div id="password" class="form-group">
                <label for="password">Password</label>
                <input type="password" name="password" class="form-control" required onfocus="removeError()">
            </div>
            <div id="passwordConf" class="form-group">
                <label for="passwordConf">Conferma Password</label>
                <input type="password" name="passwordConf" class="form-control" required onfocus="removeError()">            
            </div>      
            <div class="uk-hidden" id="testPwd" style="text-align: center; margin-bottom: 10px;">
                <span class="label label-danger"  style="text-align: center;">Le password inserite non coincidono</span>
            </div>
            <div class="form-group">
                <label for="password">Genere</label>
                <div class="radio" style="display: inline">
                    <label>
                        <input type="radio" name="genere" id="male" value="male" checked>
                        Uomo
                    </label>&nbsp&nbsp&nbsp&nbsp&nbsp
                    <label>
                        <input type="radio" name="genere" id="female" value="female">
                        Donna
                    </label>
                </div>
            </div>
            <div class="form-group">
                <label for="telefono">Telefono</label>
                <input type="text" name="telefono" class="form-control" pattern="[0-9]*">
            </div>
            <div class="form-group">
                <label for="nazionalita">Nazionalità</label>
                <input type="text" name="nazionalita" class="form-control">
            </div>
            <div class="form-group">
                <label for="data_nascita">Data di Nascita</label>
                <input name="data_nascita" class="form-control" placeholder="gg/mm/aaaa" data-provide="datepicker" data-date-format="dd/mm/yyyy" data-date-autoclose="true" required>
            </div>
            <div class="form-group">
                <label for="citta_natale">Città natale</label>
                <input type="text" name="citta_natale" class="form-control">
            </div>
            <div class="form-group" style="text-align: center">
                <button type="submit" class="btn btn-lg custom-button">Registrati</button>
            </div>

            <input type="hidden" name="action" value="addUtente">
        </form>
    </div>
</div>
<%@include  file="../templates/botTemplateFree.jsp" %>