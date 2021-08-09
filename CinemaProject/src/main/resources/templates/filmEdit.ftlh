<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>

<@c.page>
<div class="row">
    <div class="col-md-3"></div>
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default" style="margin-top:45px">
                <div class="panel-heading">
                    <h3 class="panel-title"><@spring.message "film.editor"/></h3>
                </div>
                <div class="panel-body">
                    <form action="/films" enctype="multipart/form-data" method="post">
                        <div class="form-group mb-2">
                            <label for="name"><@spring.message "name"/></label>
                            <input type="text"  class="form-control" name="name" value="${film.name}">
                        </div>
                        <div class="form-group mb-2">
                            <label for="name_en"><@spring.message "name"/></label>
                            <input type="text" class="form-control" name="name_en" value="${film.name_en}">
                        </div>
                        <div class="form-group mb-2">
                            <label for="description"><@spring.message "description"/></label>
                            <textarea name="description" class="form-control" rows="4" cols="50">
                                ${film.description}
                            </textarea>
                        </div>
                        <div class="form-group mb-2">
                            <label for="description_en"><@spring.message "description"/></label>
                            <textarea name="description_en" class="form-control" rows="4" cols="50">
                                ${film.description_en}
                            </textarea>
                        </div>
                        <div class="form-group mb-2">
                            <label for="file"><@spring.message "file"/></label>
                            <input type="file" name="file" value="${film.filename}">
                        </div>
                        <input type="hidden" value="${film.id}" name="filmId">
                        <input type="hidden" value="${_csrf.token}" name="_csrf">
                        <button type="submit" class="btn btn-primary"><@spring.message "save"/></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
<a href="/films/delete/${film.id}" class="btn-ref red"><@spring.message "delete"/></a>
</@c.page>
