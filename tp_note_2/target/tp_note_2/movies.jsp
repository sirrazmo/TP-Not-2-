<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <html>

    <head>
        <title>Tous les films</title>
        <meta charset="UTF-8" />
    </head>

    <body>
        <fieldset>
            <legend>Liste des films</legend>
            <table border="1" cellpadding="10" cellspacing="0" width="100%">
                <tr>
                    <th>Titre</th>
                    <th>Annee</th>
                    <th>acteurs</th>
                    <th>affiche</th>
                    <th>Augmenter</th>
                    <th>Note</th>
                    <th>Baisser</th>
                </tr>
                <c:forEach items="${requestScope.MOVIES_LIST}" var="movie">
                    <tr>
                        <td>${movie.title}</td>
                        <td>${movie.year}</td>
                        <td>${movie.actors}</td>
                        <td>${movie.imgPoster}</td>
                        <td><a href="upNote?id=${movie.id}">+</a></td>
                        <td>${movie.note}</td>
                        <td><a href="downNote?id=${movie.id}">-</a></td>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
    </body>

    </html>