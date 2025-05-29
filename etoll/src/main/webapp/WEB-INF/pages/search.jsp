<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>E-Toll Collection Management System</title>
    <link rel="stylesheet" href="/style.css">
    <script src="/app.js"></script>
</head>
<body>
<div class="container">
    <button type="button" onclick="window.location.href='/'">
        <span style="font-size:1.2em;">&#8962;</span>Home
    </button>
<h3>Search by Date</h3>
<form id="searchForm">
    <label>From: <input type="date" name="fromDate" required /></label>
    <label>To: <input type="date" name="toDate" required /></label>
    <button type="submit">Search</button>
</form>
<table id="searchResults">
    <thead>
    <tr>
        <th>ID</th>
        <th>Driver Name</th>
        <th>License</th>
        <th>Vehicle Number</th>
        <th>Model</th>
        <th>Type</th>
        <th>Date</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
</div>
</body>
</html>