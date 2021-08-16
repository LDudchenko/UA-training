<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>

<@c.page>
      <h1><@spring.message "attendance"/></h1>
      <label class="label"><@spring.message "name"/>: </label>
      <#if lci==true>
        ${screening.film.name_en}
      <#else>
        ${screening.film.name}
      </#if>
      <br/>
      <label class="label"><@spring.message "hall"/>: </label>${screening.hall.name}<br/>
      <label class="label"><@spring.message "date.time"/>: </label>${screening.screeningDateTime}<br/>
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
                             ${s}
                          </div>
                      </#if>
                  </#list>
              </div>
          </#list>
</@c.page>