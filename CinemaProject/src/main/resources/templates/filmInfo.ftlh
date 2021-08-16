<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>

<@c.page>
    <div class="filmInfo">
        <h2>
            <#if lci==true>
                ${screening.film.name_en}
            <#else>
                ${screening.film.name}
            </#if>
        </h2>
        <p class="note">
            <@spring.message "date.time"/>: ${screening.screeningDateTime}<br/>
            <@spring.message "hall"/>: ${screening.hall.name}<br/>
        </p>
        <p>
            <#if lci==true>
                ${film.description_en}
            <#else>
                ${film.description}
            </#if>
        </p>
    </div>
    <#list 1..screening.hall.numOfRows as r>
        <div class="wrapper" style="display: flex;">
            <span>${r}&nbsp&nbsp</span>
            <#list 1..screening.hall.numOfSeatsAtRow as s>
                <#if screening.isBusySeat(r, s)>
                    <div class="seat" style="border: 1px solid black; width: 50px; height: 50px; margin: 1px; background: red;">
                        ${s}
                    </div>
                <#else>
                    <div class="seat" style="border: 1px solid black; width: 50px; height: 50px; margin: 1px;">
                       <a class="page-link" href="${screening.id}/${r}/${s}">${s}</a>
                    </div>
                </#if>
            </#list>
        </div>
    </#list>
</@c.page>