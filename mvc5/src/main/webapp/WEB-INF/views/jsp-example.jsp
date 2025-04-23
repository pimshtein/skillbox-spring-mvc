<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.skillbox.mvc.mvc5.model.News" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%
    News news = (News) request.getAttribute("news");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
%>
<html>
<head>
    <title>Пример новости</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>Последние новости</h1>
    
    <% if (news != null) { %>
        <article>
            <h2><%= news.getTitle() %></h2>
            <p><%= news.getContent() %></p>
            <div class="news-meta">
                <span>Автор: <strong><%= news.getAuthor() %></strong></span>
                <span>Опубликовано: <time><%= news.getPublicationDate().format(formatter) %></time></span>
            </div>
        </article>
    <% } else { %>
        <p>Новости временно недоступны</p>
    <% } %>
</body>
</html>

