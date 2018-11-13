<!-- 引入标签-->
<#assign  sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
</head>
<body align="center">
<h2>Spring Security Demo</h2>

<a href="https://longfeizheng.github.io/categories/#Security">Spring Security</a>
    <@sec.authorize access="hasRole('ROLE_ADMIN')">
    </@sec.authorize>
    <@sec.authorize access="isAnonymous()">
    </@sec.authorize>
</body>
</html>