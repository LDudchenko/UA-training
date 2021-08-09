<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>

<@c.page>
    <h1><@spring.message "schedule"/></h1>
    <div class="wrapper">
        <#list screenings as screening>
            <div class="item">
            <a href="${screening.film.id}/${screening.id}">
                    <h2>${screening.film.name}</h2>
            </a>
                 <img src="/img/${screening.film.filename}">
                 <p class="note"><@spring.message "date.time"/>: ${screening.screeningDateTime}</p>
            </div>
        </#list>
    </div>
</@c.page>