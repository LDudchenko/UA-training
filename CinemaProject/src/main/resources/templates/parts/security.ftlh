<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        id=user.getId()
        isAdmin = user.isAdmin()
        isAuthorization=true
    >
<#else>
    <#assign
        name="unknown"
        isAdmin = false
        isAuthorization=false
    >
</#if>

