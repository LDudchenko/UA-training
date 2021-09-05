<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>
<#include "parts/security.ftlh">


<@c.page>
        <#if message??>
            <div class="alert alert-danger" role="alert">
                ${message}
            </div>
        </#if>
        <form action="/topUpAnAccount" method="post">
            <input type="text" name="money">
            <input type="hidden" name="user" value="${user.id}">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit">add</button>
        </form>
        Balance: ${user.account}
<table class="table">
      <thead>
        <tr>
          <th scope="col"><@spring.message "name"/></th>
          <th scope="col"><@spring.message "date.time"/></th>
          <th scope="col"><@spring.message "seat"/></th>
          <th scope="col"><@spring.message "row"/></th>
        </tr>
      </thead>
      <tbody>
        <#list tickets as ticket>
            <tr>
              <td>
                <#if lci==true>
                    ${ticket.screening.film.name_en}
                <#else>
                    ${ticket.screening.film.name}
                </#if>
              </td>
              <td>${ticket.screening.screeningDateTime.toLocalDate()} ${ticket.screening.screeningDateTime.toLocalTime()}</td>
              <td> ${ticket.seat}</td>
              <td> ${ticket.numberOfrow}</td>
            </tr>
         <#else>
            <@spring.message "no.tickets"/>
         </#list>
      </tbody>
    </table>
</@c.page>