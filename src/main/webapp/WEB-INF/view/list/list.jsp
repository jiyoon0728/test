<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

        <h1>게시글 목록 페이지</h1>
        <hr />
        <table border="1">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성일</th>
            </tr>
            <c:forEach items="${productList}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td><a href="/product/${product.id}">${product.name}</a></td>
                        <td>${product.price}</td>
                        <td>${product.qty}</td>
                        <td>${product.createdAtToString}</td>
                    </tr>
                </c:forEach>


        </table>
        <%@ include file="../layout/footer.jsp" %>