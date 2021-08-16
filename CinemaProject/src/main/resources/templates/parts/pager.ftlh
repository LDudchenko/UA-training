<#import "/spring.ftl" as spring>

<#macro pager url page>
    <div>
         <ul class="pagination">
            <li class="page-item disabled">
              <a class="page-link" href="#" tabindex="-1"><@spring.message "pages"/></a>
            </li>
            <#list 1..page.getTotalPages() as p>
                <#if (p-1)==page.getNumber()>
                    <li class="page-item active">
                      <a href="#" class="page-link" tabindex="-1">${p}</a>
                    </li>
                <#else>
                    <li class="page-item">
                        <a href="${url}?page=${p-1}&size=${page.getSize()}&sort=${sort}" class="page-link" tabindex="-1">${p}</a>
                    </li>
                </#if>
            </#list>
         </ul>
         <ul class="pagination">
            <li class="page-item disabled">
              <a class="page-link" href="#" tabindex="-1"><@spring.message "elements.on.page"/></a>
            </li>
            <#list [1,2,5,10] as c>
                <#if c==page.getSize()>
                    <li class="page-item active">
                      <a href="#" class="page-link" tabindex="-1">${c}</a>
                    </li>
                <#else>
                    <li class="page-item">
                        <a href="${url}?page=${page.getNumber()}&size=${c}&sort=${sort}" class="page-link" tabindex="-1">${c}</a>
                    </li>
                </#if>
            </#list>
         </ul>
         <ul class="pagination">
            <li class="page-item disabled">
              <a class="page-link" href="#" tabindex="-1"><@spring.message "sort"/></a>
            </li>
            <#list ["film.name", "numOfFreeSeats","screeningDateTime"] as c>
                <#if c==sort>
                    <li class="page-item active">
                      <a href="#" class="page-link" tabindex="-1"><@spring.message "${c}"/></a>
                    </li>
                <#else>
                    <li class="page-item">
                        <a href="${url}?page=${page.getNumber()}&size=${page.getSize()}&sort=${c}" class="page-link" tabindex="-1"><@spring.message "${c}"/></a>
                    </li>
                </#if>
            </#list>
         </ul>
    </div>
</#macro>