<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>

<@c.page>
      <h1><@spring.message "screening.list"/></h1>
      <div class="row">
                <#list screenings as screening>
                    <div class="col-4" style="border: 2px solid #45637d;">
                        <label class="label"><@spring.message "name"/>: </label>${screening.film.name}/${screening.film.name_en}<br/>
                        <label class="label"><@spring.message "hall"/>: </label>${screening.hall.name}<br/>
                        <label class="label"><@spring.message "date.time"/>: </label>${screening.screeningDateTime}<br/>
                        <a href="/screenings/${screening.id}" class="btn-ref"><@spring.message "edit"/></a>
                        <a href="/screenings/attendance/${screening.id}" class="btn-ref"><@spring.message "attendance"/></a>
                    </div>
                </#list>
      </div>
        <a href="/screenings/add" class="btn-ref red"><@spring.message "add"/></a>
</@c.page>