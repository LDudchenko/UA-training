<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>

<@c.page>
      <h1><@spring.message "hall.list"/></h1>
      <div class="row">
                <#list halls as hall>
                    <div class="col-3 hall" style="border: 2px solid #45637d;">
                        <label class="label"><@spring.message "name"/>: </label>${hall.name}<br/>
                        <label class="label"><@spring.message "numOfRows"/>: </label>${hall.numOfRows}<br/>
                        <label class="label"><@spring.message "numOfSeatsAtRow"/>: </label>${hall.numOfSeatsAtRow}<br/>
                        <a href="/halls/${hall.id}" class="btn-ref"><@spring.message "edit"/></a>
                    </div>
                </#list>
      </div>
        <a href="/halls/add" class="btn-ref red"><@spring.message "add"/></a>
</@c.page>