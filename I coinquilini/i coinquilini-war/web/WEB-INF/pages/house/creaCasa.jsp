<%-- 
    Document   : creaCasa
    Created on : 10-dic-2014, 11.44.50
    Author     : Mattia
--%>


<%@include  file="../templates/topTemplateFree.jsp" %>

<div id="social-wizard">
    <header>
        <h1>Crea Casa</h1>
    </header>

    <div class="wizard-content" id="formRegistrazione"> 
        <form method="POST" action="CasaController" role="form">
            <div class="form-group">
                <label for="nome">Dai un nome alla tua casa</label>
                <input type="text" name="nome" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="indirizzo">Indirizzo</label>
                <input type="text" name="indirizzo" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="civico">Num. Civico</label>
                <input type="text" name="civico" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="citta">Città</label>
                <input type="text" name="citta" class="form-control" required>
            </div>
            <div id="password" class="form-group">
                <label for="postiTotali">Posti Totali</label>
                <input type="number" name="postiTotali" class="form-control" required>
            </div>
            <div class="form-group" style="text-align: center">
                <button type="submit" class="btn btn-lg custom-button">Crea la tua Casa</button>
            </div>
            <input type="hidden" name="action" value="addCasa">
        </form>
    </div>
</div>
<%@include  file="../templates/botTemplateFree.jsp" %>
