<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>

<@c.page>
<div class="row">
    <div class="col-md-3"></div>
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default" style="margin-top:45px">
                <div class="panel-heading">
                    <h3 class="panel-title"><@spring.message "user.editor"/></h3>
                </div>
                <div class="panel-body">
                    <form action="/user" method="post">
                        <div class="form-group mb-2">
                            <label for="name"><@spring.message "username"/></label>
                            <input type="text" class="form-control" name="username" value="${user.username}">
                        </div>
                       <#list roles as role>
                           <div>
                               <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
                           </div>
                       </#list>
                       <input type="hidden" value="${user.id}" name="userId">
                       <input type="hidden" value="${_csrf.token}" name="_csrf">
                        <button type="submit" class="btn btn-primary"><@spring.message "save"/></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@c.page>