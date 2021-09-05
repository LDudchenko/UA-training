<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring>

<@c.page>
<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default" style="margin-top:45px">
                <div class="panel-heading">
                    <h3 class="panel-title"><@spring.message "registration.message"/></h3>
                </div>
                <div class="panel-body">

                    <form action="/registration" method="post">
                        <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                        <div class="form-group">
                            <label for="username"><@spring.message "username"/></label>
                            <input type="text" class="form-control ${(usernameError??)?string('is-invalid','')}" id="username" placeholder=<@spring.message "username"/>  min="2" max="20" name="username" required value="<#if user??>${user.username}</#if>">
                            <#if usernameError??>
                                <div class="invalid-feedback">
                                    ${usernameError}
                                </div>
                            </#if>
                        </div>
                        <div class="form-group mb-2">
                            <label for="password"><@spring.message "password"/></label>
                            <input type="password" class="form-control ${(passwordError??)?string('is-invalid','')}" id="password" placeholder=<@spring.message "password"/> min="8" max="30" name="password" required>
                            <#if passwordError??>
                                <div class="invalid-feedback">
                                    ${passwordError}
                                </div>
                            </#if>
                        </div>
                        <button type="submit" class="btn btn-primary"><@spring.message "registration"/></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</@c.page>