<%@ page import="com.sun.syndication.feed.synd.SyndFeed" %> 
<%@ page import="com.sun.syndication.feed.synd.SyndEntry" %> 
<%@ page import="java.util.Iterator" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>RSS Reader</title>
    </head>
    <body>
        <h1>Home</h1>
        <a href="rss">Refresh</a>
        <c:choose>
            <c:when test="${not empty entries}">
                <h2>${title}</h2>
                <ul>
                    <c:forEach var="entry" items="${entries}">
                        <li>
                            <a href="${entry.link}">
                                <c:out value="${entry.title}" /></a>
                        </li>
                    </c:forEach>
                </ul>
            </c:when>
        </c:choose>
    </body>
</html>
