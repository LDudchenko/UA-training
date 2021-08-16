<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>
<#import "parts/pager.ftlh" as p>

<@c.page>
    <@p.pager url page />
    <table class="table">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col"><@spring.message "name"/></th>
          <th scope="col"><@spring.message "date.time"/></th>
          <th scope="col"><@spring.message "free.seats"/></th>
        </tr>
      </thead>
      <tbody>
        <#list page.content as screening>
            <tr>
              <th scope="row">
                <a href="${screening.film.id}/${screening.id}">${screening.id}</a>
              </th>
              <td>
                <#if lci==true>
                    ${screening.film.name_en}
                <#else>
                    ${screening.film.name}
                </#if>
               </td>
              <td> ${screening.screeningDateTime.toLocalDate()} ${screening.screeningDateTime.toLocalTime()}</td>
              <td> ${screening.numOfFreeSeats()}</td>
            </tr>
         </#list>
      </tbody>
    </table>
</@c.page>