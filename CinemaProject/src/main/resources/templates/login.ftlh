<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring>


<@c.page>
<@spring.message "login"/>
<@l.login "/login" true logout error/>
</@c.page>