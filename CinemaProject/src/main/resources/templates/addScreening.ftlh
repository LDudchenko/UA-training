<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>


<@c.page>
<div class="row">
    <div class="col-md-3"></div>
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default" style="margin-top:45px">
                <div class="panel-heading">
                    <h3 class="panel-title"><@spring.message "screening.adding"/></h3>
                </div>
                <div class="panel-body">
                    <form action="/screenings/add" method="post">
                         <div class="form-group mb-2">
                            <label for="film"><@spring.message "film"/></label>
                            <p><select size="3" name="film" class="form-control" required>
                                <option disabled><@spring.message "choose.film"/></option>
                                    <#list films as film>
                                         <option value="${film.id}">${film.name}</option>
                                    </#list>
                                </select>
                            </p>
                         </div>
                         <div class="form-group mb-2">
                            <label for="hall"><@spring.message "hall"/></label>
                            <p><select size="3" name="hall" class="form-control" required>
                                <option disabled><@spring.message "choose.hall"/></option>
                                    <#list halls as hall>
                                        <option value="${hall.id}">${hall.name}</option>
                                    </#list>
                                </select>
                            </p>
                         </div>
                         <div class="form-group mb-2">
                            <label for="screeningTime"><@spring.message "time"/></label>
                            <input type="time" class="form-control" name="screeningTime" min="09:00" max="22:00" required>
                        </div>
                        <div class="form-group mb-2">
                            <label for="screeningDate"><@spring.message "date"/></label>
                            <input type="date" name="screeningDate" class="form-control" min="${startDate}" max="${endDate}" required>
                        </div>
                        <div class="form-group mb-2">
                            <label for="priceOfTicket"><@spring.message "price.of.ticket"/></label>
                            <input type="text" name="priceOfTicket" class="form-control" required>
                        </div>
                        <input type="hidden" value="${_csrf.token}" name="_csrf">
                        <button type="submit" class="btn btn-primary"><@spring.message "save"/></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@c.page>