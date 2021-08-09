<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>

<@c.page>
    <div class="filmInfo">
        <h2>${film.name}</h2>
        <img src="/img/${film.filename}">
        <p class="note">
            <@spring.message "date.time"/>: ${screening.screeningDateTime}<br/>
            <@spring.message "hall"/>: ${screening.hall.name}<br/>
        </p>
        <p>
            ${film.description}
        </p>
    </div>
</@c.page>