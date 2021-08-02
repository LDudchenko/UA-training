<#import "header.ftlh" as h>
<#import "footer.ftlh" as f>

<#macro page>
<!DOCTYPE html>
<html lang="en">
<head>
      <!-- Кодировка веб-страницы -->
        <meta charset="utf-8">
        <!-- Настройка viewport -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cinema</title>
        <!-- Bootstrap CSS (jsDelivr CDN) -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <!-- Bootstrap Bundle JS (jsDelivr CDN) -->
        <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
  <@h.header />
  <#nested>
   <@f.footer />
</body>
</html>
</#macro>