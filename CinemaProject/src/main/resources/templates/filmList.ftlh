<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>

<@c.page>
      <h1> <@spring.message "film.list"/></h1>
      <div class="wrapper">
                <#list films as film>
                    <div class="item">
                        <p>${film.name}/${film.name_en}</p>
                        <p>${film.description}</p>
                        <p>${film.description_en}</p>
                        <#if film.filename??>
                                <img src="/img/${film.filename}">
                        </#if>
                        <a href="/films/${film.id}" class="btn-ref"><@spring.message "edit"/></a>
                    </div>
                </#list>
      </div>
        <a href="/films/add" class="btn-ref red"><@spring.message "add"/></a>
</@c.page>