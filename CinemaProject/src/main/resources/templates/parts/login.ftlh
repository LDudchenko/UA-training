<#import "/spring.ftl" as spring>
<#macro login path isRegisterForm logout error>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default" style="margin-top:45px">
                <div class="panel-heading">
                    <h3 class="panel-title"><@spring.message "login.message"/></h3>
                </div>
                <div class="panel-body">
                     <#if logout>
                        <div class="alert alert-info" role="alert"><@spring.message "logout"/></div>
                     </#if>
                     <#if error>
                        <div class="alert alert-danger" role="alert"><@spring.message "error"/></div>
                     </#if>

                    <form action="${path}" method="post">
                        <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                        <div class="form-group">
                            <label for="username"><@spring.message "username"/></label>
                            <input type="text" class="form-control" id="username" placeholder=<@spring.message "username"/>
                                   name="username">
                        </div>
                        <div class="form-group">
                            <label for="password"><@spring.message "password"/></label>
                            <input type="password" class="form-control" id="password" placeholder=<@spring.message "password"/>
                                   name="password">
                        </div>
                        <button type="submit" class="btn btn-primary"><@spring.message "login"/></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</#macro>

<#macro logout>
      <form action="/logout" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button class="btn btn-primary">Sign Out</button>
      </form>
</#macro>

<#macro oldLogin>
    <form action="${path}" method="post">
      <div><label> User Name : <input type="text" name="username"/> </label></div>
      <div><label> Password: <input type="password" name="password"/> </label></div>
      <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div><input type="submit" value="Sign In"/><a href="main"></a></div>
        <#if isRegisterForm><a href="/registration">Sign up</a></#if>
    </form>
</#macro>