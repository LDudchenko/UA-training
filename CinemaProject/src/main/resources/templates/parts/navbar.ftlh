<#include "security.ftlh">


<header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
      <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
        <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
        <span class="fs-4">MARVEL Cinema</span>
      </a>

      <ul class="nav nav-pills">
        <li class="nav-item navbar-text">${name}</li>
        <#if isAdmin>
            <li class="nav-item"> <a class="nav-link" href="/user">User list</a></li>
        </#if>
        <li class="nav-item nav-link"><a href="/?lang=en">EN</a>/<a href="/?lang=ru">UA</a></li>
        <form action="/login">
            <button type="submit" class="btn btn-outline-primary me-2">Login</button>
        </form>
        <form action="/registration">
            <button type="submit" class="btn btn-primary">Sign-up</button>
        </form>
      </ul>
    </header>