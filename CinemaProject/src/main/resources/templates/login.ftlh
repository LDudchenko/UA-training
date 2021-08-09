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
                    <h3 class="panel-title"><@spring.message "login.message"/></h3>
                </div>
                <div class="panel-body">
                     <#if logout>
                        <div class="alert alert-info" role="alert"><@spring.message "logout"/></div>
                     </#if>
                     <#if error>
                        <div class="alert alert-danger" role="alert"><@spring.message "error"/></div>
                     </#if>

                    <form action="/login" method="post">
                        <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                        <div class="form-group">
                            <label for="username"><@spring.message "username"/></label>
                            <input type="text" class="form-control" id="username" placeholder=<@spring.message "username"/>
                                   name="username">
                        </div>
                        <div class="form-group mb-2">
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
</@c.page>