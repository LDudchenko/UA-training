<#include "security.ftlh">
<#import "login.ftlh" as l>
<#import "/spring.ftl" as spring>


<header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
      <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
        <svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px"
        width="48" height="48"
        viewBox="0 0 172 172"
        style=" fill:#000000;"><g fill="none" fill-rule="nonzero" stroke="none" stroke-width="1" stroke-linecap="butt" stroke-linejoin="miter" stroke-miterlimit="10" stroke-dasharray="" stroke-dashoffset="0" font-family="none" font-weight="none" font-size="none" text-anchor="none" style="mix-blend-mode: normal"><path d="M0,172v-172h172v172z" fill="none"></path><g fill="#ff0c0c"><path d="M146.91667,94.95833c0,32.60833 -26.51667,59.125 -59.125,59.125c-8.6,0 -16.48333,-1.79167 -23.65,-5.01667l4.65833,-9.675c5.73333,2.50833 12.54167,3.94167 19.35,3.94167c26.15833,0 48.01667,-21.85833 48.01667,-48.375c0,-15.05 -7.16667,-28.66667 -17.91667,-37.625v39.775l-17.91667,-17.91667v-25.44167l-20.06667,43h20.06667v-7.16667l17.91667,17.91667l-17.91667,14.33333v-7.16667h-28.30833l-18.275,39.41667h-21.5l53.75,-107.5c-25.8,1.075 -46.58333,22.21667 -46.58333,48.375c0,7.16667 1.43333,13.975 4.3,20.06667l-5.73333,11.825c-5.73333,-9.31667 -9.31667,-20.06667 -9.31667,-31.89167c0,-32.60833 26.51667,-59.125 59.125,-59.125c1.075,0 2.50833,0 3.58333,0l8.95833,-17.91667h17.91667v26.51667c17.2,10.39167 28.66667,29.025 28.66667,50.525zM102.84167,129h15.40833v-12.18333z"></path></g></g></svg>
        <span class="fs-4">MARVEL Cinema</span>
      </a>

      <ul class="nav nav-pills">
        <#if isAuthorization>
            <li class="nav-item navbar-text"><a href="/${id}">${name}</a></li>
        </#if>
        <#if isAdmin>
            <li class="nav-item">
                <div class="dropdown">
                  <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <@spring.message "admin.panel"/>
                  </button>
                  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="/films"><@spring.message "film.list"/></a>
                    <a class="dropdown-item" href="/halls"><@spring.message "hall.list"/></a>
                    <a class="dropdown-item" href="/screenings"><@spring.message "screening.list"/></a>
                    <a class="dropdown-item" href="/user"><@spring.message "user.list"/></a>
                  </div>
                </div>
            </li>
        </#if>
        <li class="nav-item nav-link"><a href="/?lang=en">EN</a>/<a href="/?lang=ru">UA</a></li>
        <#if isAuthorization>
            <@l.logout />
        <#else>
            <form action="/login">
                <button type="submit" class="btn btn-outline-primary me-2"><@spring.message "login"/></button>
            </form>
            <form action="/registration">
                <button type="submit" class="btn btn-primary"><@spring.message "registration"/></button>
            </form>
        </#if>
      </ul>
    </header>