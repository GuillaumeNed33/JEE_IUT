<!DOCTYPE html>
<html lang="fr">
<meta charset="utf-8"/>
<head>
<title>${title}</title>
</head>
<body>
<h2> QRCODE A LA COMPOTE </h2>
<ul>
<#list fakeRooms as room>
<li>
${room.name} : ${room.occupation} / ${room.capacity}
</li>
</#list>
</ul>
</body>
</html>