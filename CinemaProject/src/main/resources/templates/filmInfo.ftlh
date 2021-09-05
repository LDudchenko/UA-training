<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>
<#include "parts/security.ftlh">


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
            <@spring.message "price.of.ticket"/>: ${screening.priceOfTicket}<br/>
        </p>
        <p>
            <#if lci==true>
                ${film.description_en}
            <#else>
                ${film.description}
            </#if>
        </p>
    </div>
    <div class="row">
        <div class="col-8">
            <#list 1..screening.hall.numOfRows as r>
                <div class="wrapper" style="display: flex;">
                    <span>${r}&nbsp&nbsp</span>
                    <#list 1..screening.hall.numOfSeatsAtRow as s>
                        <#if screening.isBusySeat(r, s)>
                            <div class="seat" style="border: 1px solid black; width: 50px; height: 50px; margin: 1px; background: red;">
                                ${s}
                            </div>
                        <#elseif Session.cart??&&screening.chosenPlace(Session.cart, r, s, screening)>
                            <div class="seat" style="border: 1px solid black; width: 50px; height: 50px; margin: 1px; background: blue;">
                                ${s}
                            </div>
                        <#else>
                            <div class="seat" style="border: 1px solid black; width: 50px; height: 50px; margin: 1px;">
                               <a class="page-link" href="/${screening.id}/${r}/${s}">${s}</a>
                            </div>
                        </#if>
                    </#list>
                </div>
            </#list>
        </div>
        <div class="col-4">
            <#if message??>
                <div class="alert alert-danger" role="alert">
                    ${message}
                </div>
            </#if>
            <#if Session.cart??>
                <#assign total=0>
                <#list Session.cart as item>
                    <@spring.message "name"/>: ${item.screening.film.name}<br/>
                    <@spring.message "date"/>: ${item.screening.screeningDateTime.toLocalDate()}<br/>
                    <@spring.message "time"/>: ${item.screening.screeningDateTime.toLocalTime()}-${screening.screeningDateTime.plusMinutes(film.durationInMinutes).toLocalTime()}<br/>
                    <@spring.message "row"/>: ${item.numberOfrow} <@spring.message "seat"/>: ${item.seat}  <a href="/remove/${screening.id}/${item.numberOfrow}/${item.seat}">delete</a><br>
                    <#assign total+=screening.priceOfTicket>
                    <hr/>
                </#list>
                <#if total gt 0>
                    Total: ${total}
                </#if>
                <#if total gt 0>
                    <form action="/buy" method="post">
                        <input type="hidden" name="total" value="${total}">
                        <input type="hidden" name="user" value="${id}">
                        <input type="hidden" name="screening" value="${screening.id}">
                        <input type="hidden" value="${_csrf.token}" name="_csrf">
                        <button type="submit" class="btn btn-primary">Buy</button>
                    </form>
                </#if>
            </#if>
        </div>
    </div>
</@c.page>