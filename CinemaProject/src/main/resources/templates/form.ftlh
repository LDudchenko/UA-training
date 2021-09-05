<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<#import "/spring.ftl" as spring>

<@c.page>
    <@spring.message "film"/>:${screening.film.name}<br/>
    <@spring.message "date.time"/>: ${screening.screeningDateTime};<br/>
    <@spring.message "row"/>: ${r};<br/>
    <@spring.message "seat"/>: ${s};<br/>
    <a href="${s}/${id}/buy"> <@spring.message "buy"/></a>
</@c.page>

