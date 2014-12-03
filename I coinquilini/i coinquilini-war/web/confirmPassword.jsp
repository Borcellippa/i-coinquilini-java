<div id="social-wizard" data-modules="workflow/social-wizard">
    <header>
      <h1>Let's talk authentication</h1>
    </header>
    <div class="wizard-content">
      <p>
        
        
          Even though you have signed up via Google, we still need a secure way for you to push and pull code. You can choose one <strong>or</strong> both of the following:
        
        
      </p>
      
        <section id="account-ssh-key">
          <div class="content">
            <button class="aui-button" id="set-ssh-key">Set an SSH key</button>
            <a href="#" id="ssh-key-help-trigger" class="wizard-help-link">What is an SSH key?</a>
          </div>
          <div class="completed-content">
            <h2>SSH key successfully added</h2>
          </div>
          <form id="add-ssh-key-form" class="aui" action="#" method="POST">
            <div class="error aui-message hidden">
              <span class="aui-icon icon-error"></span>
              <div class="message"></div>
            </div>
            <input type='hidden' name='csrfmiddlewaretoken' value='I8ijn1ngHDlTqFRzrEfQVi0ot8M5bZBS' />
            


  
    <div id="id_label_group" class="field-group ">
        <label for="id_label">
          Label
        </label>
        
          <input class=" text" id="id_label" maxlength="255" name="label" type="text" />
        
      
      
        
      
    </div>
  


            


  
    <div id="id_key_group" class="field-group ">
        <label for="id_key">
          Key<span class="aui-icon icon-required"></span><span class="content">required</span>
        </label>
        
          <textarea class=" textarea" cols="40" columns="40" id="id_key" name="key" placeholder="Paste your key here..." rows="8">
</textarea>
        
      
        <div class="description">
          
            For security reasons the content of an SSH key cannot be modified once added.
          
        </div>
      
      
        
      
    </div>
  


            <div class="assistive">
              <button type="submit">Save</button>
            </div>
            

<p class="field-group">
  <strong class="heading">Already have a key?</strong>
  
    Copy <a href="https://confluence.atlassian.com/x/YwV9E" target="_blank">your key</a> to your clipboard
  
  <span class="ssh-key-copy-help mac">with: <code>cat ~/.ssh/id_rsa.pub | pbcopy</code></span>
  <span class="ssh-key-copy-help linux">with: <code>xclip -sel clip &lt; ~/.ssh/id_rsa.pub</code></span>
</p>
<p class="field-group" id="ssh_error_help">
  <strong class="heading">Problems adding a key?</strong>
  
    Read our <a href="https://confluence.atlassian.com/x/2YJnJ" target="_blank">knowledge base</a> for common issues.
  
</p>
          </form>
        </section>
      
      <section id="account-password"
               >
        <div class="content">
          <button class="aui-button" id="set-password">Set a password</button>
          <a href="#" id="password-help-trigger" class="wizard-help-link">Why do I need a password?</a>
        </div>
        <div class="completed-content">
          <h2>Password successfully set</h2>
        </div>
        <form id="choose-password-form" class="aui" action="/account/password/change/gianluca_bortignon/" method="POST">
          <div class="error aui-message hidden">
            <span class="aui-icon icon-error"></span>
            <div class="message"></div>
          </div>
          <input type='hidden' name='csrfmiddlewaretoken' value='I8ijn1ngHDlTqFRzrEfQVi0ot8M5bZBS' />
          


  
    <div id="id_new_password1_group" class="field-group ">
        <label for="id_new_password1">
          New password<span class="aui-icon icon-required"></span><span class="content">required</span>
        </label>
        
          <input class=" text" id="id_new_password1" name="new_password1" type="password" />
        
      
      
        
      
    </div>
  


          


  
    <div id="id_new_password2_group" class="field-group ">
        <label for="id_new_password2">
          Confirm password<span class="aui-icon icon-required"></span><span class="content">required</span>
        </label>
        
          <input class=" text" id="id_new_password2" name="new_password2" type="password" />
        
      
      
        
      
    </div>
  


          <div class="assistive">
            <button type="submit">Save</button>
          </div>
        </form>
      </section>
      <div id="ssh-key-help">
        <h2>Always be authenticated</h2>
        <p>SSH keys allow you to never have to type your password again. Your computer becomes permanently trusted by our server with the exchange of a public/private key pair.</p>
        <p>It sounds complicated (and it is), but we will help you set it up in about five minutes.</p>
      </div>
      <div id="password-help">
        <h2>Who are you again?</h2>
        <p>
          
          When you talk with Bitbucket over HTTPS using the command line, we have no way of verifying your identity via Google. Give us a <strong>password</strong> and <strong>email address</strong> so we can match you up.
          
        </p>
        <p>We recommend that you use an SSH key to skip the hassle, if possible.</p>
      </div>
      
        <a href="/">Do this later</a>
      
    </div>
  </div>
  

    </div>
  </div>