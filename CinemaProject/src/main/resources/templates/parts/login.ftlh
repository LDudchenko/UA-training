<#macro login path isRegisterForm>
<form action="${path}" method="post">
  <div><label> User Name : <input type="text" name="username"/> </label></div>
  <div><label> Password: <input type="password" name="password"/> </label></div>
  <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div><input type="submit" value="Sign In"/><a href="main"></a></div>
    <#if isRegisterForm><a href="/registration">Sign up</a></#if>
</form>
</#macro>

<#macro logout>
      <form action="/logout" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button class="btn btn-primary">Sign Out</button>
      </form>
</#macro>