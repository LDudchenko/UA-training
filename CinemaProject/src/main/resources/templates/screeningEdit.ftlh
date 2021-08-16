<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>

<@c.page>
<div class="row">
    <div class="col-md-3"></div>
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default" style="margin-top:45px">
                <div class="panel-heading">
                    <h3 class="panel-title"><@spring.message "screening.editor"/></h3>
                </div>
                <div class="panel-body">
                    <form action="/screenings" method="post">
                         <div class="form-group mb-2">
                            <label for="film"><@spring.message "film"/></label>
                            <p><select size="3" name="film" class="form-control">
                                <option disabled><@spring.message "choose.film"/></option>
                                     <option selected value="${screening.film.id}">${screening.film.name}</option>
                                    <#list films as film>
                                         <option value="${film.id}">${film.name}/${film.name_en}</option>
                                    </#list>
                                </select>
                            </p>
                         </div>
                         <div class="form-group mb-2">
                            <label for="hall"><@spring.message "hall"/></label>
                            <p><select size="3" name="hall" class="form-control">
                                <option disabled><@spring.message "choose.hall"/></option>
                                    <option selected value="${screening.hall.id}">${screening.hall.name}</option>
                                    <#list halls as hall>
                                        <option value="${hall.id}">${hall.name}</option>
                                    </#list>
                                </select>
                            </p>
                         </div>
                         <div class="form-group mb-2">
                            <label for="screeningTime"><@spring.message "time"/></label>
                            <input type="time" class="form-control" name="screeningTime" value="${time}" min="09:00" max="22:00">
                        </div>
                        <div class="form-group mb-2">
                            <label for="screeningDate"><@spring.message "date"/></label>
                            <input type="date" name="screeningDate" class="form-control" value="${date}" min="${startDate}" max="${endDate}">
                        </div>
                        <input type="hidden" value="${screening.id}" name="screeningId">
                        <input type="hidden" value="${_csrf.token}" name="_csrf">
                        <button type="submit" class="btn btn-primary"><@spring.message "save"/></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
<a href="/screenings/delete/${screening.id}" class="btn-ref red"><@spring.message "delete"/></a>
</@c.page>