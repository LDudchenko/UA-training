<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>

<@c.page>
    <h1><@spring.message "user.list"/></h1>
    <table class="table">
          <thead>
            <tr>
                <th><@spring.message "name"/></th>
                <th><@spring.message "role"/></th>
                <th></th>
            </tr>
          </thead>
          <tbody>
            <#list users as user>
                <tr>
                    <td>${user.username}</td>
                    <td><#list user.roles as role>${role}<#sep>, </#list></td>
                    <td><a href="/user/${user.id}">edit</td>
                </tr>
             </#list>
          </tbody>
        </table>
</@c.page>