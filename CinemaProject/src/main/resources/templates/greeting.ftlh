<#import "parts/common.ftlh" as c>

<@c.page>
    <h4>Hello, guest</h4>
    <form action="/registration">
        <button type="submit" class="btn btn-primary">Регистрация</button>
    </form>
    <form action="/login">
        <button type="submit" class="btn btn-primary">Войти</button>
    </form>
</@c.page>